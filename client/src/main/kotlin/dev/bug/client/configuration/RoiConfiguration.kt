package dev.bug.client.configuration

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient


@Configuration
@EnableConfigurationProperties(RoiProperties::class)
class RoiConfiguration {

    @Bean
    fun webClient(roiProperties: RoiProperties, builder: WebClient.Builder): WebClient {
        return builder
            .baseUrl(roiProperties.url)
            .build()
    }

}