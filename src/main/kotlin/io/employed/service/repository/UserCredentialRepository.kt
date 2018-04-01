package io.employed.service.repository

import io.employed.service.persistence.UserCredentialEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface UserCredentialRepository : CassandraRepository<UserCredentialEntity> {
    fun findByLogin(login: String): UserCredentialEntity
}