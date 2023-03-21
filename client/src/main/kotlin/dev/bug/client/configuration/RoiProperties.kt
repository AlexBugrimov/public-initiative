package dev.bug.client.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.lang.NonNull

@ConfigurationProperties("roi-service")
data class RoiProperties(@NonNull val url: String)