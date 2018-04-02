package io.employed.service.repository

import io.employed.service.persistence.RejectedMatchEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.cassandra.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RejectedMatchRepository : CassandraRepository<RejectedMatchEntity> {
    fun findAllByUserId(userId: UUID): List<RejectedMatchEntity>

    @Query("SELECT * FROM employ.rejected_matches where user_id = ?0 and match_user_id = ?1")
    fun findByUserIdAndMatchUserId(userId: UUID, matchUserId: UUID): RejectedMatchEntity
}