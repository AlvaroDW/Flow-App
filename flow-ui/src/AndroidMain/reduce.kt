// Example reducer logic (pseudo-code)
fun reduce(
    oldState: FlowAppState,
    intent: AppIntent
): Pair<FlowAppState, List<SideEffect>> {
    
    return when (intent) {
        is AppIntent.ToggleTaskComplete -> {
            val updatedTasks = oldState.currentTaskListTasks.map { task ->
                if (task.id == intent.taskId) {
                    task.copy(isCompleted = !task.isCompleted, completedAt = now())
                } else task
            }
            
            val newState = oldState.copy(
                currentScreen = (oldState.currentScreen as FlowScreen.TaskListDetail).copy(
                    state = oldState.currentTaskListState.copy(
                        tasks = updatedTasks
                    )
                )
            )
            
            val sideEffects = listOf(
                SideEffect.CompleteTask(intent.taskId),  // Persist to DB
                SideEffect.EmitEvent(DomainEvent.TaskCompleted(...)),
                SideEffect.ShowSnackbar("Task completed", action = SnackbarAction("Undo") {
                    AppIntent.UndoLastAction
                })
            )
            
            Pair(newState, sideEffects)
        }
        
        is AppIntent.MoveTask -> {
            // Calculate new position values
            // Rebuild list with reordered tasks
            // Return new state + persist side effect
            TODO()
        }
        
        is AppIntent.UndoLastAction -> {
            // Pop from undoStack
            // Restore previous task state
            // Emit reverse event
            TODO()
        }
        
        else -> Pair(oldState, emptyList())  // Delegate other intents
    }
}