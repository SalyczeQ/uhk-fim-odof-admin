package cz.uhk.fim.odof.fimopendays.r2dbc.entity

import cz.uhk.fim.odof.fimopendays.model.DegreeType
import cz.uhk.fim.odof.fimopendays.model.FormType
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.UUID

@Table("field_of_study_info")
data class FieldOfStudyInfoEntity(
    @Id
    val id: UUID? = null,
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
)




