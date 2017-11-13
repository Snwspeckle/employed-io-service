package io.employed.service.repository

import io.employed.proto.Job

interface JobRepositoryContract {
    fun findById(id: Int): Job?
    fun findAll(): List<Job>
}