# Invariants & Business Rules
In this document, we describe the invariants and business rules that govern the behavior of our system. These rules are essential for maintaining data integrity, ensuring consistent behavior, and providing a clear understanding of how the system operates.

## Invariants
1. **TaskList Association**: Every Task must be associated with exactly one TaskList.
2. **Unique Positioning**: Each Task within a TaskList must have a unique position value to maintain order and prevent conflicts.
3. **Default TaskList**: There must always be at least one default TaskList present in the system to ensure that users have a starting point for task management.

## Business Rules
| Rule | Description | Enforcement Point |
|---|---|---|
| R1 | A Task must belong to exactly one TaskList | Domain constructor |
| R2 | Completed tasks cannot have active reminders | Use Case validation |
| R3 | Due date cannot be in the past when creating new task | Use Case validation |
| R4 | Position values must remain unique within a list | Repository transaction |
| R5 | TaskLists cannot be deleted while containing tasks (soft-delete only) | Use Case validation |
| R6 | Minimum 1 default list always exists | Use Case validation |

