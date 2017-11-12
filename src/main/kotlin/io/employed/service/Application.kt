package io.employed.service

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
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}