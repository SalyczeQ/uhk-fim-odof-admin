@file:UseContextualSerialization(LocalDateTime::class)

package cz.uhk.fim.odof.fimopendays.model

import io.kvision.types.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization

@Serializable
data class FieldOfStudyInfo(
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

//@Serializable
//data class FieldOfStudyInfoList(
//    val degreeType: DegreeType,
//    val items: List<FieldOfStudyInfo>,
//)

@Serializable
data class DocumentInfo(
    val name: String? = null,
    val url: String? = null,
)

@Serializable
enum class DegreeType {
    BACHELOR,
    MASTER,
    DOCTORAL
}

@Serializable
enum class FormType {
    PRESENT,
    DISTANCE
}
