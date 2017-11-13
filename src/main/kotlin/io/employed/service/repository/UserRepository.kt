package io.employed.service.repository

import io.employed.proto.User

interface UserRepositoryContract {
    fun findById(id: Int): User?
    fun findAll(): List<User>
}