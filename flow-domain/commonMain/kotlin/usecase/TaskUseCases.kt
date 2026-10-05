/**
 * Represents the use cases related to tasks in the system.
 */
interface TaskUseCases {
    suspend fun addTask(input: AddTaskInput): UseCaseResult<Task>
    suspend fun completeTask(taskId: String): UseCaseResult<Unit>
    suspend fun uncompleteTask(taskId: String): UseCaseResult<Unit>
    suspend fun updateTaskTitle(taskId: String, newTitle: String): UseCaseResult<Task>
    suspend fun deleteTask(taskId: String): UseCaseResult<Unit>
    suspend fun moveTask(taskId: String, targetPosition: PositionValue): UseCaseResult<Unit>
    suspend fun setDueDate(taskId: String, dueDateTime: LocalDateTime?): UseCaseResult<Task>
    suspend fun setReminder(taskId: String, type: ReminderType?): UseCaseResult<Task>
    suspend fun undoLastAction(): UseCaseResult<Unit>
}