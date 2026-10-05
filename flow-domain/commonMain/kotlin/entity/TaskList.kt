/**
    * Represents a list of tasks in the application.
 */
data class TaskList(
    val id: UUID,
    val name: String,
    val colorRole: colorRole,
    val createdAt: Instant,
    val sortOrder: Float,
    val isArchived: Boolean,
)
{
    // Invariant: Name must be 1-50 chars
    init {
        require(name.isNotBlank()) { "List name cannot be empty" }
        require(name.length <= 50) { "List name too long" }
    }
    
    companion object {
        // Preset IDs for default lists
        val DEFAULT_WORK_ID = "work_default"
        val DEFAULT_PERSONAL_ID = "personal_default"
        val DEFAULT_GROCERIES_ID = "groceries_default"
    }
}