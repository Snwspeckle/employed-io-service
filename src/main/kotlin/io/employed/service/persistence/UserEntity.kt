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
    val matches: List<String>,

    @Column(value = "pending_matches")
    val pendingMatches: List<String>,

    @Column(value = "rejected_matches")
    val rejectedMatches: List<String>
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

fun User.toEntity(uuid: UUID? = null): UserEntity = UserEntity(uuid?.let { it } ?: UUID.fromString(userId),
    role.name,
    handle,
    login,
    password,
    matchesList,
    pendingMatchesList,
    rejectedMatchesList
)