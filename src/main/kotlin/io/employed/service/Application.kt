package io.employed.service

import io.employed.proto.Job
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

    //Mock data
    private fun mockJob(title: String, category: Job.CatergoryType, jobName: String, jobDescription: String, description: String, salary: Double): Job {
        return Job.newBuilder()
            .setTitle(title)
            .setCatergory(category)
            .setCompany(Job.Company.newBuilder()
                .setName(jobName)
                .setDescription(jobDescription))
            .setDescription(description)
            .setSalary(salary)
            .build()
    }


}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}