package com.example.composematerialdesign.components.cards

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Gelişmiş özellikler içeren modern card bileşeni
 *
 * Bu card bileşeni profesyonel kullanıcı profil kartları, sosyal medya gönderileri
 * veya liste öğeleri için tasarlanmıştır.
 *
 * Özellikler:
 * - Dairesel avatar gösterimi (baş harflerle)
 * - İki satırlı metin içeriği (başlık ve alt başlık)
 * - Üç nokta menüsü (düzenle, paylaş, sil)
 * - Tıklanabilir yapı
 * - Smooth animasyonlar
 * - Material Design 3 uyumlu
 *
 * @param modifier Bileşeni özelleştirmek için modifier
 * @param title Kartın başlık metni (örn: kullanıcı adı)
 * @param subtitle Kartın alt başlık metni (örn: pozisyon, açıklama)
 * @param avatarText Avatar üzerinde gösterilecek metin (genellikle baş harfler)
 * @param onClick Karta tıklandığında çalışacak fonksiyon (opsiyonel)
 * @param onEditClick Düzenle seçeneğine tıklandığında çalışacak fonksiyon
 * @param onShareClick Paylaş seçeneğine tıklandığında çalışacak fonksiyon
 * @param onDeleteClick Sil seçeneğine tıklandığında çalışacak fonksiyon
 *
 * Örnek Kullanım:
 * ```
 * AdvancedCard(
 *     title = "Ahmet Yılmaz",
 *     subtitle = "Android Developer • Compose uzmanı",
 *     avatarText = "AY",
 *     onClick = { navController.navigate("profile") },
 *     onEditClick = { viewModel.editProfile() },
 *     onShareClick = { shareProfile() },
 *     onDeleteClick = { showDeleteDialog() }
 * )
 * ```
 */
@Composable
fun AdvancedCard(
    modifier: Modifier = Modifier,
    title: String = "Başlık",
    subtitle: String = "Alt açıklama metni burada olacak.",
    avatarText: String = "AY",
    onClick: (() -> Unit)? = null,
    onEditClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .animateContentSize()
            .then(
                if (onClick != null) Modifier.clickable { onClick() }
                else Modifier
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar bileşeni
            CardAvatar(text = avatarText)

            // İçerik bileşeni
            CardContent(
                title = title,
                subtitle = subtitle,
                modifier = Modifier.weight(1f)
            )

            // Menü bileşeni
            CardMenu(
                onEditClick = onEditClick,
                onShareClick = onShareClick,
                onDeleteClick = onDeleteClick
            )
        }
    }
}

/**
 * Card için dairesel avatar bileşeni
 *
 * Kullanıcının baş harflerini veya kısa metni gösterir.
 * Primary renk kullanarak tema ile uyumlu çalışır.
 *
 * @param text Avatar üzerinde gösterilecek metin (max 2-3 karakter önerilir)
 */
@Composable
private fun CardAvatar(text: String) {
    Surface(
        modifier = Modifier.size(56.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/**
 * Card'ın metin içeriğini gösteren bileşen
 *
 * İki satırlı yapı ile başlık ve alt başlık gösterir.
 * Başlık bold, alt başlık ise normal yazı stiliyle gösterilir.
 *
 * @param title Kalın yazı ile gösterilen ana başlık
 * @param subtitle Normal yazı ile gösterilen açıklama metni
 * @param modifier Bileşeni özelleştirmek için modifier
 */
@Composable
private fun CardContent(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(start = 16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

/**
 * Card için üç nokta menü butonu ve dropdown menü
 *
 * Üç seçenek sunar: Düzenle, Paylaş, Sil
 * Her seçenek için ayrı callback fonksiyonu alır.
 *
 * @param onEditClick Düzenle seçeneğine tıklandığında çalışır
 * @param onShareClick Paylaş seçeneğine tıklandığında çalışır
 * @param onDeleteClick Sil seçeneğine tıklandığında çalışır
 */
@Composable
private fun CardMenu(
    onEditClick: () -> Unit,
    onShareClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { showMenu = true }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Menüyü aç",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            DropdownMenuItem(
                text = { Text("📝 Düzenle") },
                onClick = {
                    showMenu = false
                    onEditClick()
                }
            )
            DropdownMenuItem(
                text = { Text("📤 Paylaş") },
                onClick = {
                    showMenu = false
                    onShareClick()
                }
            )
            HorizontalDivider()
            DropdownMenuItem(
                text = {
                    Text(
                        "🗑️ Sil",
                        color = MaterialTheme.colorScheme.error
                    )
                },
                onClick = {
                    showMenu = false
                    onDeleteClick()
                }
            )
        }
    }
}

