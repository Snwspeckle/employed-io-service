package io.employed.service.http

import io.employed.proto.JobSeeker
import io.employed.proto.JobSeekersByTagsRequest
import io.employed.proto.JobSeekersByTagsResponse
import io.employed.proto.JobSeekersResponse
import io.employed.service.persistence.toProto
import io.employed.service.repository.JobSeekerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(value = ["api"])
class JobSeekerController {

    @Autowired
    lateinit var jobSeekerRepository: JobSeekerRepository

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/jobseekers"], produces = ["application/x-protobuf", "application/json"])
    fun getJobSeekers(): JobSeekersResponse = JobSeekersResponse.newBuilder().addAllJobSeekers(jobSeekerRepository.findAll().map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/jobseekers/{userId}"], produces = ["application/x-protobuf", "application/json"])
    fun getJobSeekerById(@PathVariable userId: String): JobSeeker = jobSeekerRepository.findByUserId(UUID.fromString(userId)).toProto()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/jobseekers"], produces = ["application/x-protobuf", "application/json"])
    fun getJobsByTags(@RequestBody jobSeekersByTagsRequest: JobSeekersByTagsRequest) : JobSeekersByTagsResponse {
        val tags = jobSeekersByTagsRequest.tagsList
        return JobSeekersByTagsResponse.newBuilder().addAllJobSeekers(tags.map { tag -> jobSeekerRepository.findAllByTag(tag).map { it.toProto() }}.flatten()).build()
    }
}