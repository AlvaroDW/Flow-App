/**
 * Represents the use cases related to task lists in the system.
 */
interface ListUseCases {
    suspend fun createList(input: CreateListInput): UseCaseResult<TaskList>
    suspend fun renameList(listId: String, newName: String): UseCaseResult<TaskList>
    suspend fun archiveList(listId: String): UseCaseResult<Unit>
    suspend fun restoreList(listId: String): UseCaseResult<Unit>
    suspend fun reorderLists(listIds: List<String>): UseCaseResult<Unit>
}