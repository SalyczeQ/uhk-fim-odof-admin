package cz.uhk.fim.odof.fimopendays.controller.response

import cz.uhk.fim.odof.fimopendays.r2dbc.entity.VideoInfoEntity


data class VideoInfoResponse(
    val name: String,
    val url: String,
    val thumbnail: String?,
    val description: String?,
)

fun VideoInfoEntity.toResponse(): VideoInfoResponse {
    return VideoInfoResponse(
        name = this.name,
        url = this.url,
        thumbnail = this.thumbnail,
        description = this.description,
    )
}
