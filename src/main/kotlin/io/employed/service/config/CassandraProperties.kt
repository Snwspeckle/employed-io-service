package io.employed.service.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "spring.data.cassandra")
class CassandraProperties {
    lateinit var contactPoints: String
    var port: Int = 9092
    var username: String? = null
    var password: String? = null
    lateinit var keyspaceName: String
    var keyspaceReplicationFactor: Int? = 1
    var sslEnabled: Boolean = false
    lateinit var clientTruststore: String
    lateinit var trustStorePassword: String
    var slowQueryThreshold: Long = 200
}