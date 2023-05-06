package cz.uhk.fim.odof.fimopendays.layout.shared

import cz.uhk.fim.odof.fimopendays.model.UniversityEvent
import cz.uhk.fim.odof.fimopendays.service.IUniversityEventService
import io.kvision.core.onEvent
import io.kvision.i18n.I18n
import io.kvision.i18n.tr
import io.kvision.modal.Confirm
import io.kvision.panel.SimplePanel
import io.kvision.remote.getServiceManager
import io.kvision.tabulator.*
import io.kvision.tabulator.js.Tabulator
import io.kvision.utils.Serialization.toObj
import kotlinx.serialization.serializer
import org.w3c.dom.events.Event

class EventList : SimplePanel() {

    init {

        val tabulator = TabulatorRemote(
            serviceManager = getServiceManager(),
            function = IUniversityEventService::getUniversityEvents,
            options = TabulatorOptions(
                renderVertical = RenderType.VIRTUAL,
                height = "calc(100vh - 90px)",
                layout = Layout.FITCOLUMNS,
                pagination = true,
                paginationMode = PaginationMode.REMOTE,
                paginationSize = 10,
                columns = listOf(
                    ColumnDefinition(
                        tr("Id"),
                        "id",
                        visible = false,
                    ),
                    ColumnDefinition(
                        tr("Name"),
                        "name",
                        headerFilter = Editor.INPUT,
                        headerFilterPlaceholder = tr("Filter by name")
                    ),
                    ColumnDefinition(
                        tr("Type"),
                        "type",
                    ),
                    ColumnDefinition(
                        tr("Location"),
                        "location",
                    ),
                    ColumnDefinition(
                        tr("Description"),
                        "description",
                    ),
                    ColumnDefinition(
                        "", hozAlign = Align.CENTER,
                        width = "40",
                        formatter = Formatter.BUTTONCROSS,
                        headerSort = false,
                        cellClick = { evt: Event, cell ->
                            evt.preventDefault()
                            Confirm.show(
                                I18n.tr("Are you sure?"),
                                I18n.tr("Do you want to delete this event?")
                            ) {
//                                    Model.delete(cell.getRow().getIndex() as Int)
                            }
                        }
                    )
                )
            ),
            serializer = serializer()
        )
        tabulator.onEvent {
            rowClickTabulator = { event ->
                val rowComponent = event.detail as Tabulator.RowComponent
                val rowIndex = rowComponent.getPosition() as Int - 1
                val data = tabulator.getData(RowRangeLookup.VISIBLE)?.get(rowIndex) as UniversityEvent
                console.log(data)
                console.log(data.name)
            }
        }

        add(tabulator)
    }
}