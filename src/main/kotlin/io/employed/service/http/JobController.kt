package io.employed.service.http

import com.google.protobuf.util.Timestamps
import io.employed.proto.Address
import io.employed.proto.Company
import io.employed.proto.Job
import io.employed.proto.JobByTagRequest
import io.employed.proto.Jobs
import io.employed.proto.Location
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
    fun getJobs(): Jobs = Jobs.newBuilder().addAllJobs(jobRepository.findAll().map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/jobs"], produces = ["application/x-protobuf", "application/json"])
    fun getJobsByTags(@RequestBody request: JobByTagRequest) : Jobs = Jobs.newBuilder().addAllJobs(jobRepository.findByTags(request.tagsList).map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/jobs/{id}"], produces = ["application/x-protobuf", "application/json"])
    fun getJobById(@PathVariable id: String): Job = jobRepository.findByJobId(UUID.fromString(id)).toProto()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/jobs/create"], produces = ["application/x-protobuf", "application/json"])
    fun createJob(@RequestBody job: Job): Job = jobRepository.insert(job.toEntity()).toProto()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/jobs/mock"], produces = ["application/x-protobuf", "application/json"])
    fun generateMockJobData(): Job {
        val newJob = Job.newBuilder().setJobId(UUID.randomUUID().toString())
            .setCreationDate(Timestamps.fromMillis(System.currentTimeMillis()))
            .setTitle("Software Engineer")
            .setDescription("Creating software for QuickBooks Online in a react native plugin architecture")
            .setShortDescription("Creating software for QuickBooks")
            .setCompany(Company.newBuilder().setCompanyId(UUID.randomUUID().toString())
                .setName("Intuit")
                .setAvatarUrl("http://newpick.com/pic1.png")
            ).setRecruiter(Job.Recruiter.newBuilder().setFirstName("Aaron").setLastName("Triplett"))
            .setCatergoryType(Job.CatergoryType.ENGINEERING)
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
            )
            .setNumberOfHires(1)
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