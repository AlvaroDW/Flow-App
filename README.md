# Flow

Flow is a personal task management app designed to help you organize your day. Keep tasks in dedicated lists, focus on what matters, and track your progress through a simple mobile interface.

**Status: In development.** The features below describe the app's intended experience.

## Main features

| Feature | Intended behavior | Existing foundation |
| --- | --- | --- |
| Create and complete tasks | Add tasks from the main screen, mark them as completed, and mark them as pending again. | `Task` model, `addTask`, `completeTask`, and `uncompleteTask` contracts, and `ToggleTaskComplete` intent. |
| Due dates and reminders | Assign a due date and time and configure a reminder for each task. | Date and reminder fields, `setDueDate` and `setReminder` contracts, and `ReminderScheduler` abstraction. |
| Custom lists | Create lists such as Work, Personal, and Groceries to group tasks. | `TaskList` model, planned default list identifiers, and contracts for creating, renaming, archiving, restoring, and reordering lists. |
| Drag-and-drop ordering | Reorder tasks within a list according to their priority. | `PositionValue`, `moveTask` contract, and drag state fields. Position calculation and interaction remain unimplemented. |
| Completed view | Review finished tasks and their completion dates. | `completedTasks` query, `FlowScreen.Completed` route, and `CompletedListUiState` and `CompletedTaskRow` models. |

The design also includes filters for active, completed, due-today, and overdue tasks; sorting by priority, due date, or creation date; light, dark, and system themes; and the ability to undo actions. These elements are partially defined but do not yet have a complete working implementation.

## Intended user experience

1. Open **Lists** and select or create a list.
2. Add a task with a title and an optional description, due date, and reminder.
3. Drag tasks to adjust their priority order.
4. Use **Today** to focus on tasks due that day.
5. Mark a task as finished and review it in **Completed**.

The **Today** section comes from the visual concept. The code includes the `TaskFilter.DueToday` filter but does not yet define a dedicated screen for it. The reference image is not included in this repository.

## Documentation

See the [architecture](docs/ARCHITECTURE.MD) and [business rules](docs/RULES.md) for technical details.

## Repository structure

```text
.
├── docs/
│   ├── ARCHITECTURE.MD          # Architectural decisions and state management
│   └── RULES.md                 # Invariants and business rules
├── flow-domain/
│   └── commonMain/kotlin/
│       ├── entity/              # Task, TaskList, positions, and reminders
│       ├── event/               # Domain events
│       ├── repository/          # Repository and scheduler contracts
│       └── usecase/             # Use case contracts, inputs, and results
├── flow-data/
│   └── src/
│       ├── commonMain/          # Reserved for shared data
│       ├── androidMain/         # Reserved for Android integrations
│       └── iosMain/             # Reserved for iOS integrations
├── flow-ui/
│   └── src/
│       ├── AndroidMain/         # States, intents, ViewModel, and reducer
│       └── iosMain/             # Reserved directory, no implementation
├── LICENSE
└── README.md
```

This shows the current local structure, including the capitalization of `AndroidMain`. Empty directories may not appear when cloning the repository because Git does not track them.

## License

Licensed under the [MIT license](LICENSE). Copyright © 2026 ÁlvaroDW.
