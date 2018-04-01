package io.employed.service.persistence

import io.employed.proto.Address
import io.employed.proto.Industry
import io.employed.proto.JobSeeker
import io.employed.proto.Location
import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table
import java.util.UUID

@Table(value = "job_seekers")
data class JobSeekerEntity(
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
    val bio: String,

    @Column(value = "avatar_url")
    val avatarUrl: String,

    @Column
    val headline: String,

    @Column(value = "current_position")
    val currentPosition: String,

    @Column
    val industry: String,

    @Column
    val latitude: Double,

    @Column
    val longitude: Double,

    @Column(value = "street_address")
    val streetAddress: String,

    @Column
    val city: String,

    @Column
    val state: String,

    @Column
    val country: String,

    @Column
    val zip: String,

    @Column
    val skills: List<String>,

    @Column
    val tags: List<String>
)

fun JobSeekerEntity.toProto(): JobSeeker = JobSeeker.newBuilder()
    .setUserId(userId.toString())
    .setFirstName(firstName)
    .setLastName(lastName)
    .setEmail(email)
    .setPhoneNumber(phoneNumber)
    .setBio(bio)
    .setAvatarUrl(avatarUrl)
    .setHeadline(headline)
    .setCurrentPosition(currentPosition)
    .setIndustry(Industry.valueOf(industry))
    .setLocation(Location.newBuilder()
        .setLatitude(latitude)
        .setLongitude(longitude)
        .setAddress(Address.newBuilder()
            .setStreetAddress(streetAddress)
            .setCity(city)
            .setState(state)
            .setCountry(country)
            .setZip(zip)
        )
    )
    .addAllSkills(skills)
    .addAllTags(tags)
    .build()

fun JobSeeker.toEntity(userUUID: UUID? = null): JobSeekerEntity = JobSeekerEntity(userUUID?.let { it } ?: UUID.fromString(userId),
    firstName,
    lastName,
    email,
    phoneNumber,
    bio,
    avatarUrl,
    headline,
    currentPosition,
    industry.name,
    location.latitude,
    location.longitude,
    location.address.streetAddress,
    location.address.city,
    location.address.state,
    location.address.country,
    location.address.zip,
    skillsList,
    tagsList
)