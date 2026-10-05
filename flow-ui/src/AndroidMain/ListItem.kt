data class ListItem(
    val id: String,
    val name: String,
    val colorRole: ColorRole,
    val taskCount: Int,
    val pendingTaskCount: Int,  // Non-completed count for badge
    val hasDueToday: Boolean,   // Red dot indicator
    val sortOrder: Float
)