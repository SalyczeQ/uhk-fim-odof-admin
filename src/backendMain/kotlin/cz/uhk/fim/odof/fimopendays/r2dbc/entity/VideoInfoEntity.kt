package cz.uhk.fim.odof.fimopendays.r2dbc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("video_info")
data class VideoInfoEntity(
    @Id
    @Column val id: UUID? = null,
    @Column val name: String,
    @Column val url: String,
    @Column val thumbnail: String?,
    @Column val description: String?,
)
