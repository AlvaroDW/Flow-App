sealed interface TaskFilter {
    data object All : TaskFilter
    data object Active : TaskFilter
    data object Completed : TaskFilter
    data object DueToday : TaskFilter
    data object Overdue : TaskFilter
}