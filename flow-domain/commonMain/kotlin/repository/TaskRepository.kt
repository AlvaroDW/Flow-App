/**
 * Represents the repository interface for managing tasks in the system.
 */
interface TaskRepository {
    fun tasksByList(listId: String): Flow<List<Task>>
    fun tasksByTag(tag: String): Flow<List<Task>>
    fun completedTasks(): Flow<List<Task>>
    fun overdueTasks(): Flow<List<Task>>
    
    suspend fun getById(taskId: String): Task?
    suspend fun save(task: Task): Unit
    suspend fun delete(taskId: String): Unit
    suspend fun bulkUpdatePositions(positions: Map<String, PositionValue>): Unit
}