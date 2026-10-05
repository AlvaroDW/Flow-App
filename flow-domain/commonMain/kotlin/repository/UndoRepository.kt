/**
 * Represents the repository interface for managing undo actions in the system.
 */
interface UndoRepository {
    suspend fun recordAction(action: UndoAction): Unit
    suspend fun peekLastAction(): UndoAction?
    suspend fun clearAfter(index: Int): Unit
}