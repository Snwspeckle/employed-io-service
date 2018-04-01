package io.employed.service.repository

import io.employed.service.persistence.RecruiterEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RecruiterRepository : CassandraRepository<RecruiterEntity> {
    fun findByUserId(userId: UUID): RecruiterEntity
}