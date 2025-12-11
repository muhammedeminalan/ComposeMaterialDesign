package com.example.composematerialdesign.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Görsel içerikli (Image) card bileşeni
 *
 * Üst kısımda görsel, alt kısımda metin içeriği ve aksiyon butonları
 * içeren modern card tasarımı. Galeri, ürün kartları ve medya önizlemeleri
 * için idealdir.
 *
 * Kullanım Alanları:
 * - Haber kartları
 * - Ürün kartları (e-ticaret)
 * - Blog gönderisi önizlemeleri
 * - Galeri öğeleri
 * - Video önizlemeleri
 * - Portfolio öğeleri
 *
 * Tasarım Özellikleri:
 * - 180dp yükseklikte görsel alan
 * - Emoji placeholder (gerçek resim kullanılabilir)
 * - İki aksiyon butonu (DETAY, PAYLAŞ)
 * - 16dp yuvarlatılmış köşeler
 * - 6dp elevation
 * - Material Design 3 color scheme
 *
 * @param modifier Bileşeni özelleştirmek için modifier
 * @param imageContent Görsel alan için composable içerik
 * @param title Kartın başlık metni
 * @param description Kartın açıklama metni
 * @param detailButtonText Detay butonu metni
 * @param shareButtonText Paylaş butonu metni
 * @param onDetailClick Detay butonuna tıklandığında çalışacak fonksiyon
 * @param onShareClick Paylaş butonuna tıklandığında çalışacak fonksiyon
 *
 * Örnek Kullanım:
 * ```
 * ImageCard(
 *     imageContent = {
 *         AsyncImage(
 *             model = imageUrl,
 *             contentDescription = "Ürün görseli"
 *         )
 *     },
 *     title = "Yeni Ürün",
 *     description = "En yeni teknoloji ile üretildi",
 *     onDetailClick = { navController.navigate("details") },
 *     onShareClick = { shareProduct() }
 * )
 * ```
 *
 * Material Design Referansı:
 * https://m3.material.io/components/cards/guidelines#media
 */
@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    imageContent: @Composable () -> Unit = { ImagePlaceholder() },
    title: String = "Görsel İçerikli Card",
    description: String = "Resim veya medya içeriği ile zenginleştirilmiş card bileşeni. Galeri, ürün kartları ve içerik önizlemeleri için idealdir.",
    detailButtonText: String = "DETAY",
    shareButtonText: String = "PAYLAŞ",
    onDetailClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column {
            // Görsel alan
            imageContent()

            // Metin içeriği ve butonlar
            CardContentSection(
                title = title,
                description = description,
                detailButtonText = detailButtonText,
                shareButtonText = shareButtonText,
                onDetailClick = onDetailClick,
                onShareClick = onShareClick
            )
        }
    }
}

/**
 * Image card'ın metin içeriği ve aksiyon butonları bölümü
 *
 * Başlık, açıklama ve iki text button içerir.
 *
 * @param title Başlık metni
 * @param description Açıklama metni
 * @param detailButtonText Detay butonu metni
 * @param shareButtonText Paylaş butonu metni
 * @param onDetailClick Detay butonuna tıklandığında çalışır
 * @param onShareClick Paylaş butonuna tıklandığında çalışır
 */
@Composable
private fun CardContentSection(
    title: String,
    description: String,
    detailButtonText: String,
    shareButtonText: String,
    onDetailClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
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

        // Aksiyon butonları
        CardActionButtons(
            detailButtonText = detailButtonText,
            shareButtonText = shareButtonText,
            onDetailClick = onDetailClick,
            onShareClick = onShareClick
        )
    }
}

/**
 * Image card için aksiyon butonları
 *
 * İki text button yan yana gösterir: Detay ve Paylaş
 *
 * @param detailButtonText Detay butonu metni
 * @param shareButtonText Paylaş butonu metni
 * @param onDetailClick Detay butonuna tıklandığında çalışır
 * @param onShareClick Paylaş butonuna tıklandığında çalışır
 */
@Composable
private fun CardActionButtons(
    detailButtonText: String,
    shareButtonText: String,
    onDetailClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextButton(onClick = onDetailClick) {
            Text(detailButtonText)
        }
        TextButton(onClick = onShareClick) {
            Text(shareButtonText)
        }
    }
}

/**
 * Görsel placeholder bileşeni
 *
 * Gerçek resim yüklenene kadar veya resim olmadığında
 * gösterilen placeholder alan. Emoji ile görsel olarak
 * temsil edilir.
 *
 * Bu fonksiyon yerine AsyncImage, Coil, veya Glide
 * kullanılarak gerçek resimler yüklenebilir.
 *
 * @param height Placeholder yüksekliği (varsayılan: 180dp)
 * @param emoji Gösterilecek emoji (varsayılan: 🖼️)
 *
 * Gerçek Resim Kullanımı Örneği:
 * ```
 * // Coil ile
 * AsyncImage(
 *     model = imageUrl,
 *     contentDescription = "Card image",
 *     modifier = Modifier
 *         .height(180.dp)
 *         .fillMaxWidth(),
 *     contentScale = ContentScale.Crop
 * )
 * ```
 */
@Composable
fun ImagePlaceholder(
    height: androidx.compose.ui.unit.Dp = 180.dp,
    emoji: String = "🖼️"
) {
    Box(
        modifier = Modifier
            .height(height)
            .fillMaxWidth()
            .clip(RectangleShape),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = emoji,
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    }
}

