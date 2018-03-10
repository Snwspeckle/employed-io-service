package io.employed.service.persistence

import com.google.protobuf.util.Timestamps
import io.employed.proto.User
import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table
import java.util.Date
import java.util.UUID

@Table
data class UserEntity(
    @PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    val userId: UUID,

    @Column(value = "creation_date")
    val creationDate: Date,

    @Column
    val handle: String,

    @Column(value = "first_name")
    val firstName: String,

    @Column(value = "last_name")
    val lastName: String,

    @Column
    val bio: String,

    @Column
    val email: String,

    @Column(value = "phone_number")
    val phoneNumber: String
)

fun UserEntity.toProto(): User = User.newBuilder()
    .setUserId(userId.toString())
    .setCreationDate(Timestamps.fromMillis(creationDate.time))
    .setHandle(handle)
    .setFirstName(firstName)
    .setLastName(lastName)
    .setBio(bio)
    .setEmail(email)
    .setPhoneNumber(phoneNumber)
    .build()

fun User.toEntity(): UserEntity = UserEntity(UUID.fromString(userId),
    Date(Timestamps.toMillis(creationDate)),
    handle,
    firstName,
    lastName,
    bio,
    email,
    phoneNumber
)