// ==================== REMINDER REFERENCE (ABSTRACTION) ====================
data class ReminderReference(
    val id: String,           // Platform-specific notification ID
    val scheduledAt: Instant, // When to trigger
    val type: ReminderType
)