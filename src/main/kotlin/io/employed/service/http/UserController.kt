package io.employed.service.http

import io.employed.proto.User
import io.employed.proto.Users
import io.employed.service.persistence.toProto
import io.employed.service.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["api"])
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/users"], produces = ["application/x-protobuf", "application/json"])
    fun users() : Users = Users.newBuilder().addAllUser(userRepository.findAll().map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/users/{id}"], produces = ["application/x-protobuf", "application/json"])
    fun user(@PathVariable id: String) : User = userRepository.findByUserId(id).toProto()

}