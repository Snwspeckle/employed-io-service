package io.employed.service.http

import com.datastax.driver.core.utils.UUIDs
import io.employed.proto.Address
import io.employed.proto.CreateUserRequest
import io.employed.proto.CreateUserResponse
import io.employed.proto.Industry
import io.employed.proto.JobSeeker
import io.employed.proto.Location
import io.employed.proto.Status
import io.employed.proto.User
import io.employed.proto.UsersResponse
import io.employed.service.persistence.UserCredentialEntity
import io.employed.service.persistence.toEntity
import io.employed.service.persistence.toProto
import io.employed.service.repository.JobSeekerRepository
import io.employed.service.repository.RecruiterRepository
import io.employed.service.repository.UserCredentialRepository
import io.employed.service.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(value = ["api"])
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userCredentialRepository: UserCredentialRepository

    @Autowired
    lateinit var jobSeekerRepository: JobSeekerRepository

    @Autowired
    lateinit var recruiterRepository: RecruiterRepository

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/users"], produces = ["application/x-protobuf", "application/json"])
    fun getUsers(): UsersResponse = UsersResponse.newBuilder().addAllUsers(userRepository.findAll().map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/users/{userId}"], produces = ["application/x-protobuf", "application/json"])
    fun getUserById(@PathVariable userId: String): User = userRepository.findByUserId(UUID.fromString(userId)).toProto()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/users/create"], produces = ["application/x-protobuf", "application/json"])
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): CreateUserResponse {

        val userId = UUIDs.timeBased()
        val responseBuilder = CreateUserResponse.newBuilder().setUser(userRepository.insert(createUserRequest.user.toEntity(userId)).toProto())

        userCredentialRepository.insert(UserCredentialEntity(responseBuilder.user.login, responseBuilder.user.password, UUID.fromString(responseBuilder.user.userId)))

        return when (createUserRequest.userTypeCase) {
            CreateUserRequest.UserTypeCase.JOB_SEEKER -> responseBuilder.setJobSeeker(jobSeekerRepository.insert(createUserRequest.jobSeeker.toEntity(userId)).toProto()).setStatus(Status.SUCCESS)
            CreateUserRequest.UserTypeCase.RECRUITER -> responseBuilder.setRecruiter(recruiterRepository.insert(createUserRequest.recruiter.toEntity(userId)).toProto()).setStatus(Status.SUCCESS)
            else -> CreateUserResponse.newBuilder().setStatus(Status.FAILURE)
        }.build()
    }

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/users/mock"], produces = ["application/x-protobuf", "application/json"])
    fun generateMockUserData(): CreateUserResponse {
        val userId = UUIDs.timeBased().toString()
        return CreateUserResponse.newBuilder()
            .setUser(User.newBuilder()
                .setUserId(userId)
                .setRole(User.Role.JOB_SEEKER)
                .setHandle("@AaronTriplett")
                .setLogin("AaronDouglasTriplett@gmail.com")
                .setPassword("test1234")
                .addAllMatches(listOf(UUIDs.timeBased().toString()))
                .addAllPendingMatches(listOf(UUIDs.timeBased().toString(), UUIDs.timeBased().toString(), UUIDs.timeBased().toString()))
                .addAllRejectedMatches(listOf(UUIDs.timeBased().toString(), UUIDs.timeBased().toString(), UUIDs.timeBased().toString(), UUIDs.timeBased().toString()))
            ).setJobSeeker(JobSeeker.newBuilder()
                .setUserId(userId)
                .setFirstName("Aaron")
                .setLastName("Triplett")
                .setEmail("AaronDouglasTriplett@gmail.com")
                .setPhoneNumber("567-342-2660")
                .setBio("Hey, I'm Aaron, a software engineer!")
                .setAvatarUrl("http://imgur.com/aaron.png")
                .setHeadline("Software Engineer @ Intuit")
                .setCurrentPosition("Senior Software Engineer")
                .setIndustry(Industry.ENGINEERING)
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
                ).addAllSkills(listOf("Engineering", "React native", "Flux"))
                .addAllTags(listOf("Engineering", "React native", "Flux"))
            ).setStatus(Status.SUCCESS)
            .build()
    }
}