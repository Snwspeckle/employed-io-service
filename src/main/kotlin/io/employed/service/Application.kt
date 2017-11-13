package io.employed.service

import io.employed.proto.Job
import io.employed.proto.Job.Company
import io.employed.proto.User
import io.employed.proto.User.Name
import io.employed.proto.User.Birthday
import io.employed.proto.User.PhoneNumber
import io.employed.proto.User.PhoneType
import io.employed.proto.User.SexType
import io.employed.service.repository.JobRepositoryContract
import io.employed.service.repository.UserRepositoryContract
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter

@SpringBootApplication
class Application {
    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    fun objectMapperBuilder(): Jackson2ObjectMapperBuilder {
        return Jackson2ObjectMapperBuilder()
            .failOnEmptyBeans(false)
            .failOnUnknownProperties(false)
    }

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

    @Bean
    fun jobRepository(): JobRepositoryContract {
        val jobs = hashMapOf(
            1 to mockJob(
                "Senior Software Engineer",
                Job.CatergoryType.ENGINEERING,
                "Software Engineer",
                "Senior Software Engineer position with Google",
                "Need a software engineer with at least 3-5 years of experience.  Tasks will include attending daily scrums, wirting code, and being a team player.  Skill needed are the following: Java, C++, etc.",
                155.5
            ),
            2 to mockJob(
                "Junior Software Engineer",
                Job.CatergoryType.ENGINEERING,
                "Software Engineer",
                "Junior Software Engineer position with Intuit",
                "Need a software engineer with at least 3-5 years of experience.  Tasks will include attending daily scrums, wirting code, and being a team player.  Skill needed are the following: Java, C++, etc.",
                125.5
            ),
            3 to mockJob(
                "Software Engineer I",
                Job.CatergoryType.ENGINEERING,
                "Software Engineer",
                "Entry level engineer position with Microsoft",
                "Need a software engineer with at least 3-5 years of experience.  Tasks will include attending daily scrums, wirting code, and being a team player.  Skill needed are the following: Java, C++, etc.",
                100.5
            )
        )

        return object : JobRepositoryContract {
            override fun findById(id: Int): Job? = jobs[id]
            override fun findAll(): List<Job> = jobs.values.toList()
        }
    }

    @Bean
    fun userRepository(): UserRepositoryContract {
        val users = hashMapOf(
            1 to mockUser(
                "1",
                "Tony",
                "Jabrony",
                "Waldeck",
                "tonywaldeck@gmail.com",
                "567-342-1234",
                PhoneType.MOBILE,
                Birthday.newBuilder().setDay(10).setMonth(9).setYear(1995).build(),
                "1234 Quarterly Lane",
                "Cincinnati",
                "Ohio",
                "USA",
                90210,
                SexType.MALE
            ),
            2 to mockUser(
                "2",
                "Aaron",
                "Douglas",
                "Triplett",
                "aarondouglastriplett@gmail.com",
                "567-342-5422",
                PhoneType.MOBILE,
                Birthday.newBuilder().setDay(16).setMonth(1).setYear(1995).build(),
                "612 Montage Circle",
                "East Palo Alto",
                "California",
                "USA",
                94303,
                SexType.MALE
            ),
            3 to mockUser(
                "3",
                "Matthew",
                "Meow",
                "Corbett",
                "corbiee@gmail.com",
                "567-342-0533",
                PhoneType.MOBILE,
                Birthday.newBuilder().setDay(5).setMonth(4).setYear(1995).build(),
                "5004 Homely lane",
                "Cincinnati",
                "Ohio",
                "USA",
                90210,
                SexType.MALE
            ),
            4 to mockUser(
                "4",
                "Anthony",
                "Snow",
                "Vella",
                "snwspeckmemate@gmail.com",
                "567-342-1234",
                PhoneType.MOBILE,
                Birthday.newBuilder().setDay(9).setMonth(9).setYear(1995).build(),
                "341 Kek St.",
                "Cincinnati",
                "Ohio",
                "USA",
                90210,
                SexType.MALE
            )
        )

        return object : UserRepositoryContract {
            override fun findById(id: Int): User? = users[id]
            override fun findAll(): List<User> = users.values.toList()
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}