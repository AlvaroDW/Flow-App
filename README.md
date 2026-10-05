# Flow

Flow is a personal task management app project. It aims to let users create tasks, organize them into lists, set due dates and reminders, prioritize tasks, and review completed ones.

The visual direction is based on `concept_interface.png`: a mobile interface with a dark background, rounded cards, purple accents, and bottom navigation between **Lists**, **Today**, and **Completed**.

## Project status

**In the early design and development stage.** The repository contains domain models, repository and use case interfaces, UI state models, and an outline of the event flow. It does not yet provide a runnable application.

There are no Gradle configuration files, Gradle Wrapper, declared dependencies, or automated tests. The data layer is empty, and some code contains pseudocode, undefined references, and unfinished operations (`TODO`). The features below describe the intended scope; their presence in models or interfaces does not mean they are functional.

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

## Architecture

The structure is intended for **Kotlin Multiplatform**, with a shared domain layer and directories reserved for Android and iOS. The documentation proposes **Jetpack Compose** for the UI and an **MVI** approach to unidirectional state flow. Multiplatform configuration and Compose screens are still pending.

| Layer | Responsibility | Current status |
| --- | --- | --- |
| `flow-domain` | Entities, domain rules, events, and contracts for data access and use cases. | Initial models and contracts; implementations and fixes needed for compilation are missing. |
| `flow-data` | Persistence and integration with platform services. | Directory structure without implementation files. |
| `flow-ui` | Navigation, presentation state, and user action processing. | State models, intents, an initial `FlowViewModel`, and an example reducer. |

In the intended flow, the UI sends an `AppIntent`, and the `FlowViewModel` applies the reducer and publishes a new state. Associated effects execute use cases that access repositories. Reactive contracts use `Flow`, while the presentation outline uses `StateFlow` and `SharedFlow`.

Design decisions include:

- **Fractional ordering:** represent a task's position using `PositionValue` to insert items between others. The `between` algorithm is pending.
- **Platform-specific reminders:** decouple reminder scheduling and cancellation through `ReminderScheduler`.
- **Local persistence as the foundation:** prioritize offline use. Storage and synchronization are not implemented.
- **Immutable state and events:** represent changes through new states and domain events.
- **Undo actions:** define contracts for recording and retrieving task operations.

See the [architectural decisions](docs/ARCHITECTURE.MD) for more detail on the intended design.

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

## Model and business rules

`Task` represents a task with a title, optional description, associated list, completion status, dates, position, and optional reminder reference. `TaskList` represents a list with a name, color, order, and archive status.

The models include validation for nonblank task titles of up to 100 characters, descriptions of up to 2000 characters, and nonblank list names of up to 50 characters. The code still requires fixes before it can be compiled and these validations verified.

The [business rules](docs/RULES.md) also specify that:

- Each task belongs to exactly one list.
- Task positions must be unique within their list.
- At least one default list must exist.
- A completed task cannot retain active reminders.
- When creating a task, its due date cannot be in the past.
- Lists containing tasks are not permanently deleted; archiving or soft deletion is intended instead.

These rules are design requirements; full enforcement still needs to be implemented in use cases and repositories.

## Development and running the app

For now, the code and documentation can be explored, but **no build or run procedure is available**. Versions of Kotlin, the JDK, Gradle, and platform SDKs have not been specified either.

To turn this foundation into a runnable application, the next steps are:

1. Configure Gradle, its modules, multiplatform source sets, and the required dependencies.
2. Fix incomplete declarations, resolve types and imports, and replace pseudocode with compilable code.
3. Implement use cases and repositories, including local persistence and default list creation.
4. Complete fractional ordering and reminder integration for each platform.
5. Build the screens and connect navigation, state, drag-and-drop interactions, and effects to the domain logic.
6. Add tests for business rules and main user flows, and document verified build and run commands.

To get familiar with the project, start with the [rules](docs/RULES.md), continue with the [architecture](docs/ARCHITECTURE.MD), and then review `flow-domain` and `flow-ui`.

## License

This project is distributed under the [MIT license](LICENSE). Copyright © 2026 ÁlvaroDW.
