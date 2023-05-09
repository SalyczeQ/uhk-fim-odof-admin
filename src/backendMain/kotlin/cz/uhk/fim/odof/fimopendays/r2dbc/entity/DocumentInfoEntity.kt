package cz.uhk.fim.odof.fimopendays.r2dbc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("document_info")
data class DocumentInfoEntity(
    @Id
    val id: UUID? = null,
    @Column("field_of_study_id")
    val fieldOfStudyInfoId: UUID,
    val name: String? = null,
    val url: String? = null,
)
