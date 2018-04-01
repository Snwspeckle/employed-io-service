package io.employed.service.http

import com.datastax.driver.core.utils.UUIDs
import io.employed.proto.CreateMatchRequest
import io.employed.proto.CreateMatchResponse
import io.employed.proto.Match
import io.employed.proto.MatchesResponse
import io.employed.proto.RejectMatchRequest
import io.employed.proto.RejectMatchResponse
import io.employed.proto.Status
import io.employed.service.persistence.MatchEntity
import io.employed.service.persistence.toProto
import io.employed.service.repository.MatchRepository
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
class MatchController {

    @Autowired
    lateinit var matchRepository: MatchRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/match"], produces = ["application/x-protobuf", "application/json"])
    fun getMatches(): MatchesResponse = MatchesResponse.newBuilder().addAllMatch(matchRepository.findAll().map { it.toProto() }).build()

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/match/{matchId}"], produces = ["application/x-protobuf", "application/json"])
    fun getMatchById(@PathVariable matchId: String): Match = matchRepository.findByMatchId(UUID.fromString(matchId)).toProto()

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/match/create"], produces = ["application/x-protobuf", "application/json"])
    fun createMatch(@RequestBody createMatchRequest: CreateMatchRequest): CreateMatchResponse {

        val userId = createMatchRequest.userId
        val user = userRepository.findByUserId(UUID.fromString(userId))

        val matchUserId = createMatchRequest.matchUserId
        val matchUser = userRepository.findByUserId(UUID.fromString(matchUserId))

        return when {
            matchUser.pendingMatches.contains(userId) -> {

                val match = matchRepository.insert(MatchEntity(UUIDs.timeBased(), UUID.randomUUID().toString(), listOf(userId, matchUserId)))
                val matchId = match.matchId.toString()
                val channelId = match.channelId

                user.matches += matchId
                matchUser.matches += matchId

                user.pendingMatches -= matchUserId
                matchUser.pendingMatches -= userId

                //Update to use twillio channelId API
                CreateMatchResponse.newBuilder().setMatch(Match.newBuilder()
                    .setMatchId(matchId)
                    .setChannelId(channelId)
                    .addAllUsers(userRepository.save(listOf(user, matchUser)).map { it.userId.toString() })
                ).setStatus(Status.SUCCESS)
            }
            else -> {
                user.pendingMatches += matchUserId
                CreateMatchResponse.newBuilder().setStatus(Status.FAILURE)
            }
        }.build()
    }

    @RequestMapping(method = [(RequestMethod.POST)], value = ["/match/reject"], produces = ["application/x-protobuf", "application/json"])
    fun rejectMatch(@RequestBody rejectMatchRequest: RejectMatchRequest): RejectMatchResponse {

        val userId = rejectMatchRequest.userId
        val matchUserId = rejectMatchRequest.matchUserId
        val user = userRepository.findByUserId(UUID.fromString(userId))

        user.rejectedMatches += matchUserId
        return RejectMatchResponse.newBuilder().setStatus(Status.SUCCESS).build()
    }
}