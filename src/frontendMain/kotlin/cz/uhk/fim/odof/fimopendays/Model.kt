package cz.uhk.fim.odof.fimopendays

import cz.uhk.fim.odof.fimopendays.model.UniversityEvent
import cz.uhk.fim.odof.fimopendays.service.IUniversityEventService
import io.kvision.remote.getService

object Model {

    private val pingService = getService<IPingService>()

    private val universityEventService = getService<IUniversityEventService>()

    suspend fun ping(message: String): String {
        return pingService.ping(message)
    }

    suspend fun saveUniversityEvent(universityEvent: UniversityEvent): UniversityEvent {
        return universityEventService.saveUniversityEvent(universityEvent)
    }

    suspend fun deleteUniversityEvent(id: String): Boolean {
        return universityEventService.deleteUniversityEvent(id)
    }
}
