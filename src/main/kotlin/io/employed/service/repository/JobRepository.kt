package io.employed.service.repository

import io.employed.proto.Job

interface JobRepository {
    fun findById(id: Int): Job
    fun findAll(): List<Job>
}