package com.example.composematerialdesign.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Kenar çizgili (Outlined) card bileşeni
 *
 * Minimal ve modern tasarım için ideal olan bu card türü,
 * içeriği hafif bir çerçeve ile vurgular. Gölge efekti olmadan
 * temiz bir görünüm sunar.
 *
 * Kullanım Alanları:
 * - Bilgi kutuları
 * - Form alanları
 * - Liste öğeleri
 * - Seçilebilir kartlar
 * - Veri grupları
 *
 * Tasarım Özellikleri:
 * - 2dp kalınlıkta outline border
 * - Yuvarlatılmış köşeler
 * - Gölge efekti yok (flat design)
 * - Tema outline rengi kullanımı
 * - Minimum padding ile geniş içerik alanı
 *
 * @param modifier Bileşeni özelleştirmek için modifier
 * @param title Kartın başlık metni
 * @param description Kartın açıklama metni
 * @param borderWidth Kenar çizgisi kalınlığı (varsayılan: 2dp)
 *
 * Örnek Kullanım:
 * ```
 * OutlinedCardExample(
 *     title = "Önemli Bilgi",
 *     description = "Bu alanda kullanıcıya önemli bir mesaj gösterilir.",
 *     borderWidth = 2.dp
 * )
 * ```
 *
 * Material Design Referansı:
 * https://m3.material.io/components/cards/specs#outlined
 */
@Composable
fun OutlinedCardExample(
    modifier: Modifier = Modifier,
    title: String = "Minimal Tasarım",
    description: String = "Kenar çizgili card tasarımı, içeriği çerçeveleyerek vurgulamak için idealdir. Sade ve modern görünüm sağlar.",
    borderWidth: androidx.compose.ui.unit.Dp = 2.dp
) {
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(borderWidth, MaterialTheme.colorScheme.outline)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Başlık
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Açıklama
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
            )
        }
    }
}

