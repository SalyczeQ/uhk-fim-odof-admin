package cz.uhk.fim.odof.fimopendays.layout.shared

import io.kvision.core.Container
import io.kvision.navbar.nav
import io.kvision.navbar.navLink
import io.kvision.navbar.navbar

fun Container.headerNav() {
    navbar("Den otevřených dveří na FIM") {
        nav {
            navLink("Události", icon = "fas fa-calendar")
            navLink("Edit", icon = "fas fa-graduation-cap")

        }

        nav(rightAlign = true) {
            navLink("Přihlásit se", icon = "fas fa-arrow-right-to-bracket")
        }
    }
}
