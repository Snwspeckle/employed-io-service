package io.employed.service.twilio

import com.twilio.Twilio
import com.twilio.rest.chat.v2.service.Channel
import com.twilio.rest.chat.v2.service.channel.Member
import com.twilio.rest.chat.v2.service.channel.Message
import com.twilio.rest.video.v1.Room
import io.employed.service.persistence.UserEntity
import org.springframework.stereotype.Component

@Component
class TwilioService {

    enum class Credentials {
        AUTH_TOKEN {
            override val value: String = "SKbbf6020caa0e9ff75dea8cd9ba0b321b"
        },
        ACCOUNT_SID {
            override val value: String = "AC3bbd88ffe6131533f45277c4f478cfd4"
        },
        CHAT_SERVICE_SID {
            override val value: String = "IS4f6fe4a15e8046808a3f439f3381d6be"
        };

        abstract val value: String
    }

    init {
        Twilio.init(Credentials.ACCOUNT_SID.value, Credentials.AUTH_TOKEN.value)
    }

    // Creates a channel, adds the users, and returns the channelId to be stored
    fun createChannel(userEntity: UserEntity, matchUserEntity: UserEntity): String {
        val userId = userEntity.userId.toString()
        val matchUserId = matchUserEntity.userId.toString()
        val channelName = "${userEntity.handle}, ${matchUserEntity.handle}"

        val channel = Channel.creator(Credentials.CHAT_SERVICE_SID.value)
            .setFriendlyName(channelName)
            .setUniqueName(createUniqueChannelName(userId, matchUserId))
            .create()

        Member.creator(Credentials.CHAT_SERVICE_SID.value, channel.sid, userId).create()
        Member.creator(Credentials.CHAT_SERVICE_SID.value, channel.sid, matchUserId).create()

        return channel.sid
    }

    fun addMessage(channelId: String, messageText: String) {
        Message.creator(Credentials.CHAT_SERVICE_SID.value, channelId)
            .setBody(messageText)
            .create()
    }

    fun deleteChannel(channelId: String) = Channel.deleter(Credentials.CHAT_SERVICE_SID.value, channelId)

    fun createRoom(uniqueName: String) = Room.creator().setUniqueName(uniqueName).create()

    fun fetchRoomStatus(uniqueName: String): String = Room.fetcher(uniqueName).fetch()?.status.toString()

    private fun createUniqueChannelName(userId: String, matchUserId: String): String = (userId.hashCode() + matchUserId.hashCode()).toString()
}