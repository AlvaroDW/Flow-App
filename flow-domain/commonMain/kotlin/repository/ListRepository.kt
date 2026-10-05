/**
 * Represents the repository interface for managing task lists in the system.
 */
interface ListRepository {
    fun allLists(): Flow<List<TaskList>>
    suspend fun getById(listId: String): TaskList?
    suspend fun save(list: TaskList): Unit
    suspend fun delete(listId: String): Unit
}