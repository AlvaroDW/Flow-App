data class CompletedTaskRow(
    val id: String,
    val title: String,
    val completedAt: Instant,
    val listName: String,
    val originalListDeleted: Boolean
)