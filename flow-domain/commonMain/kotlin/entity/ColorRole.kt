// ==================== COLOR ROLE (THEMING TOKEN) ====================
enum class ColorRole {
    PRIMARY, SECONDARY, SURFACE, ACCENT, ERROR, NEUTRAL;
    
    // Each role maps to light/dark palettes in the UI layer
    fun resolveForTheme(theme: ThemeMode): HsvColor
}