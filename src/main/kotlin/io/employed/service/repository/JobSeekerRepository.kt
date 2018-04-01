package io.employed.service.repository

import io.employed.service.persistence.JobSeekerEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.cassandra.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface JobSeekerRepository : CassandraRepository<JobSeekerEntity> {
    fun findByUserId(userId: UUID): JobSeekerEntity

    @Query("SELECT * FROM employ.job_seekers where tags CONTAINS ?0")
    fun findAllByTag(tag: String): List<JobSeekerEntity>
}