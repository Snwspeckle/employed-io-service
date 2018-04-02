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
    val password: String
)

fun UserEntity.toProto(matches: List<String>? = null, pendingMatches: List<String>? = null, rejectedMatches: List<String>? = null): User {
    var user = User.newBuilder()
        .setUserId(userId.toString())
        .setRole(User.Role.valueOf(role))
        .setHandle(handle)
        .setLogin(login)
        .setPassword(password)

    matches?.let { user = user.addAllMatches(matches) }
    pendingMatches?.let { user = user.addAllPendingMatches(pendingMatches) }
    rejectedMatches?.let { user = user.addAllRejectedMatches(rejectedMatches) }

    return user.build()
}

fun User.toEntity(userUUID: UUID? = null): UserEntity = UserEntity(userUUID?.let { it } ?: UUID.fromString(userId),
    role.name,
    handle,
    login,
    password
)