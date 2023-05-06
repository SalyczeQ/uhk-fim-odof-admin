package cz.uhk.fim.odof.fimopendays.controller.response

import cz.uhk.fim.odof.fimopendays.model.DegreeType
import cz.uhk.fim.odof.fimopendays.model.DocumentInfo
import cz.uhk.fim.odof.fimopendays.model.FieldOfStudyInfo
import cz.uhk.fim.odof.fimopendays.model.FormType
import java.time.LocalDateTime

data class FieldOfStudyInfoResponse(
    val name: String,
    val shortCut: String,
    val degreeType: DegreeType,
    val formType: FormType,
    val studyPeriod: Int,
    val description: String,
    val candidateProfile: String,
    val graduateProfile: String,
    val eApplicationFormUrl: String,
    val studyPlanUrl: String,
    val furtherStudyPossibility: String?,
    val examWaiverOption: String,
    val admissionProcedure: String?,
    val estimatedNumberOfAdmissions: Int,
    val accreditationUntil: LocalDateTime? = null,
    val urlDocumentsToDownload: List<DocumentInfo>?,
)

fun FieldOfStudyInfo.convertToResponse(): FieldOfStudyInfoResponse {
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
        accreditationUntil = LocalDateTime.parse(this.accreditationUntil.toString()),
        urlDocumentsToDownload = this.urlDocumentsToDownload,
    )
}

data class FieldOfStudyInfoList(
    val degreeType: DegreeType,
    val items: List<FieldOfStudyInfoResponse>,
)


