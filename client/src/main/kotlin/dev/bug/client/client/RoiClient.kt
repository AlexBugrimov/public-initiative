package dev.bug.client.client

import dev.bug.client.model.Petitions
import reactor.core.publisher.Mono

interface RoiClient {

    fun petitions(): Mono<Petitions>
}