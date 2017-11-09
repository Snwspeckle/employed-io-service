package io.employed.service

import io.employer.proto.UserProto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    @Autowired
    lateinit var userRepository: UserRepository

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello there, $name")

    @GetMapping("/user", produces = arrayOf("application/json"))
    fun user(@RequestParam(value = "email", defaultValue = "email") email: String): UserProto.User??? {
        return userRepository.getUser(email)
    }
}