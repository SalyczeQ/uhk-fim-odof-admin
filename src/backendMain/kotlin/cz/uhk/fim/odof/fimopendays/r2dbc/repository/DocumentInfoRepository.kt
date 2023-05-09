package cz.uhk.fim.odof.fimopendays.r2dbc.repository

import cz.uhk.fim.odof.fimopendays.r2dbc.entity.DocumentInfoEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DocumentInfoRepository : CoroutineCrudRepository<DocumentInfoEntity, UUID> {

    fun findAllByFieldOfStudyInfoId(fieldOfStudyInfoId: UUID): Flow<DocumentInfoEntity>
}