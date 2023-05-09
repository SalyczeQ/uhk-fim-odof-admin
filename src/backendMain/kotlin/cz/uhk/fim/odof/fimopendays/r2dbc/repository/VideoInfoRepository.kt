package cz.uhk.fim.odof.fimopendays.r2dbc.repository

import cz.uhk.fim.odof.fimopendays.r2dbc.entity.VideoInfoEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface VideoInfoRepository : CoroutineCrudRepository<VideoInfoEntity, UUID>