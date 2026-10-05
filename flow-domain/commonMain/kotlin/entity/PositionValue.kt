// ==================== POSITION VALUE (FRACTIONAL ORDERING) ====================
/**
 * Instead of discrete indices (0, 1, 2, ...), we use lexicographic position values.
 * Between "A" and "C" we can insert "B" without reordering siblings.
 */
@JvmInline
value class PositionValue(val value: String) {
    companion object {
        val START = PositionValue("0")
        val END = PositionValue("Z")
        
        fun between(a: PositionValue, b: PositionValue): PositionValue {
            // Implementation: take midpoint of two strings
            // E.g., between "0" and "Z" → "7"
            TODO("Lexicographic midpoint calculation")
        }
    }
}