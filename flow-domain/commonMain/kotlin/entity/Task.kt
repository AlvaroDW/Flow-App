/**
    * Represents a task in the system.
 */
data class Task(
    val id: String,           // UUID
    val title: String,        // 1-100 chars
    val description: String? = null, // Optional, up to 2000 chars
    val isCompleted: Boolean,
    val completedAt: Instant?, // Timestamp when marked done
    val createdAt: Instant,
    val updatedAt: Instant,
    val listId: String,       // Foreign key to TaskList
    val priorityPosition: PositionValue, // Fractional position for drag-drop
    val dueDate: LocalDateTime?,
    val reminderId: ReminderReference?, // Points to data layer notification
    val tags: Set<String>,    // For future filtering
    val orderInList: Int      // Legacy fallback, deprecated
) {
    init {
        require(title.isNotBlank()) { "Task title cannot be empty" }
        require(title.length <= 100) { "Task title too long" }
        require(description?.length ?: 0 <= 2000) { "Description too long" }
    }
}