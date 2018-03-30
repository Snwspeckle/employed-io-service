package io.employed.service.http

import com.datastax.driver.core.utils.UUIDs
import com.google.protobuf.util.Timestamps
import io.employed.proto.User
import io.employed.proto.Users
import io.employed.service.persistence.toEntity
import io.employed.service.persistence.toProto
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

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/users"], produces = ["application/x-protobuf", "application/json"])
    fun getUsers(): Users = Users.newBuilder().addAllUsers(userRepository.findAll().map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/users/{id}"], produces = ["application/x-protobuf", "application/json"])
    fun getUserById(@PathVariable id: String): User = userRepository.findByUserId(UUID.fromString(id)).toProto()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/users"], produces = ["application/x-protobuf", "application/json"])
    fun createUser(@RequestBody user: User): User = userRepository.insert(user.toEntity(UUIDs.timeBased())).toProto()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/users/mock"], produces = ["application/x-protobuf", "application/json"])
    fun generateMockUserData(): User {
        val newUser = User.newBuilder().setUserId(UUIDs.timeBased().toString())
            .setFirstName("Aaron")
            .setLastName("Triplett")
            .setBio("Hey, I'm Aaron.")
            .setEmail("AaronDouglasTriplett@gmail.com")
            .setHandle("AaronTriplett")
            .setPhoneNumber("567-342-2660")
            .build()
        return userRepository.insert(newUser.toEntity()).toProto()
    }
}