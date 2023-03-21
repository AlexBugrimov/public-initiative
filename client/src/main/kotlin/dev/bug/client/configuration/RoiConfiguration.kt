package dev.bug.client.configuration

import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Hooks.onErrorDropped


@Configuration
@EnableConfigurationProperties(RoiProperties::class)
class RoiConfiguration {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @Bean
    fun webClient(roiProperties: RoiProperties, builder: WebClient.Builder): WebClient {
        onErrorDropped {
                error -> log.error("Произошла ошибка при обращении к внешнему сервису: ${error.message}", error)
        }

        return builder
            .baseUrl(roiProperties.url)
            .build()
    }

}