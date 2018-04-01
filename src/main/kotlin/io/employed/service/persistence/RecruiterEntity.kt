package io.employed.service.persistence

import io.employed.proto.Recruiter
import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table
import java.util.UUID

@Table(value = "recruiters")
data class RecruiterEntity(
    @PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED, ordinal = 0)
    val userId: UUID,

    @Column(value = "first_name")
    val firstName: String,

    @Column(value = "last_name")
    val lastName: String,

    @Column
    val email: String,

    @Column(value = "phone_number")
    val phoneNumber: String,

    @Column
    val bio: String
)

fun RecruiterEntity.toProto(): Recruiter = Recruiter.newBuilder()
    .setUserId(userId.toString())
    .setFirstName(firstName)
    .setLastName(lastName)
    .setEmail(email)
    .setPhoneNumber(phoneNumber)
    .setBio(bio)
    .build()

fun Recruiter.toEntity(userUUID: UUID? = null): RecruiterEntity = RecruiterEntity(userUUID?.let { it } ?: UUID.fromString(userId),
    firstName,
    lastName,
    email,
    phoneNumber,
    bio
)