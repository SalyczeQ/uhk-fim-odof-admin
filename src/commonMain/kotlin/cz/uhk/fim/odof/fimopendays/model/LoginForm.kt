package cz.uhk.fim.odof.fimopendays.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginForm(
    val username: String,
    val password: String,
)