package io.employed.service.repository

import io.employed.service.persistence.PendingMatchEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.cassandra.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PendingMatchRepository : CassandraRepository<PendingMatchEntity> {
    fun findAllByUserId(userId: UUID): List<PendingMatchEntity>

    @Query("SELECT * FROM employ.pending_matches where user_id = ?0 and match_user_id = ?1")
    fun findByUserIds(userId: UUID, matchUserId: UUID): PendingMatchEntity?
}