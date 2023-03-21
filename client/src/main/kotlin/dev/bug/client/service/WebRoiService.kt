package dev.bug.client.service

import dev.bug.client.client.RoiClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Hooks.onErrorDropped

@Service
class WebRoiService(val roiClient: RoiClient): RoiService {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    override fun processPoll() {
        onErrorDropped { error -> log.error("Произошла ошибка при обращении к внешнему сервису: ${error.message}", error) }
        roiClient.petitions()
            .map { it.data }
            .doOnError { error -> log.error("Ошибка при загрузке данных: ${error.message}") }
            .subscribe { log.info("Загружено ${it.size} инициатив на голосовании") }
    }
}