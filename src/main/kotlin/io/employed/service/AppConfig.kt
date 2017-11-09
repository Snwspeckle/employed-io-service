package io.employed.service

import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@EnableWebMvc
@Configuration
@ComponentScan
class AppConfig : WebMvcConfigurerAdapter() {
    @Override
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        val mappingJackson = MappingJackson2HttpMessageConverter()
        mappingJackson.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)

        converters!!.add(ProtobufHttpMessageConverter())
        converters.add(mappingJackson)
        super.configureMessageConverters(converters)
    }
}