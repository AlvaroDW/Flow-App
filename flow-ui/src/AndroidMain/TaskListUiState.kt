data class TaskListUiState(
    val listInfo: ListHeaderInfo,
    val tasks: List<TaskRow>,
    val isLoading: Boolean,
    val filter: TaskFilter,
    val sortBy: TaskSortOrder,
    val errorMessage: String?,
    val isAddingTask: Boolean,
    val editingTaskId: String?,  // Null if none, ID if inline editing
    val draggingTaskId: String?  // Currently being dragged
)