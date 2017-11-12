package io.employed.service.http

import io.employed.proto.Job
import io.employed.proto.User
import io.employed.service.Greeting
import io.employed.service.repository.JobRepository
import io.employed.service.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping(value = "api")
class CandidateServiceHttp {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var jobRepository: JobRepository

    val counter = AtomicLong()
    var indexCounter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
        Greeting(counter.incrementAndGet(), "Hello there, $name")

    @GetMapping("/user", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun user(@RequestParam(value = "email", defaultValue = "email") email: String): User {
        return userRepository.getUser(email)
    }

    @GetMapping("/connections", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun connections(@RequestParam(value = "email") email: String): Job {
        val user = userRepository.getUser(email)

        if (user != null) {
            jobRepository.createJobs(user)
            val jobList = jobRepository.jobMap.get(user.email)

            val checkAgainst = indexCounter.getAndIncrement().toInt()

            if (jobList != null) {
                for ((index, value) in jobList.withIndex()) {
                    if (checkAgainst == index) {
                        if (checkAgainst == jobList.size - 1) {
                            indexCounter = AtomicLong()
                        }
                        return value
                    }
                }
            }
        }
        return null
    }

}