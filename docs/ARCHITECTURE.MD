# Architectural decisions

## Overview
This document outlines the key architectural decisions made in the design of the Flow application. Each decision is documented with its rationale to provide context and reasoning behind the choices made.

| Decision | Choice | Rationale |
|---|---|---|
| Ordering | Fractional (PositionValue) | O(1) inserts, no cascade updates, undo-friendly |
| Completion | Boolean + timestamp | Simple UI, supports "completed today" queries |
| Reminders | Abstraction interface | Allows iOS/Android-specific schedulers + graceful fallback |
| State Propagation | Events + reactive repositories | Enables optimistic UI without tight coupling |
| Persistence | Offline-first Flow streams | Works without network, sync later if added |
| Naming | UUID strings | Easy serialization, no migration pain on iOS/Android |

## State management
in the Flow application, state management is handled using a unidirectional data flow architecture. The core components of this architecture include:
- UI Layer: The user interface is built using Jetpack Compose, which allows for declarative UI development. The UI layer observes state changes and renders the appropriate UI based on the current state.
- Intent: User actions and events are captured as intents, which are sealed interfaces representing different user interactions. Intents are dispatched to the ViewModel for processing.
- ViewModel: The ViewModel acts as a reducer, processing intents and updating the state accordingly. It maintains the current state and exposes it to the UI layer. The ViewModel also handles side effects, such as navigation or displaying messages.
- State: The state is represented as an immutable data structure, ensuring that any changes to the state result in a new state object. This immutability helps prevent unintended side effects and makes it easier to reason about the application's behavior.
- Domain/Use Cases: The domain layer contains the business logic and use cases of the application. It encapsulates the core functionality and provides a clear separation of concerns between the UI and the underlying business logic. The domain layer interacts with repositories to fetch or persist data as needed.
- Repository: The repository layer is responsible for data access and persistence. It abstracts away the details of data storage, allowing the domain layer to interact with data sources without being tightly coupled to specific implementations. The repository can handle data from various sources, such as local databases or remote APIs.

## Drag-and-drop logic

## Reminders and due dates

## State architecture

### State flow
The state flow in the application follows a unidirectional data flow pattern, ensuring that state changes are predictable and manageable. The flow consists of the following components:

┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│   UI Layer  │────▶│   Intent    │────▶│  ViewModel  │
│  (Compose)  │     │  (Sealed)   │     │  (Reducer)  │
└─────────────┘     └─────────────┘     └─────────────┘
       ▲                                   │
       │                                   ▼
       │                            ┌─────────────┐
       │◀───────────────────────────│    State    │
       │                            │ (Immutable) │
       │                            └─────────────┘
       │                                   │
       │                                   ▼
       │                            ┌─────────────┐
       └────────────────────────────│ Domain/Use  │
                                    │   Cases     │
                                    └─────────────┘
                                             │
                                             ▼
                                    ┌─────────────┐
                                    │ Repository  │
                                    │  (DB, etc.) │
                                    └─────────────┘

### State design decisions

| Design Choice | Reasoning |
|---|---|
| MVI over MVVM | Predictable state for complex interactions (drag-drop, undo) |
| Sealed interfaces for filters/sorts | Exhaustive when-checks prevent invalid combinations |
| dragging*Id fields | Immediate visual feedback without waiting for persistence |
| animationTarget property | Smooth Compose animations without layout thrashing |
| Separate SideEffect type | Keeps reducer pure, separates business logic from UI side-effects |
| Explicit error/loading states | No "null means loading" ambiguity |





