# Material Design 3 Showcase App

A comprehensive showcase application demonstrating modern Android UI components with Material Design 3, built using Jetpack Compose.

## Overview

This project serves as a complete reference for implementing Material Design 3 components in Android applications. It features a clean, modular architecture with extensive documentation and real-world examples.

## Features

### Card Components
- **Advanced Card** - Profile cards with avatar, menu, and actions
- **Outlined Card** - Minimal design with border emphasis
- **Elevated Card** - High elevation cards with action buttons
- **Image Card** - Media-rich cards with image placeholders

### UI Components
- **Bottom Navigation Bar** - Modern tab navigation with badges
- **Floating Action Buttons** - Multiple FAB variants (Small, Standard, Large, Extended)
- **Chips** - Filter, Input, Assist, and Suggestion chips
- **Dialogs** - Alert dialogs with customizable themes
- **Snackbars** - Feedback messages with action support
- **List Items** - Contact lists, notification items, and action lists
- **Progress Indicators** - Linear and circular progress with variants

### Navigation
- **Top App Bar** - Dynamic search and menu functionality
- **Bottom Navigation** - Four-tab navigation with badge support

## Project Structure

```
app/src/main/java/com/example/composematerialdesign/
├── MainActivity.kt
├── screens/
│   ├── MainScreen.kt (Card showcase)
│   └── ComponentsShowcaseScreen.kt (UI components demo)
└── components/
    ├── topbar/
    │   ├── TopBar.kt
    │   ├── TopBarTitle.kt
    │   ├── TopBarNavigationIcon.kt
    │   ├── TopBarActions.kt
    │   └── TopBarDropdownMenu.kt
    ├── cards/
    │   ├── AdvancedCard.kt
    │   ├── OutlinedCardExample.kt
    │   ├── ElevatedCardExample.kt
    │   └── ImageCard.kt
    ├── navigation/
    │   └── BottomNavigationBar.kt
    ├── buttons/
    │   └── FloatingActionButtons.kt
    ├── chips/
    │   └── Chips.kt
    ├── dialogs/
    │   └── Dialogs.kt
    ├── feedback/
    │   └── Snackbars.kt
    ├── lists/
    │   └── ListItems.kt
    └── progress/
        └── ProgressIndicators.kt
```

## Architecture

### Design Principles
- **Single Responsibility**: Each component has one clear purpose
- **Modularity**: Every component in its own file
- **Reusability**: All components are independent and reusable
- **Documentation**: Comprehensive KDoc comments for all public APIs

### Tech Stack
- **Kotlin** - 100% Kotlin codebase
- **Jetpack Compose** - Modern declarative UI
- **Material Design 3** - Latest design system
- **Material Theme** - Dynamic color system support

## Components Details

### Bottom Navigation Bar
Four-tab navigation with badge support:
- Cards showcase
- Components demo
- Notifications (with badge counter)
- Profile

### Floating Action Buttons
- **Small FAB** - 40dp, for secondary actions
- **Standard FAB** - 56dp, most common variant
- **Large FAB** - 96dp, for prominent actions
- **Extended FAB** - Icon + text, for descriptive actions

### Chips
- **Filter Chip** - Selectable filters (single/multiple selection)
- **Input Chip** - User input tags (dismissible)
- **Assist Chip** - Suggestions and quick actions
- **Suggestion Chip** - Recommendations

### Dialogs
- **Simple Alert** - Standard confirmation dialog
- **Icon Alert** - Warning dialog with icon
- **Info Dialog** - Information display

### Progress Indicators
- **Linear Progress** - Determinate and indeterminate
- **Circular Progress** - With percentage display
- **Colored Progress** - Status-based colors (success, warning, error)

### List Items
- **Simple List** - Basic contact-style list
- **Notification List** - Unread badge and timestamp
- **Action List** - With favorite and delete actions

## Material Design 3 Features

