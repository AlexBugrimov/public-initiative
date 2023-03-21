package dev.bug.client.client

import dev.bug.client.model.Petitions
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class DefaultRoiClient(val webClient: WebClient): RoiClient {

    override fun petitions(): Mono<Petitions> {
        return webClient.get()
            .uri("/petitions/poll.jso")
            .retrieve()
            .bodyToMono(Petitions::class.java)
    }
}