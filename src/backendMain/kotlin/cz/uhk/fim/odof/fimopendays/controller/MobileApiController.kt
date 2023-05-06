package cz.uhk.fim.odof.fimopendays.controller

import cz.uhk.fim.odof.fimopendays.controller.response.UniversityEventResponse
import cz.uhk.fim.odof.fimopendays.controller.response.convertToResponse
import cz.uhk.fim.odof.fimopendays.r2dbc.repository.UniversityEventRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1")
class MobileApiController(
    val universityEventRepository: UniversityEventRepository
) {

    @GetMapping("/event")
    suspend fun getEvents(): List<UniversityEventResponse> {
        return universityEventRepository.findAll().map { it.convertToResponse() }.toList()
    }

}