### Dynamic Colors
All components use Material Theme color scheme:
```kotlin
MaterialTheme.colorScheme.primary
MaterialTheme.colorScheme.primaryContainer
MaterialTheme.colorScheme.secondary
MaterialTheme.colorScheme.tertiary
MaterialTheme.colorScheme.surface
MaterialTheme.colorScheme.error
```

### Typography
Consistent typography scale:
```kotlin
MaterialTheme.typography.displayLarge
MaterialTheme.typography.titleLarge
MaterialTheme.typography.bodyMedium
MaterialTheme.typography.labelSmall
```

### Elevation
Material 3 elevation system:
- Cards: 2dp - 6dp
- FABs: 6dp
- Dialogs: 24dp

## Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- JDK 17 or higher
- Min SDK 24
- Target SDK 34

### Installation
1. Clone the repository
```bash
git clone https://github.com/yourusername/ComposeMaterialDesign.git
```

2. Open the project in Android Studio

3. Sync Gradle files

4. Run the app on an emulator or physical device

## Usage Examples

### Using AdvancedCard
```kotlin
AdvancedCard(
    title = "John Doe",
    subtitle = "Android Developer",
    avatarText = "JD",
    onClick = { /* Handle click */ },
    onEditClick = { /* Handle edit */ },
    onShareClick = { /* Handle share */ },
    onDeleteClick = { /* Handle delete */ }
)
```

### Using FilterChips
```kotlin
var selected by remember { mutableStateOf(false) }
FilterChipExample(
    label = "Active",
    selected = selected,
    onSelectedChange = { selected = it }
)
```

### Using Dialogs
```kotlin
var showDialog by remember { mutableStateOf(false) }
SimpleAlertDialog(
    showDialog = showDialog,
    onDismiss = { showDialog = false },
    onConfirm = { /* Handle confirm */ },
    title = "Confirm Action",
    message = "Are you sure?"
)
```

## Customization

### Colors
Modify `ui/theme/Color.kt` to change the app's color scheme.

### Typography
Adjust `ui/theme/Type.kt` for custom fonts and text styles.

### Shapes
Edit `ui/theme/Shape.kt` for component corner radius.

## Best Practices

### State Management
- Use `remember` for local state
- Hoist state when needed
- Use `MutableState` for reactive UI

### Performance
- LazyColumn for scrollable lists
- Avoid recomposition with `remember`
- Use `derivedStateOf` for computed values

### Accessibility
- Provide contentDescription for icons
- Use semantic properties
- Support TalkBack

## Documentation

- **ARCHITECTURE.md** - Detailed architecture documentation
- **YAPIM_NOTLARI.md** - Development notes (Turkish)
- **KDoc comments** - In-code documentation

## Code Quality

- Clean Architecture principles
- SOLID principles applied
- 100% Kotlin
- Zero critical errors
- Comprehensive documentation

## Contributing

This is a showcase project. Feel free to fork and modify for your needs.

## License

This project is provided as-is for educational and reference purposes.

## Resources

### Material Design
- [Material Design 3](https://m3.material.io/)
- [Compose Material 3](https://developer.android.com/jetpack/compose/designsystems/material3)

### Jetpack Compose
- [Compose Documentation](https://developer.android.com/jetpack/compose)
- [Compose Samples](https://github.com/android/compose-samples)

### Android Development
- [Android Developers](https://developer.android.com/)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)

## Screenshots

The app features two main screens:
1. **Cards Showcase** - Demonstrates different card types
2. **Components Showcase** - Shows various UI components

## Performance

- Smooth 60 FPS animations
- Efficient recomposition
- Optimized scroll performance
- Small APK size

## Future Enhancements

Potential additions:
- Dark theme variants
- Custom theme picker
- Animation examples
- Accessibility features demo
- Performance metrics

## Author

Professional Android showcase application demonstrating modern UI patterns and best practices.

## Version

- **Version**: 2.0
- **Last Updated**: December 2025
- **Min SDK**: 24
- **Target SDK**: 34
- **Compose BOM**: Latest

---

Built with ❤️ using Jetpack Compose and Material Design 3

