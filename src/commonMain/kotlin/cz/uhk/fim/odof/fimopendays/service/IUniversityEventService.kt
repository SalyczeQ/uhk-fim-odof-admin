package cz.uhk.fim.odof.fimopendays.service

import cz.uhk.fim.odof.fimopendays.model.UniversityEvent
import io.kvision.annotations.KVService
import io.kvision.remote.RemoteData
import io.kvision.remote.RemoteFilter
import io.kvision.remote.RemoteSorter

@KVService
interface IUniversityEventService {
    suspend fun getUniversityEvents(
        page: Int?,
        size: Int?,
        filter: List<RemoteFilter>?,
        sorter: List<RemoteSorter>?,
        state: String?
    ): RemoteData<UniversityEvent>

    suspend fun saveUniversityEvent(universityEvent: UniversityEvent): UniversityEvent

    suspend fun deleteUniversityEvent(id: String): Boolean
}