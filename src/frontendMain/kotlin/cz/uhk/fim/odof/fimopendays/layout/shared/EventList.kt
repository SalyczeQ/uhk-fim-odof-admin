package cz.uhk.fim.odof.fimopendays.layout.shared

import cz.uhk.fim.odof.fimopendays.AppScope
import cz.uhk.fim.odof.fimopendays.Model
import cz.uhk.fim.odof.fimopendays.model.UniversityEvent
import cz.uhk.fim.odof.fimopendays.model.UniversityEventType
import cz.uhk.fim.odof.fimopendays.service.IUniversityEventService
import io.kvision.core.onEvent
import io.kvision.form.InputSize
import io.kvision.form.number.NumericInput
import io.kvision.form.select.SelectInput
import io.kvision.form.text.TextInput
import io.kvision.html.button
import io.kvision.i18n.I18n
import io.kvision.i18n.tr
import io.kvision.modal.Alert
import io.kvision.modal.Confirm
import io.kvision.panel.SimplePanel
import io.kvision.panel.hPanel
import io.kvision.remote.getServiceManager
import io.kvision.tabulator.*
import io.kvision.tabulator.js.Tabulator
import kotlinx.coroutines.launch
import kotlinx.serialization.serializer
import org.w3c.dom.events.Event

class EventList : SimplePanel() {
    lateinit var tabulator: TabulatorRemote<*, *>

    init {
        tabulator = tabulatorRemote(
            serviceManager = getServiceManager(),
            function = IUniversityEventService::getUniversityEvents,
            options = TabulatorOptions(
                renderVertical = RenderType.VIRTUAL,
                height = "calc(100vh - 90px)",
                layout = Layout.FITCOLUMNS,
                pagination = true,
                paginationMode = PaginationMode.LOCAL,
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
                        headerFilterPlaceholder = tr("Filter by name"),
                        editorComponentFunction = { _, _, success, _, data ->
                            TextInput(value = data.name).apply {
                                size = InputSize.SMALL
                                onEvent {
                                    change = {
                                        AppScope.launch {
                                            self.value?.let { Model.saveUniversityEvent(data.copy(name = it)) }
                                        }
                                        success(self.value)
                                    }
                                }
                            }
                        },
                        editable = { true },
                        cellDblClick = { _, cell -> cell.edit(true) },
                    ),
                    ColumnDefinition(
                        tr("Type"),
                        "type",
                        editorComponentFunction = { _, _, success, _, data ->
                            SelectInput(
                                listOf(
                                    "PRESENTATION" to "Presentation",
                                    "WORKSHOP" to "Workshop",
                                    "SIDE_EVENT" to "Side event",
                                ),
                                value = data.type.toString(),
                                emptyOption = true
                            ).apply {
                                size = InputSize.SMALL
                                onEvent {
                                    change = {
                                        AppScope.launch {
                                            self.value?.let {
                                                Model.saveUniversityEvent(
                                                    data.copy(
                                                        type = UniversityEventType.valueOf(
                                                            it
                                                        )
                                                    )
                                                )
                                            }
                                        }
                                        success(self.value)
                                    }
                                }
                            }
                        }
                    ),
                    ColumnDefinition(
                        tr("Location"),
                        "location",
                        editorComponentFunction = { _, _, success, _, data ->
                            TextInput(value = data.name).apply {
                                size = InputSize.SMALL
                                onEvent {
                                    change = {
                                        AppScope.launch {
                                            self.value?.let { Model.saveUniversityEvent(data.copy(location = it)) }
                                        }
                                        success(self.value)
                                    }
                                }
                            }
                        }
                    ),
                    ColumnDefinition(
                        tr("Repetition Time In Minutes"),
                        "repetitionTimeInMinutes",
                        editorComponentFunction = { _, _, success, _, data ->
                            NumericInput(data.repetitionTimeInMinutes, min = 0, decimals = 0).apply {
                                size = InputSize.SMALL
                                onEvent {
                                    blur = {
                                        AppScope.launch {
                                            self.value?.let {
                                                Model.saveUniversityEvent(
                                                    data.copy(
                                                        repetitionTimeInMinutes = it.toInt()
                                                    )
                                                )
                                            }
                                        }
                                        success(self.value)
                                    }
                                }
                            }
                        }
                    ),
                    ColumnDefinition(
                        tr("Description"),
                        "description",
                        editorComponentFunction = { _, _, success, _, data ->
                            TextInput(value = data.description).apply {
                                size = InputSize.SMALL
                                onEvent {
                                    change = {
                                        AppScope.launch {
                                            self.value?.let { Model.saveUniversityEvent(data.copy(description = it)) }
                                        }
                                        success(self.value)
                                    }
                                }
                            }
                        }
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
                                AppScope.launch {
                                    val rowComponent = cell.getRow()
                                    val rowIndex = rowComponent.getPosition() as Int - 1
                                    val data =
                                        tabulator.getData(RowRangeLookup.VISIBLE)?.get(rowIndex) as UniversityEvent
                                    Model.deleteUniversityEvent(data.id.toString())
                                }
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
        hPanel(spacing = 5) {
            button(tr("Add new event"), "fas fa-plus").onClick {
//                this@TabulatorTab.data.add(Employee(null, null, null, false, null, null))
            }

            button(tr("Show current data model"), "fas fa-search").onClick {
                Alert.show(tr("Current data model"), tabulator.getData()?.toList().toString())
            }
        }
    }
}