package cz.uhk.fim.odof.fimopendays.model

import io.kvision.types.LocalDateTime
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class UniversityEvent(
    val id: String? = null,
    val name: String,
    val type: UniversityEventType,
    @Contextual
    val fromTime: LocalDateTime,
    @Contextual
    val toTime: LocalDateTime,
    val location: String,
    val repetitionTimeInMinutes: Int? = null,
    val description: String,
)

@Serializable
enum class UniversityEventType {
    PRESENTATION,
    WORKSHOP,
    SIDE_EVENT
}