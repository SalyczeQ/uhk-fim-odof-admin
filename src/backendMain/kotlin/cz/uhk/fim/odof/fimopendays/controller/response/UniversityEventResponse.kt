package cz.uhk.fim.odof.fimopendays.controller.response

import cz.uhk.fim.odof.fimopendays.model.UniversityEvent
import cz.uhk.fim.odof.fimopendays.model.UniversityEventType
import cz.uhk.fim.odof.fimopendays.r2dbc.entity.UniversityEventEntity
import java.time.LocalDateTime

data class UniversityEventResponse(
    val name: String,
    val type: UniversityEventType,
    val fromTime: LocalDateTime,
    val toTime: LocalDateTime,
    val location: String,
    val repetitionTimeInMinutes: Int? = null,
    val description: String,
)

fun UniversityEvent.convertToResponse(): UniversityEventResponse {
    return UniversityEventResponse(
        name = this.name,
        type = this.type,
        fromTime = LocalDateTime.parse(this.fromTime.toString()),
        toTime = LocalDateTime.parse(this.toTime.toString()),
        location = this.location,
        repetitionTimeInMinutes = repetitionTimeInMinutes,
        description = this.description,
    )
}

fun UniversityEventEntity.convertToUniversityEvent(): UniversityEvent {
    return UniversityEvent(
        id = this.id.toString(),
        name = this.name,
        type = this.type,
        fromTime = this.fromTime,
        toTime = this.toTime,
        location = this.location,
        repetitionTimeInMinutes = repetitionTimeInMinutes,
        description = this.description,
    )
}

fun UniversityEventEntity.convertToResponse(): UniversityEventResponse {
    return UniversityEventResponse(
        name = this.name,
        type = this.type,
        fromTime = this.fromTime,
        toTime = this.toTime,
        location = this.location,
        repetitionTimeInMinutes = repetitionTimeInMinutes,
        description = this.description,
    )
}
