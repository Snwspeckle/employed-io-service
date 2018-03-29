package io.employed.service.repository

import io.employed.service.persistence.JobEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface JobRepository : CassandraRepository<JobEntity> {
    fun findByJobId(jobId: UUID): JobEntity
    fun findByTags(tags: List<String>): List<JobEntity>
}