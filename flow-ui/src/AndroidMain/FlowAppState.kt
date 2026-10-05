/**
 * Central state holder for the entire app
 */
data class FlowAppState(
    val currentScreen: FlowScreen,
    val themeMode: ThemeMode,
    val isLoadingGlobal: Boolean = false,
    val snackbars: List<SnackbarMessage> = emptyList(),
    val undoStack: UndoStack = UndoStack.Empty
)