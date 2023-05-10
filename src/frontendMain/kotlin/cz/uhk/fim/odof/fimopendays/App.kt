package cz.uhk.fim.odof.fimopendays

import cz.uhk.fim.odof.fimopendays.layout.shared.EventList
import cz.uhk.fim.odof.fimopendays.layout.shared.headerNav
import io.kvision.*
import io.kvision.core.Container
import io.kvision.html.Span
import io.kvision.html.div
import io.kvision.html.footer
import io.kvision.html.header
import io.kvision.panel.root
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application() {

    override fun start(state: Map<String, Any>) {
        val root = root("kvapp") {
            header {
                headerNav()
            }
            div {
                add(EventList())
            }
            footer {

            }
        }
        AppScope.launch {
            val pingResult = Model.ping("Ping from client!")
            root.add(Span(pingResult))
        }
    }
}

fun main() {
    startApplication(
        ::App,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        DatetimeModule,
        BootstrapIconsModule,
        CoreModule,
        FontAwesomeModule,
        TabulatorCssMaterializeModule,
        TabulatorModule,
    )
}
