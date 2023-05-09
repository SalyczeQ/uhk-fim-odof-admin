package cz.uhk.fim.odof.fimopendays.controller

import cz.uhk.fim.odof.fimopendays.controller.response.*
import cz.uhk.fim.odof.fimopendays.r2dbc.repository.UniversityEventRepository
import cz.uhk.fim.odof.fimopendays.r2dbc.repository.VideoInfoRepository
import cz.uhk.fim.odof.fimopendays.service.FieldOfStudyInfoService
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["api/v1/"]
//    , consumes = ["application/json"], produces = ["application/json"]
)
class MobileApiController(
    private val universityEventRepository: UniversityEventRepository,
    private val fieldOfStudyInfoService: FieldOfStudyInfoService,
    private val videoInfoRepository: VideoInfoRepository,
) {

    @GetMapping("/event")
    suspend fun getEvents(): List<UniversityEventResponse> {
        return universityEventRepository.findAll().map { it.convertToResponse() }.toList()
    }

    @GetMapping("/video")
    suspend fun getVideos(): List<VideoInfoResponse> {
        return videoInfoRepository.findAll().map { it.toResponse() }.toList()
    }

    @GetMapping("/field-of-study-info")
    suspend fun getFieldsOfStudyInfos(): List<FieldOfStudyResponse> {
        val map = fieldOfStudyInfoService.getAllFieldOfStudyInfo().toList().groupBy { it.degreeType }
        val response = mutableListOf<FieldOfStudyResponse>()
        map.forEach { (degreeType, fieldOfStudyInfos) ->
            FieldOfStudyResponse(
                degreeType = degreeType,
                items = fieldOfStudyInfos
            ).let { response.add(it) }
        }
        return response
    }

    @GetMapping("/health")
    suspend fun getTest(): String {
        return "server is running"
    }

}


