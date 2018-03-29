package io.employed.service.repository

import io.employed.service.persistence.UserEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : CassandraRepository<UserEntity> {
    fun findByUserId(userId: UUID): UserEntity
}