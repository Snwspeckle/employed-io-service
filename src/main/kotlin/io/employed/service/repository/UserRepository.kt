package io.employed.service.repository

import io.employed.proto.User

interface UserRepository {
    fun findById(id: Int): User
    fun findAll(): List<User>
}