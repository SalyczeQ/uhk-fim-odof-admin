package cz.uhk.fim.odof.fimopendays.service

import cz.uhk.fim.odof.fimopendays.controller.response.FieldOfStudyInfoResponse
import cz.uhk.fim.odof.fimopendays.model.DocumentInfo
import cz.uhk.fim.odof.fimopendays.r2dbc.entity.DocumentInfoEntity
import cz.uhk.fim.odof.fimopendays.r2dbc.entity.FieldOfStudyInfoEntity
import cz.uhk.fim.odof.fimopendays.r2dbc.repository.DocumentInfoRepository
import cz.uhk.fim.odof.fimopendays.r2dbc.repository.FieldOfStudyInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class FieldOfStudyInfoService(
    private val fieldOfStudyInfoRepository: FieldOfStudyInfoRepository,
    private val documentInfoRepository: DocumentInfoRepository,
) {

    fun getAllFieldOfStudyInfo(): Flow<FieldOfStudyInfoResponse> {
        return fieldOfStudyInfoRepository.findAll()
        .map {  value: FieldOfStudyInfoEntity -> value.toResponse(documentInfoRepository.findAllByFieldOfStudyInfoId(value.id!!).toList()) }
    }

    fun FieldOfStudyInfoEntity.toResponse(documentInfoEntities: List<DocumentInfoEntity>): FieldOfStudyInfoResponse {
        return FieldOfStudyInfoResponse(
            name = this.name,
            shortCut = this.shortCut,
            degreeType = this.degreeType,
            formType = this.formType,
            studyPeriod = this.studyPeriod,
            description = this.description,
            candidateProfile = this.candidateProfile,
            graduateProfile = this.graduateProfile,
            eApplicationFormUrl = this.eApplicationFormUrl,
            studyPlanUrl = this.studyPlanUrl,
            furtherStudyPossibility = this.furtherStudyPossibility,
            examWaiverOption = this.examWaiverOption,
            admissionProcedure = this.admissionProcedure,
            estimatedNumberOfAdmissions = this.estimatedNumberOfAdmissions,
            accreditationUntil = this.accreditationUntil,
            urlDocumentsToDownload = documentInfoEntities.map { it.toResponse()}
        )
    }

    fun DocumentInfoEntity.toResponse(): DocumentInfo {
        return DocumentInfo(
            name = this.name,
            url = this.url,
        )
    }
}