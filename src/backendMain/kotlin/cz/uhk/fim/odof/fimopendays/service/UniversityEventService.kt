package cz.uhk.fim.odof.fimopendays.service

import cz.uhk.fim.odof.fimopendays.controller.response.convertToUniversityEvent
import cz.uhk.fim.odof.fimopendays.model.UniversityEvent
import cz.uhk.fim.odof.fimopendays.r2dbc.repository.UniversityEventRepository
import io.kvision.remote.RemoteData
import io.kvision.remote.RemoteFilter
import io.kvision.remote.RemoteSorter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class UniversityEventService(
    val universityEventRepository: UniversityEventRepository
) : IUniversityEventService {

    override suspend fun getUniversityEvents(page: Int?, size: Int?, filter: List<RemoteFilter>?, sorter: List<RemoteSorter>?, state: String?): RemoteData<UniversityEvent> {
        val events = universityEventRepository.findAll().map { it.convertToUniversityEvent() }.toList()
        println(events)
        return RemoteData<UniversityEvent>(events, events.size)
    }
}