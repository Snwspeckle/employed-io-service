package io.employed.service.http

import com.datastax.driver.core.utils.UUIDs
import io.employed.proto.Address
import io.employed.proto.Company
import io.employed.proto.CreateJobRequest
import io.employed.proto.CreateJobResponse
import io.employed.proto.Industry
import io.employed.proto.Job
import io.employed.proto.JobsByTagsRequest
import io.employed.proto.JobsByTagsResponse
import io.employed.proto.JobsResponse
import io.employed.proto.Location
import io.employed.proto.Recruiter
import io.employed.proto.Status
import io.employed.service.persistence.toEntity
import io.employed.service.persistence.toProto
import io.employed.service.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(value = ["api"])
class JobController {

    @Autowired
    lateinit var jobRepository: JobRepository

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/jobs"], produces = ["application/x-protobuf", "application/json"])
    fun getJobs(): JobsResponse = JobsResponse.newBuilder().addAllJobs(jobRepository.findAll().map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/jobs/{jobId}"], produces = ["application/x-protobuf", "application/json"])
    fun getJobById(@PathVariable jobId: String): Job = jobRepository.findByJobId(UUID.fromString(jobId)).toProto()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/jobs"], produces = ["application/x-protobuf", "application/json"])
    fun getJobsByTags(@RequestBody jobsByTagsRequest: JobsByTagsRequest) : JobsByTagsResponse {
        val tags = jobsByTagsRequest.tagsList
        return JobsByTagsResponse.newBuilder().addAllJobs(tags.map { tag -> jobRepository.findAllByTag(tag).map { it.toProto() }}.flatten()).build()
    }

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/jobs/create"], produces = ["application/x-protobuf", "application/json"])
    fun createJob(@RequestBody createJobRequest: CreateJobRequest): CreateJobResponse = CreateJobResponse.newBuilder()
        .setJob(jobRepository.insert(createJobRequest.job.toEntity(UUIDs.timeBased(), UUIDs.timeBased())).toProto())
        .setStatus(Status.SUCCESS)
        .build()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/jobs/mock"], produces = ["application/x-protobuf", "application/json"])
    fun generateMockJobData(): Job {
        val newJob = Job.newBuilder().setJobId(UUIDs.timeBased().toString())
            .setTitle("Software Engineer")
            .setDescription("Creating software for QuickBooks Online in a react native plugin architecture")
            .setShortDescription("Creating software for QuickBooks")
            .setCompany(Company.newBuilder().setCompanyId(UUIDs.timeBased().toString())
                .setName("Intuit")
                .setAvatarUrl("http://newpick.com/pic1.png")
            ).setRecruiter(Recruiter.newBuilder().setUserId(UUIDs.timeBased().toString()).setFirstName("Aaron").setLastName("Triplett"))
            .setIndustry(Industry.ENGINEERING)
            .setEmploymentType(Job.EmploymentType.FULL_TIME)
            .setSalary(123000)
            .setLocation(Location.newBuilder()
                .setLatitude(37.4622762)
                .setLongitude(-122.1347582)
                .setAddress(Address.newBuilder()
                    .setStreetAddress("612 Montage Circle")
                    .setCity("East Palo Alto")
                    .setState("CA")
                    .setCountry("US")
                    .setZip("94303")
                )
            ).setNumberOfHires(1)
            .setRequiredExperience("Must be experience in react native")
            .setPreferredExperience("Flux, HTML, JS")
            .addAllSkills(listOf("Engineering", "React native", "Flux"))
            .setResponsibilities("Create react native plugins")
            .setExperience(4)
            .addAllEducationLevel(listOf(Job.EducationLevel.BACHELORS_DEGREE))
            .addAllTags(listOf("Engineering", "React native", "Flux"))
            .build()

        return jobRepository.insert(newJob.toEntity()).toProto()
    }
}