data class TaskRow(
    val id: String,
    val title: String,
    val isCompleted: Boolean,
    val completedAt: Instant?,
    val dueDate: LocalDateTime?,
    val isOverdue: Boolean,   // Derived: dueDate < now && !completed
    val positionValue: String,
    val isSelectedForBulk: Boolean,  // For future multi-select deletion
    val animationTarget: Int? = null // For layout transitions
)