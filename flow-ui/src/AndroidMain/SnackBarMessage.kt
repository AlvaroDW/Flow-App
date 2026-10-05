data class SnackbarMessage(
    val id: String,
    val text: String,
    val action: SnackBarAction? = null,
    val duration: Duration = 3.seconds
)