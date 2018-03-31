package io.employed.service.twilio

import com.twilio.Twilio
import com.twilio.rest.chat.v2.service.Channel
import com.twilio.rest.chat.v2.service.channel.Member
import com.twilio.rest.chat.v2.service.channel.Message
import com.twilio.rest.video.v1.Room

class TwilioWrapper {
    companion object {
        init {
            Twilio.init(TwilioAPIConstants.ACCOUNT_SID, TwilioAPIConstants.AUTH_TOKEN)
        }

        object TwilioAPIConstants {
            const val ACCOUNT_SID = ""
            const val AUTH_TOKEN = ""
            const val SERVICE_SID = ""
        }

        fun createChannel(friendlyName: String, uniqueName: String): String {
            return Channel.creator(TwilioAPIConstants.SERVICE_SID)
                    .setFriendlyName(friendlyName)
                    .setUniqueName(uniqueName)
                    .create()
                    .sid
        }

        fun addMember(channelId: String, identity: String): String {
            return Member.creator(TwilioAPIConstants.SERVICE_SID, channelId, identity)
                    .create()
                    .sid
        }

        fun addMessage(channelId: String, messageText: String) {
            Message.creator(TwilioAPIConstants.SERVICE_SID, channelId)
                    .setBody(messageText)
                    .create()
        }

        fun deleteChannel(channelId: String) = Channel.deleter(TwilioAPIConstants.SERVICE_SID, channelId)

        fun createRoom(uniqueName: String) = Room.creator().setUniqueName(uniqueName).create()

        fun fetchRoomStatus(uniqueName: String): String = Room.fetcher(uniqueName).fetch()?.status.toString()
    }
}