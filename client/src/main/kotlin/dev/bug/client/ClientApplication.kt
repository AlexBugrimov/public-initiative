package dev.bug.client

import dev.bug.client.service.RoiService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClientApplication(val roiService: RoiService): CommandLineRunner {

	companion object {
		private val log = LoggerFactory.getLogger(this::class.java)
	}

	override fun run(vararg args: String?) {
		log.info("Application executed...")
		roiService.processPoll()
	}
}

fun main(args: Array<String>) {
	runApplication<ClientApplication>(*args)
}
