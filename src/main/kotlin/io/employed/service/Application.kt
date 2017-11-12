package io.employed.service

import io.employed.proto.Job
import io.employed.proto.Job.Company
import io.employed.proto.User
import io.employed.proto.User.Name
import io.employed.proto.User.Birthday
import io.employed.proto.User.PhoneNumber
import io.employed.proto.User.PhoneType
import io.employed.proto.User.SexType
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter

@SpringBootApplication
class Application {
    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    fun protobufHttpMessageConverter(): ProtobufHttpMessageConverter {
        return ProtobufHttpMessageConverter()
    }

    //mock Job data
    private fun mockJob(title: String, category: Job.CatergoryType, jobName: String, jobDescription: String, description: String, salary: Double): Job {
        return Job.newBuilder()
            .setTitle(title)
            .setCatergory(category)
            .setCompany(Company.newBuilder()
                .setName(jobName)
                .setDescription(jobDescription))
            .setDescription(description)
            .setSalary(salary)
            .build()
    }

    //mock User data
    private fun mockUser(uuid: String, firstName: String, middleName: String, lastName: String,
                         email: String, phoneNumber: String, phoneType: PhoneType, birthday: Birthday,
                         address: String, city: String, state: String, country: String, postalCode: Int, sex: SexType): User {
        return User.newBuilder()
            .setUuid(uuid)
            .setName(Name.newBuilder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
            )
            .addPhoneNumber(PhoneNumber.newBuilder()
                .setNumber(phoneNumber)
                .setType(phoneType)
            )
            .setBirthday(birthday)
            .setAddress(User.Address.newBuilder()
                .setAddress(address)
                .setCity(city)
                .setState(state)
                .setCountry(country)
                .setPostalCode(postalCode)
            )
            .setSexType(sex)
            .build()
    }



}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}