package cz.uhk.fim.odof.fimopendays.r2dbc.repository

import cz.uhk.fim.odof.fimopendays.r2dbc.entity.FieldOfStudyInfoEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FieldOfStudyInfoRepository : CoroutineCrudRepository<FieldOfStudyInfoEntity, UUID> {
}