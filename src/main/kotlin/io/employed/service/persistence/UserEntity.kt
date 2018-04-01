package io.employed.service.persistence

import io.employed.proto.User
import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table
import java.util.UUID

@Table(value = "users")
data class UserEntity(
    @PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    val userId: UUID,

    @Column
    val role: String,

    @Column
    val handle: String,

    @Column
    val login: String,

    @Column
    val password: String,

    @Column
    val matches: MutableList<String>,

    @Column(value = "pending_matches")
    val pendingMatches: MutableList<String>,

    @Column(value = "rejected_matches")
    val rejectedMatches: MutableList<String>
)

fun UserEntity.toProto(): User = User.newBuilder()
    .setUserId(userId.toString())
    .setRole(User.Role.valueOf(role))
    .setHandle(handle)
    .setLogin(login)
    .setPassword(password)
    .addAllMatches(matches)
    .addAllPendingMatches(pendingMatches)
    .addAllRejectedMatches(rejectedMatches)
    .build()

fun User.toEntity(userUUID: UUID? = null): UserEntity = UserEntity(userUUID?.let { it } ?: UUID.fromString(userId),
    role.name,
    handle,
    login,
    password,
    matchesList,
    pendingMatchesList,
    rejectedMatchesList
)