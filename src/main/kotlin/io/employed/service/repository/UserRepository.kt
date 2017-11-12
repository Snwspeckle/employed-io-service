package io.employed.service.repository

import io.employed.proto.User
import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicLong

@Repository
class UserRepository {
    var userMap: Map<String, User> = mapOf()
    val counter = AtomicLong()

    val email1 = "elliotAlderson@email.com"
    val email2 = "darleneAlderson@email.com"

    val firstName1 = "Elliot"
    val firstName2 = "Darlene"

    val lastName1 = "Alderson"
    val lastName2 = "Alderson"

    constructor() {
        userMap = createUsers()
    }

    fun createUsers(): Map<String, User> {
        return hashMapOf(
                email1 to buildUser(firstName1, lastName1, email1),
                email2 to buildUser(firstName2, lastName2, email2))
    }

    fun buildUser(firstName: String, lastName: String, email: String): User {
        val builder: User.Builder = User.newBuilder()

        builder.addressBuilder.setAddress("123 Main Street").setPostalCode(12345).setCountry("USA")
        builder.birthdayBuilder.setDay(19).setMonth(1).setYear(1995)
        builder.nameBuilder.setFirstName(firstName).setLastName(lastName)

        val phoneBuilder: User.PhoneNumber.Builder = User.PhoneNumber.newBuilder()
        phoneBuilder.setNumber("513-444-4444")
        phoneBuilder.setType(User.PhoneType.MOBILE)
        builder.addPhoneNumber(phoneBuilder.build())

        builder.setSexType(User.SexType.MALE)
        builder.setUuid(counter.incrementAndGet().toString())
        builder.setEmail(email)
        builder.setPassword("password")

        return builder.build()
    }

    fun getUser(email: String): User {
        return userMap.get(email)
    }
}