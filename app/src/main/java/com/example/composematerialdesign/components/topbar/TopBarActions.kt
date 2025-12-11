package com.example.composematerialdesign.components.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

/**
 * TopBar aksiyon butonları bölümü
 *
 * TopAppBar'ın sağ tarafında görünen aksiyon butonlarını yönetir.
 * İki ana buton içerir:
 * 1. Arama butonu (sadece normal modda görünür)
 * 2. Menü butonu (her zaman görünür)
 *
 * Dinamik Davranış:
 * - Normal Mod: Arama ikonu + Menü ikonu gösterilir
 * - Arama Modu: Sadece menü ikonu gösterilir
 *
 * Bu tasarım, ekran alanını verimli kullanır ve kullanıcıya
 * her zaman menüye erişim imkanı sunarken, arama modunda
 * arama alanına daha fazla yer açar.
 *
 * @param searchMode Arama modunun aktif olup olmadığı
 * @param showMenu Menünün gösterilip gösterilmediği
 * @param onSearchClick Arama butonuna tıklandığında çalışacak fonksiyon
 * @param onMenuClick Menü butonuna tıklandığında çalışacak fonksiyon
 * @param onMenuDismiss Menü kapatıldığında çalışacak fonksiyon
 * @param onMenuItemClick Menü öğesine tıklandığında çalışacak fonksiyon
 *
 * Material Design Guidelines:
 * - İkonlar sağa hizalıdır
 * - Birden fazla aksiyon varsa öncelik sırasına göre dizilir
 * - Overflow menü (⋮) her zaman en sağda yer alır
 */
@Composable
fun TopBarActions(
    searchMode: Boolean,
    showMenu: Boolean,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
    onMenuDismiss: () -> Unit,
    onMenuItemClick: (String) -> Unit
) {
    // Arama butonu (sadece normal modda)
    if (!searchMode) {
        IconButton(onClick = onSearchClick) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Ara"
            )
        }
    }

    // Menü butonu (her zaman)
    IconButton(onClick = onMenuClick) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = "Menü"
        )
    }

    // Dropdown menü
    TopBarDropdownMenu(
        expanded = showMenu,
        onDismiss = onMenuDismiss,
        onMenuItemClick = onMenuItemClick
    )
}
