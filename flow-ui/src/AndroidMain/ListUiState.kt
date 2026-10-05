data class ListsUiState(
    val lists: List<ListItem>,
    val isLoading: Boolean,
    val errorMessage: String?,
    val isCreatingNewList: Boolean,
    val draggingListId: String? = null  // For visual feedback during reorder
)