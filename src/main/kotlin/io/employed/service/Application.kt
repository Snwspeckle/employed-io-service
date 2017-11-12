package io.employed.service

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application {
    private val log = LoggerFactory.getLogger(Application::class.java)
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}