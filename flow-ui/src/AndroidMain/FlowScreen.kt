/**
 * Represents a screen in the Flow application.
 */
sealed interface FlowScreen {
    data class Lists(val state: ListsUiState) : FlowScreen
    data class TaskListDetail(val listId: String, val state: TaskListUiState) : FlowScreen
    data class Completed(val state: CompletedListUiState) : FlowScreen
    data class Settings(val state: SettingsUiState) : FlowScreen
}