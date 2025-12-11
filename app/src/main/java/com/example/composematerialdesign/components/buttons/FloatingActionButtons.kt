package com.example.composematerialdesign.components.buttons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Floating Action Button (FAB) bileşenleri
 *
 * Ekranın ana aksiyonunu temsil eden öne çıkan buton.
 * Her ekranda genellikle tek bir FAB kullanılır.
 *
 * Kullanım Alanları:
 * - Yeni içerik oluşturma (Mesaj, Post, Görev)
 * - Ana aksiyon (Kaydet, Gönder, Ekle)
 * - Hızlı eylem tetikleme
 *
 * Material Design 3 Özellikleri:
 * - 3 farklı boyut (Small, Regular, Large)
 * - Extended FAB (ikon + metin)
 * - Tema uyumlu renkler
 * - Elevation ve shadow
 */

/**
 * Standart FAB
 * En yaygın kullanılan FAB türü
 *
 * @param onClick Butona tıklandığında çalışacak fonksiyon
 * @param icon Gösterilecek ikon
 * @param contentDescription Erişilebilirlik açıklaması
 */
@Composable
fun StandardFAB(
    onClick: () -> Unit = {},
    icon: ImageVector = Icons.Filled.Add,
    contentDescription: String = "Ekle"
) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}

/**
 * Küçük FAB
 * Daha az öne çıkması gereken aksiyonlar için
 *
 * @param onClick Butona tıklandığında çalışacak fonksiyon
 * @param icon Gösterilecek ikon
 * @param contentDescription Erişilebilirlik açıklaması
 */
@Composable
fun SmallFAB(
    onClick: () -> Unit = {},
    icon: ImageVector = Icons.Filled.Edit,
    contentDescription: String = "Düzenle"
) {
    SmallFloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}

/**
 * Büyük FAB
 * Ekranın en önemli aksiyonu için
 *
 * @param onClick Butona tıklandığında çalışacak fonksiyon
 * @param icon Gösterilecek ikon
 * @param contentDescription Erişilebilirlik açıklaması
 */
@Composable
fun LargeFAB(
    onClick: () -> Unit = {},
    icon: ImageVector = Icons.Filled.Add,
    contentDescription: String = "Yeni Oluştur"
) {
    LargeFloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}

/**
 * Extended FAB
 * İkon ve metin içeren genişletilmiş FAB
 * Daha açıklayıcı aksiyonlar için
 *
 * @param onClick Butona tıklandığında çalışacak fonksiyon
 * @param text Buton metni
 * @param icon Gösterilecek ikon
 * @param modifier Bileşeni özelleştirmek için modifier
 */
@Composable
fun ExtendedFABExample(
    onClick: () -> Unit = {},
    text: String = "Yeni Gönderi",
    icon: ImageVector = Icons.Filled.Add,
    modifier: Modifier = Modifier
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        text = { Text(text) },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
    )
}

