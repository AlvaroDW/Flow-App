class FlowViewModel(
    private val taskUseCases: TaskUseCases,
    private val listUseCases: ListUseCases
) : ViewModel() {
    
    private val _intentFlow = MutableSharedFlow<AppIntent>()
    private val _state = MutableStateFlow(initialState)
    
    init {
        viewModelScope.launch {
            _intentFlow.collect { intent ->
                val (newState, sideEffects) = reduce(_state.value, intent)
                _state.value = newState
                processSideEffects(sideEffects)
            }
        }
    }
    
    fun sendIntent(intent: AppIntent) {
        viewModelScope.launch {
            _intentFlow.emit(intent)
        }
    }
    
    val state: StateFlow<FlowAppState> = _state.asStateFlow()
    
    private fun processSideEffects(effects: List<SideEffect>) {
        effects.forEach { effect ->
            when (effect) {
                is SideEffect.CompleteTask -> {
                    taskUseCases.completeTask(effect.taskId)
                    // Notify ReminderScheduler if needed
                }
                is SideEffect.EmitEvent -> { /* publish to event bus */ }
                is SideEffect.ShowSnackbar -> { /* UI will render */ }
            }
        }
    }
}