package io.employed.service.http

import io.employed.proto.Job
import io.employed.proto.User
import io.employed.service.repository.JobRepositoryContract
import io.employed.service.repository.UserRepositoryContract
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = "api")
class CustomerRestController {

    @Autowired
    private lateinit var jobRepository: JobRepositoryContract

    @Autowired
    private lateinit var userRepository: UserRepositoryContract

    @GetMapping("/jobs/{id}")
    fun job(@PathVariable id: Int) : Job? {
        return jobRepository.findById(id)
    }

    @GetMapping("/Users")
    fun users() : List<User> {
        return userRepository.findAll()
    }
}