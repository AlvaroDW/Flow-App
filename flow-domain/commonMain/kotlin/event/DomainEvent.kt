/**
 * Represents a domain event in the system.
 */
sealed interface DomainEvent {
    data class TaskCreated(val taskId: String) : DomainEvent
    data class TaskCompleted(val taskId: String, val completedAt: Instant) : DomainEvent
    data class TaskUncompleted(val taskId: String) : DomainEvent
    data class TaskDeleted(val taskId: String) : DomainEvent
    data class TaskMoved(val taskId: String, val newPosition: PositionValue) : DomainEvent
    data class ListCreated(val listId: String) : DomainEvent
    data class ListArchived(val listId: String) : DomainEvent
}