package com.example.composematerialdesign.components.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

/**
 * TopBar navigasyon ikonu (Geri butonu)
 *
 * Bu bileşen TopAppBar'ın sol tarafında görünen geri butonudur.
 * Sadece arama modu aktif olduğunda etkileşimlidir.
 *
 * Davranış:
 * - Normal modda: Görünür ama etkisiz (sadece görsel tutarlılık için)
 * - Arama modunda: Tıklanabilir, arama modunu kapatır
 *
 * Bu tasarım, TopAppBar'ın tutarlı bir görünüm sağlamasını
 * ve kullanıcının arama modundan çıkması için sezgisel bir yol
 * sunmasını sağlar.
 *
 * @param searchMode Arama modunun aktif olup olmadığı
 * @param onBackClick Geri butonuna tıklandığında çalışacak fonksiyon
 *
 * Kullanıcı Deneyimi:
 * - Arama başladığında kullanıcı geri butonunu görebilir
 * - Geri butonu arama modunu kapatır ve normal moda döner
 * - Arama metni temizlenir
 *
 * Material Design Standartı:
 * AutoMirrored icon kullanılır, böylece RTL (Right-to-Left)
 * dillerde otomatik olarak yön değiştirir.
 */
@Composable
fun TopBarNavigationIcon(
    searchMode: Boolean,
    onBackClick: () -> Unit
) {
    IconButton(
        onClick = {
            if (searchMode) {
                onBackClick()
            }
        }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = if (searchMode) "Aramadan çık" else "Geri"
        )
    }
}

