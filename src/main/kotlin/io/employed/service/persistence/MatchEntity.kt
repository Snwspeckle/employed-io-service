package io.employed.service.persistence

import io.employed.proto.Match
import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table
import java.util.UUID

@Table(value = "matches")
data class MatchEntity(
    @PrimaryKeyColumn(name = "match_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    val matchId: UUID,

    @Column(value = "channel_id")
    val channelId: String,

    @Column
    val users: List<String>
)

fun MatchEntity.toProto(): Match = Match.newBuilder()
    .setMatchId(matchId.toString())
    .setChannelId(channelId)
    .addAllUsers(users)
    .build()

//Update to use twillio channelId API
fun Match.toEntity(matchUUID: UUID? = null, channelUUID: String? = null): MatchEntity = MatchEntity(matchUUID?.let { it } ?: UUID.fromString(matchId),
    channelUUID?.let { it } ?: channelId,
    usersList
)