package cz.uhk.fim.odof.fimopendays.controller.response

import cz.uhk.fim.odof.fimopendays.model.DegreeType

data class FieldOfStudyResponse(
    val degreeType: DegreeType,
    val items: List<FieldOfStudyInfoResponse>,
)
