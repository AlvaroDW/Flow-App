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

## State flow
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

## State design decisions

| Design Choice | Reasoning |
|---|---|
| MVI over MVVM | Predictable state for complex interactions (drag-drop, undo) |
| Sealed interfaces for filters/sorts | Exhaustive when-checks prevent invalid combinations |
| dragging*Id fields | Immediate visual feedback without waiting for persistence |
| animationTarget property | Smooth Compose animations without layout thrashing |
| Separate SideEffect type | Keeps reducer pure, separates business logic from UI side-effects |
| Explicit error/loading states | No "null means loading" ambiguity |





