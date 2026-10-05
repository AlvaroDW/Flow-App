sealed interface AppIntent {
    // Navigation
    data class NavigateToLists : AppIntent
    data class NavigateToTaskList(val listId: String) : AppIntent
    data class NavigateToCompleted : AppIntent
    
    // Lists
    data object StartCreateList : AppIntent
    data class CreateList(val name: String, val color: ColorRole) : AppIntent
    data class RenameList(val listId: String, val newName: String) : AppIntent
    data object ArchiveList : AppIntent
    
    // Tasks
    data class AddTask(val input: AddTaskInput) : AppIntent
    data class ToggleTaskComplete(val taskId: String) : AppIntent
    data class DeleteTask(val taskId: String) : AppIntent
    data class MoveTask(val taskId: String, val targetPosition: PositionValue) : AppIntent
    data class UpdateTaskTitle(val taskId: String, val newTitle: String) : AppIntent
    data class SetDueDate(val taskId: String, val dueDate: LocalDateTime?) : AppIntent
    data class SetReminder(val taskId: String, val type: ReminderType?) : AppIntent
    
    // Filters/Sorting
    data class SetFilter(val filter: TaskFilter) : AppIntent
    data class SetSortOrder(val sortOrder: TaskSortOrder) : AppIntent
    
    // Theme
    data class SetThemeMode(val mode: ThemeMode) : AppIntent
    
    // Undo
    data object UndoLastAction : AppIntent
    
    // Global
    data object RetryFailedOperation : AppIntent
    data class DismissSnackbar(val snackbarId: String) : AppIntent
}