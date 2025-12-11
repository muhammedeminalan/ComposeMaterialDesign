package com.example.composematerialdesign.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Bottom Navigation Bar bileşeni
 *
 * Modern mobil uygulamalarda en yaygın kullanılan navigasyon bileşeni.
 * 3-5 ana bölüm arasında geçiş için kullanılır.
 *
 * Kullanım Alanları:
 * - Ana sayfa navigasyonu
 * - Sosyal medya uygulamaları
 * - E-ticaret uygulamaları
 * - Dashboard'lar
 *
 * Material Design 3 Özellikleri:
 * - Aktif/Pasif durum renkleri
 * - İkon ve etiket gösterimi
 * - Smooth animasyonlar
 * - Tema uyumlu renkler
 *
 * @param selectedIndex Seçili olan tab'ın index'i
 * @param onItemSelected Tab seçildiğinde çalışacak fonksiyon
 * @param items NavigationBar'da gösterilecek öğeler listesi
 */
@Composable
fun BottomNavigationBar(
    selectedIndex: Int = 0,
    onItemSelected: (Int) -> Unit = {},
    items: List<BottomNavItem> = defaultBottomNavItems()
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null && item.badgeCount > 0) {
                                Badge {
                                    Text(
                                        text = if (item.badgeCount > 99) "99+" else item.badgeCount.toString(),
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label
                        )
                    }
                },
                label = { Text(item.label) },
                selected = selectedIndex == index,
                onClick = { onItemSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }
}

/**
 * Bottom Navigation öğesi data class'ı
 *
 * @param icon Gösterilecek ikon
 * @param label Öğe etiketi
 * @param badgeCount Badge üzerinde gösterilecek sayı (opsiyonel)
 * @param route Navigasyon route'u (opsiyonel)
 */
data class BottomNavItem(
    val icon: ImageVector,
    val label: String,
    val badgeCount: Int? = null,
    val route: String = ""
)

/**
 * Varsayılan bottom navigation öğeleri
 * Yaygın kullanım senaryoları için hazır örnekler
 */
fun defaultBottomNavItems() = listOf(
    BottomNavItem(
        icon = Icons.Filled.Home,
        label = "Cards",
        route = "cards"
    ),
    BottomNavItem(
        icon = Icons.Filled.Search,
        label = "Components",
        route = "components"
    ),
    BottomNavItem(
        icon = Icons.Filled.Notifications,
        label = "Bildirimler",
        badgeCount = 5,
        route = "notifications"
    ),
    BottomNavItem(
        icon = Icons.Filled.Person,
        label = "Profil",
        route = "profile"
    )
)

