package io.employed.service.config

import com.datastax.driver.core.PlainTextAuthProvider
import com.datastax.driver.core.QueryLogger
import io.employed.service.util.SpringBootLocationScanner
import org.cognitor.cassandra.migration.Database
import org.cognitor.cassandra.migration.MigrationRepository
import org.cognitor.cassandra.migration.MigrationTask
import org.cognitor.cassandra.migration.collector.FailOnDuplicatesCollector
import org.cognitor.cassandra.migration.keyspace.Keyspace
import org.cognitor.cassandra.migration.keyspace.SimpleStrategy
import org.cognitor.cassandra.migration.scanner.ScannerRegistry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration
import java.io.IOException

@Configuration
class CassandraConfig(@Autowired val cassandraProperties: CassandraProperties) : AbstractCassandraConfiguration() {
    override fun getKeyspaceName(): String = "employ"
    
    @Bean
    override fun cluster(): CassandraClusterFactoryBean {
        val cluster = CassandraClusterFactoryBean()

        cluster.setLatencyTracker(QueryLogger.builder().withConstantThreshold(cassandraProperties.slowQueryThreshold).build())
        cluster.setContactPoints(cassandraProperties.contactPoints)
        cluster.setPort(cassandraProperties.port)
        cluster.setSslEnabled(cassandraProperties.sslEnabled)
        cluster.setAuthProvider(PlainTextAuthProvider(cassandraProperties.username, cassandraProperties.password))

        return cluster
    }

    @Bean
    @DependsOn("database")
    @Throws(ClassNotFoundException::class)
    override fun session(): CassandraSessionFactoryBean {
        return super.session()
    }

    @Bean
    @Throws(IOException::class)
    fun database(): Database {
        val scannerRegistry = ScannerRegistry()
        val scanner = SpringBootLocationScanner()
        val keyspace = Keyspace(cassandraProperties.keyspaceName)
            .with(SimpleStrategy(cassandraProperties.keyspaceReplicationFactor!!))

        scannerRegistry.register(ScannerRegistry.FILE_SCHEME, scanner)
        scannerRegistry.register(ScannerRegistry.JAR_SCHEME, scanner)

        val database = Database(cluster().`object`, keyspace)
        val migration = MigrationTask(database, MigrationRepository("db/", FailOnDuplicatesCollector(), scannerRegistry))
        migration.migrate()
        return database
    }
}