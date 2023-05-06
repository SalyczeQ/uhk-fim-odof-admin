package cz.uhk.fim.odof.fimopendays

import io.kvision.remote.getAllServiceManagers
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableAutoConfiguration(
    exclude = [
        org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration::class,
        org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration::class
    ]
)
@EnableR2dbcRepositories
class KVApplication {
    @Bean
    fun getManagers() = getAllServiceManagers()
}

fun main(args: Array<String>) {
    runApplication<KVApplication>(*args)
}
