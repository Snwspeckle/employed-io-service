package io.employed.service.http

import io.employed.proto.Job
import io.employed.proto.User
import io.employed.service.repository.JobRepositoryContract
import io.employed.service.repository.UserRepositoryContract
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong


@RestController
@RequestMapping(value = ["api"])
class CustomerRestController {

    @Autowired
    private lateinit var jobRepository: JobRepositoryContract

    @Autowired
    private lateinit var userRepository: UserRepositoryContract

    var messageCounter = AtomicLong()

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/jobs", produces = arrayOf("application/x-protobuf", "application/json"))
    fun jobs() : List<Job> {
        return jobRepository.findAll()
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/jobs/{id}", produces = arrayOf("application/x-protobuf", "application/json"))
    fun job(@PathVariable id: Int) : Job? {
        return jobRepository.findById(id)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/users", produces = arrayOf("application/x-protobuf", "application/json"))
    fun users() : List<User> {
        return userRepository.findAll()
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/users/{id}", produces = arrayOf("application/x-protobuf", "application/json"))
    fun user(@PathVariable id: Int) : User? {
        return userRepository.findById(id)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/message", produces = arrayOf("application/x-protobuf", "application/json"))
    fun message() : String? {
        //NOTE: THIS WILL BE REMOVED AFTER DEMO
        val messageCounterInt = messageCounter.getAndIncrement().toInt()
        var returnString = ""

        when (messageCounterInt) {
            0 -> returnString = "Glad to hear!  We're very excited to share this potential opportunity with you."
        }
        return returnString
    }
}