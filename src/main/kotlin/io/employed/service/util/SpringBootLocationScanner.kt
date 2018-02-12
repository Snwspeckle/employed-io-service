package io.employed.service.util

import org.cognitor.cassandra.migration.scanner.LocationScanner
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import java.io.IOException
import java.net.URI
import java.util.HashSet

class SpringBootLocationScanner : LocationScanner {
    private val resourcePatternResolver = PathMatchingResourcePatternResolver()

    @Throws(IOException::class)
    override fun findResourceNames(location: String, locationUri: URI): Set<String> {
        val resources = resourcePatternResolver.getResources(location + "*.cql")

        val resourcePaths = HashSet<String>()
        resources.forEachIndexed { i, _ ->
            resourcePaths.add(location + resources[i].filename)
        }
        return resourcePaths
    }
}