package io.employed.service.repository

import io.employed.service.persistence.JobEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.cassandra.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface JobRepository : CassandraRepository<JobEntity> {
    fun findByJobId(jobId: UUID): JobEntity

    @Query("SELECT * FROM employ.jobs where tags CONTAINS ?0")
    fun findAllByTag(tag: String): List<JobEntity>
}