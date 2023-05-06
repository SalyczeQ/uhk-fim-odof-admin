package cz.uhk.fim.odof.fimopendays

import io.kvision.annotations.KVService

@KVService
interface IPingService {
    suspend fun ping(message: String): String
}



