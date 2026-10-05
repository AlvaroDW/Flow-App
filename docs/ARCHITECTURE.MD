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