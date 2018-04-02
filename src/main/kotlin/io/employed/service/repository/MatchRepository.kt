package io.employed.service.repository

import io.employed.service.persistence.MatchEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.cassandra.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MatchRepository : CassandraRepository<MatchEntity> {
    fun findByMatchId(matchId: UUID): MatchEntity

    @Query("SELECT * FROM employ.matches where user_ids CONTAINS ?0")
    fun findAllByUserId(userId: UUID): List<MatchEntity>
}