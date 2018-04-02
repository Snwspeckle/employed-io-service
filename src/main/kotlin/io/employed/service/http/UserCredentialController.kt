package io.employed.service.http

import io.employed.proto.LoginRequest
import io.employed.proto.LoginResponse
import io.employed.proto.Status
import io.employed.proto.User
import io.employed.service.persistence.toProto
import io.employed.service.repository.JobSeekerRepository
import io.employed.service.repository.RecruiterRepository
import io.employed.service.repository.UserCredentialRepository
import io.employed.service.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["api"])
class UserCredentialController {

    @Autowired
    lateinit var userCredentialRepository: UserCredentialRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var jobSeekerRepository: JobSeekerRepository

    @Autowired
    lateinit var recruiterRepository: RecruiterRepository

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/login"], produces = ["application/x-protobuf", "application/json"])
    fun login(@RequestBody loginRequest: LoginRequest): LoginResponse {

        val userCredentialEntity = userCredentialRepository.findByLogin(loginRequest.login)
        val loginResponseBuilder = LoginResponse.newBuilder()

        return when {
            userCredentialEntity.password == loginRequest.password -> {
                val userId = userCredentialEntity.userId
                val user = userRepository.findByUserId(userId)

                return when (user.role) {
                    User.Role.JOB_SEEKER.name -> loginResponseBuilder.setJobSeeker(jobSeekerRepository.findByUserId(userId).toProto())
                    User.Role.RECRUITER.name -> loginResponseBuilder.setRecruiter(recruiterRepository.findByUserId(userId).toProto())
                    else -> loginResponseBuilder
                }.setUser(user.toProto()).setStatus(Status.SUCCESS).build()
            }
            else -> loginResponseBuilder.setStatus(Status.FAILURE)
        }.build()
    }
}