package com.example.composematerialdesign.components.topbar

import androidx.compose.material3.*
import androidx.compose.runtime.*

/**
 * Ana TopAppBar bileşeni
 *
 * Modern ve etkileşimli bir üst navigasyon barı sağlar.
 * Arama modu, dropdown menü ve dinamik başlık özellikleri içerir.
 *
 * Özellikler:
 * - Normal ve arama modu arasında geçiş
 * - Geri butonu (arama modunda aktif)
 * - Arama ikonu (normal modda)
 * - Dropdown menü (her zaman)
 * - Material Design 3 dinamik renkleri
 *
 * Kullanım Senaryoları:
 * - Ana ekran navigasyonu
 * - Arama özellikli sayfalar
 * - Profil ve ayarlar menüsü
 *
 * @param title Normal modda gösterilecek başlık (varsayılan: "Material Design Showcase")
 * @param onMenuItemClick Menü öğesine tıklandığında çalışacak fonksiyon (menuItem parametresi alır)
 *
 * Örnek Kullanım:
 * ```
 * TopBar(
 *     title = "My App",
 *     onMenuItemClick = { menuItem ->
 *         when(menuItem) {
 *             "Profilim" -> navController.navigate("profile")
 *             "Ayarlar" -> navController.navigate("settings")
 *             "Hakkında" -> showAboutDialog()
 *             "Çıkış Yap" -> logout()
 *         }
 *     }
 * )
 * ```
 *
 * State Yönetimi:
 * - searchMode: Arama modunun aktif olup olmadığını kontrol eder
 * - searchText: Arama metnini saklar
 * - showMenu: Dropdown menünün görünürlüğünü kontrol eder
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String = "Material Design Showcase",
    onMenuItemClick: (String) -> Unit = {}
) {
    // State'ler
    var showMenu by remember { mutableStateOf(false) }
    var searchMode by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    TopAppBar(
        title = {
            TopBarTitle(
                searchMode = searchMode,
                searchText = searchText,
                title = title,
                onSearchTextChange = { searchText = it }
            )
        },
        navigationIcon = {
            TopBarNavigationIcon(
                searchMode = searchMode,
                onBackClick = {
                    searchMode = false
                    searchText = ""
                }
            )
        },
        actions = {
            TopBarActions(
                searchMode = searchMode,
                showMenu = showMenu,
                onSearchClick = { searchMode = true },
                onMenuClick = { showMenu = true },
                onMenuDismiss = { showMenu = false },
                onMenuItemClick = onMenuItemClick
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

