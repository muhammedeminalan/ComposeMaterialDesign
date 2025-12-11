package com.example.composematerialdesign.components.lists

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * Liste öğesi bileşenleri
 *
 * Sosyal medya, mesajlaşma ve içerik listeleri için
 * yaygın kullanılan liste öğeleri.
 *
 * Kullanım Alanları:
 * - Mesaj listeleri
 * - Kişi listeleri
 * - Bildirim listeleri
 * - İçerik akışları
 *
 * Material Design 3 Özellikleri:
 * - Avatar desteği
 * - İki/üç satırlı içerik
 * - Trailing actions (favorileme, silme vb.)
 * - Badge desteği
 */

/**
 * Basit liste öğesi
 * Avatar, başlık ve açıklama içerir
 *
 * @param title Liste öğesi başlığı
 * @param subtitle Liste öğesi alt başlığı
 * @param avatarText Avatar metni (genellikle baş harfler)
 * @param onClick Öğeye tıklandığında çalışacak fonksiyon
 * @param trailing Sağ tarafta gösterilecek içerik
 */
@Composable
fun SimpleListItem(
    title: String = "John Doe",
    subtitle: String = "Hey, how are you?",
    avatarText: String = "JD",
    onClick: () -> Unit = {},
    trailing: @Composable (() -> Unit)? = null
) {
    ListItem(
        headlineContent = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        },
        supportingContent = {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        },
        leadingContent = {
            Surface(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = avatarText,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        },
        trailingContent = trailing,
        modifier = Modifier.clickable { onClick() },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
}

/**
 * Bildirim liste öğesi
 * Badge ve zaman damgası içerir
 *
 * @param title Bildirim başlığı
 * @param message Bildirim mesajı
 * @param time Zaman bilgisi
 * @param isUnread Okunmamış durumu
 * @param icon Bildirim ikonu
 * @param onClick Öğeye tıklandığında çalışacak fonksiyon
 */
@Composable
fun NotificationListItem(
    title: String = "Yeni Mesaj",
    message: String = "Ahmet Yılmaz size bir mesaj gönderdi",
    time: String = "5 dk önce",
    isUnread: Boolean = true,
    icon: ImageVector = Icons.Filled.Notifications,
    onClick: () -> Unit = {}
) {
    ListItem(
        headlineContent = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = if (isUnread) FontWeight.Bold else FontWeight.Normal,
                    modifier = Modifier.weight(1f)
                )
                if (isUnread) {
                    Badge(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ) {
                        Text("YENİ", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        },
        supportingContent = {
            Column {
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = time,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        leadingContent = {
            Surface(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                color = if (isUnread)
                    MaterialTheme.colorScheme.secondaryContainer
                else
                    MaterialTheme.colorScheme.surfaceVariant
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (isUnread)
                            MaterialTheme.colorScheme.onSecondaryContainer
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        modifier = Modifier.clickable { onClick() },
        colors = ListItemDefaults.colors(
            containerColor = if (isUnread)
                MaterialTheme.colorScheme.surfaceContainerHighest.copy(alpha = 0.3f)
            else
                MaterialTheme.colorScheme.surface
        )
    )
}

/**
 * Aksiyon butonlu liste öğesi
 * Favorileme, silme gibi aksiyonlar içerir
 *
 * @param title Öğe başlığı
 * @param subtitle Öğe açıklaması
 * @param avatarIcon Avatar ikonu
 * @param isFavorite Favori durumu
 * @param onFavoriteClick Favori butonuna tıklandığında
 * @param onDeleteClick Sil butonuna tıklandığında
 * @param onClick Öğeye tıklandığında
 */
@Composable
fun ActionListItem(
    title: String = "Müzik Dosyası",
    subtitle: String = "Artist Name - 3:45",
    avatarIcon: ImageVector = Icons.Filled.PlayArrow,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    ListItem(
        headlineContent = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
        },
        supportingContent = {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        leadingContent = {
            Surface(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                color = MaterialTheme.colorScheme.tertiaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = avatarIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            }
        },
        trailingContent = {
            Row {
                IconButton(onClick = onFavoriteClick) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = "Favori",
                        tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                IconButton(onClick = onDeleteClick) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Sil",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        modifier = Modifier.clickable { onClick() }
    )
}

