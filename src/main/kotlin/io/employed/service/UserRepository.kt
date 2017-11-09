package io.employed.service

import io.employer.proto.UserProto
import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicLong

@Repository
class UserRepository {
    var userMap: Map<String, UserProto.User> = mapOf()
    val counter = AtomicLong()

    constructor() {
        userMap = createUsers()
    }

    fun createUsers(): Map<String, UserProto.User> {
        return hashMapOf(
                "bobsmith@email.com" to buildUser("Bob", "Smith", "bobsmith@email.com"),
                "sandysmith@email.com" to buildUser("Sandy", "Smith", "sandysmith@email.com"))
    }

    fun buildUser(firstName: String, lastName: String, email: String): UserProto.User {
        val builder: UserProto.User.Builder = UserProto.User.newBuilder()

        builder.addressBuilder.setAddress("123 Main Street").setPostalCode(12345).setCountry("USA")
        builder.birthdayBuilder.setDay(19).setMonth(1).setYear(1995)
        builder.nameBuilder.setFirstName(firstName).setLastName(lastName)

        val phoneBuilder: UserProto.User.PhoneNumber.Builder = UserProto.User.PhoneNumber.newBuilder()
        phoneBuilder.setNumber("513-444-4444")
        phoneBuilder.setType(UserProto.User.PhoneType.MOBILE)
        builder.addPhoneNumber(phoneBuilder.build())

        builder.setSexType(UserProto.User.SexType.MALE)
        builder.setUuid(counter.incrementAndGet().toString())
        builder.setEmail(email)
        builder.setPassword("password")

        return builder.build()
    }

    fun getUser(email: String): UserProto.User??? {
        return userMap.get(email)
    }
}