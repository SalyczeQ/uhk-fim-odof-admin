package cz.uhk.fim.odof.fimopendays.r2dbc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("video_info")
data class VideoInfoEntity(
    @Id
    val id: UUID? = null,
    val name: String,
    val url: String,
    val thumbnail: String?,
    val description: String?,
)
