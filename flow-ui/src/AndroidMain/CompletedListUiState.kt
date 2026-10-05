data class CompletedListUiState(
    val tasks: List<CompletedTaskRow>,
    val isLoading: Boolean,
    val errorMessage: String?,
    val filterStartDate: LocalDate?,
    val filterEndDate: LocalDate?,
    val totalCount: Int,
    val emptyStateType: EmptyStateType
)