data class SnackBarAction(
    val label: String,
    val onClick: () -> Unit  // Callback to dispatch undo intent