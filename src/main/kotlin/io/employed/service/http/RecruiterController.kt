package io.employed.service.http

import io.employed.proto.Recruiter
import io.employed.proto.RecruitersResponse
import io.employed.service.persistence.toProto
import io.employed.service.repository.RecruiterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(value = ["api"])
class RecruiterController {

    @Autowired
    lateinit var recruiterRepository: RecruiterRepository

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/recruiters"], produces = ["application/x-protobuf", "application/json"])
    fun getRecruiters(): RecruitersResponse = RecruitersResponse.newBuilder().addAllRecruiters(recruiterRepository.findAll().map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/recruiters/{userId}"], produces = ["application/x-protobuf", "application/json"])
    fun getRecruiterById(@PathVariable userId: String): Recruiter = recruiterRepository.findByUserId(UUID.fromString(userId)).toProto()
}