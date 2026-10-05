/**
 * Represents an undo action in the system.
 */
data class UndoAction(
    val type: ActionType,
    val taskId: String?,
    val originalState: JsonNode?, // Serialized task state
    val timestamp: Instant
)