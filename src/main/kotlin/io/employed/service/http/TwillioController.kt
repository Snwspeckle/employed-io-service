package io.employed.service.http

import io.employed.service.persistence.UserEntity
import io.employed.service.repository.UserRepository
import io.employed.service.twilio.TwilioWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping(value = ["api"])
class TwillioController {

    @Autowired
    lateinit var userRepository: UserRepository

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/chat/createChannel/{userId}/{recruiterId}"], produces = ["application/x-protobuf", "application/json"])
    fun createChannel(@PathVariable jobSeekerId: UUID, @PathVariable recruiterId: UUID): String {
        val jobSeekerUserEntity = userRepository.findByUserId(jobSeekerId)
        val recruiterUserEntity = userRepository.findByUserId(recruiterId)

        val channelId = TwilioWrapper.createChannel("Chat", createUniqueIdentifier(jobSeekerUserEntity, recruiterUserEntity))
        TwilioWrapper.addMember(channelId, jobSeekerUserEntity.login)
        TwilioWrapper.addMember(channelId, recruiterUserEntity.login)
        return channelId
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST), value = ["/chat/deleteChannel/{channelId}"], produces = ["application/x-protobuf", "application/json"])
    fun deleteChannel(@PathVariable channelId: String) = TwilioWrapper.deleteChannel(channelId)

    @RequestMapping(method = arrayOf(RequestMethod.POST), value = ["/chat/addMessage/{channelId}/{messageText}"], produces = ["application/x-protobuf", "application/json"])
    fun addMessage(@PathVariable channelId: String, @PathVariable messageText: String) = TwilioWrapper.addMessage(channelId, messageText)

    @RequestMapping(method = arrayOf(RequestMethod.POST), value = ["/video/createRoom/{userId}/{recruiterId}"], produces = ["application/x-protobuf", "application/json"])
    fun createRoom(@PathVariable userId: UUID, @PathVariable recruiterId: UUID) {
        val userEntity = userRepository.findByUserId(userId)
        val recruiterEntity = userRepository.findByUserId(recruiterId)
        TwilioWrapper.createRoom(createUniqueIdentifier(userEntity, recruiterEntity))
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = ["/video/roomStatus/{uniqueName}"], produces = ["application/x-protobuf", "application/json"])
    fun fetchRoomStatus(@PathVariable uniqueName: String): String = TwilioWrapper.fetchRoomStatus(uniqueName)
    fun createUniqueIdentifier(userEntity: UserEntity, recruiterEntity: UserEntity) : String = (userEntity.hashCode() + recruiterEntity.hashCode()).toString()
}