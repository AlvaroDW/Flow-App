/**
 * Represents the input required to add a new task in the system.
 */
data class AddTaskInput(
    val title: String,
    val description: String? = null,
    val listId: String,
    val dueDate: LocalDateTime? = null,
    val reminderType: ReminderType? = null
)