package com.example.composematerialdesign.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Yükseltilmiş (Elevated) card bileşeni
 *
 * Güçlü gölge efekti ile içeriği öne çıkaran bu card türü,
 * önemli bilgileri ve etkileşimli elementleri vurgulamak için
 * tasarlanmıştır.
 *
 * Kullanım Alanları:
 * - Önemli duyurular
 * - Call-to-action kartları
 * - Öne çıkan içerik
 * - İnteraktif paneller
 * - Dashboard widget'ları
 *
 * Tasarım Özellikleri:
 * - 8dp yüksek elevation (gölge)
 * - Zengin içerik alanı
 * - Horizontal divider ile bölünmüş içerik
 * - İki aksiyon butonu
 * - Material Design 3 color scheme
 *
 * @param modifier Bileşeni özelleştirmek için modifier
 * @param title Kartın başlık metni
 * @param description Kartın açıklama metni
 * @param primaryActionText Birinci buton metni
 * @param secondaryActionText İkinci buton metni
 * @param onPrimaryAction Birinci butona tıklandığında çalışacak fonksiyon
 * @param onSecondaryAction İkinci butona tıklandığında çalışacak fonksiyon
 * @param elevation Kartın gölge yüksekliği (varsayılan: 8dp)
 *
 * Örnek Kullanım:
 * ```
 * ElevatedCardExample(
 *     title = "Yeni Özellik",
 *     description = "Uygulamaya yeni özellikler eklendi!",
 *     primaryActionText = "Keşfet",
 *     secondaryActionText = "Daha Sonra",
 *     onPrimaryAction = { exploreFeatures() },
 *     onSecondaryAction = { dismissCard() }
 * )
 * ```
 *
 * Material Design Referansı:
 * https://m3.material.io/components/cards/specs#elevated
 */
@Composable
fun ElevatedCardExample(
    modifier: Modifier = Modifier,
    title: String = "Yükseltilmiş Tasarım",
    description: String = "Güçlü gölge efekti ile içeriği öne çıkarır. Önemli bilgileri ve etkileşimli elementleri vurgulamak için mükemmeldir.",
    primaryActionText: String = "Aksiyon 1",
    secondaryActionText: String = "Aksiyon 2",
    onPrimaryAction: () -> Unit = {},
    onSecondaryAction: () -> Unit = {},
    elevation: androidx.compose.ui.unit.Dp = 8.dp
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        )
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

            // Ayırıcı çizgi
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = MaterialTheme.colorScheme.outlineVariant
            )

            // Aksiyon butonları
            ActionButtons(
                primaryText = primaryActionText,
                secondaryText = secondaryActionText,
                onPrimaryClick = onPrimaryAction,
                onSecondaryClick = onSecondaryAction
            )
        }
    }
}

/**
 * Card için aksiyon butonları
 *
 * Yan yana iki buton: Filled ve Outlined
 * Eşit genişlikte (weight = 1f) gösterilir
 *
 * @param primaryText Ana buton metni
 * @param secondaryText İkincil buton metni
 * @param onPrimaryClick Ana butona tıklandığında çalışır
 * @param onSecondaryClick İkincil butona tıklandığında çalışır
 */
@Composable
private fun ActionButtons(
    primaryText: String,
    secondaryText: String,
    onPrimaryClick: () -> Unit,
    onSecondaryClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Birincil aksiyon butonu (Filled)
        Button(
            onClick = onPrimaryClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(primaryText)
        }

        // İkincil aksiyon butonu (Outlined)
        OutlinedButton(
            onClick = onSecondaryClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(secondaryText)
        }
    }
}

