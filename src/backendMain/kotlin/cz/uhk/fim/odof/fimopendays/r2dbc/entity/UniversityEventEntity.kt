package cz.uhk.fim.odof.fimopendays.r2dbc.entity

import cz.uhk.fim.odof.fimopendays.model.UniversityEventType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table("university_event")
data class UniversityEventEntity(
    @Id
    val id: UUID? = null,
    val name: String,
    val type: UniversityEventType,
    val fromTime: LocalDateTime,
    val toTime: LocalDateTime,
    val location: String,
    val repetitionTimeInMinutes: Int? = null,
    val description: String,
)