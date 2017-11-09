package io.employed.service

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@EnableWebMvc
@Configuration
@ComponentScan
class AppConfig : WebMvcConfigurerAdapter() {
    @Override
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        val protoBufHttpConverter = ProtobufHttpMessageConverter()
        converters!!.add(protoBufHttpConverter)
        super.configureMessageConverters(converters)
    }
}