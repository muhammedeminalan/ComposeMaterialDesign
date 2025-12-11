package com.example.composematerialdesign.components.chips

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * Chip bileşenleri
 *
 * Compact öğeler, filtreler, seçimler ve etiketler için kullanılır.
 * Material Design 3'te 4 ana chip türü vardır.
 *
 * Kullanım Alanları:
 * - Filtre seçenekleri
 * - Etiketler (Tags)
 * - Seçilebilir kategoriler
 * - Kişi/İçerik gösterimi
 *
 * Chip Türleri:
 * - Assist Chip: Öneriler ve hızlı aksiyonlar
 * - Filter Chip: Filtreleme seçenekleri
 * - Input Chip: Kullanıcı girdisi (silinebilir)
 * - Suggestion Chip: Öneri ve etiketler
 */

/**
 * Assist Chip
 * Kullanıcıya yardımcı olmak için öneriler sunar
 *
 * @param label Chip etiketi
 * @param onClick Chip'e tıklandığında çalışacak fonksiyon
 * @param icon Chip ikonu (opsiyonel)
 */
@Composable
fun AssistChipExample(
    label: String = "Yardım",
    onClick: () -> Unit = {},
    icon: ImageVector? = Icons.Filled.Info
) {
    AssistChip(
        onClick = onClick,
        label = { Text(label) },
        leadingIcon = if (icon != null) {
            {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        } else null,
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            labelColor = MaterialTheme.colorScheme.onPrimaryContainer,
            leadingIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

/**
 * Filter Chip
 * Filtreleme ve seçim için kullanılır
 *
 * @param label Chip etiketi
 * @param selected Chip'in seçili olup olmadığı
 * @param onSelectedChange Seçim durumu değiştiğinde çalışacak fonksiyon
 * @param icon Seçili durumda gösterilecek ikon
 */
@Composable
fun FilterChipExample(
    label: String = "Filtre",
    selected: Boolean = false,
    onSelectedChange: (Boolean) -> Unit = {},
    icon: ImageVector = Icons.Filled.Check
) {
    FilterChip(
        selected = selected,
        onClick = { onSelectedChange(!selected) },
        label = { Text(label) },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else null,
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer,
            selectedLeadingIconColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    )
}

/**
 * Input Chip
 * Kullanıcı girdisi olarak eklenen, silinebilir chip'ler
 *
 * @param label Chip etiketi
 * @param onDismiss Chip silindiğinde çalışacak fonksiyon
 * @param avatar Avatar ikonu (opsiyonel)
 */
@Composable
fun InputChipExample(
    label: String = "Etiket",
    onDismiss: () -> Unit = {},
    avatar: ImageVector? = Icons.Filled.Person
) {
    var enabled by remember { mutableStateOf(true) }

    if (enabled) {
        InputChip(
            selected = false,
            onClick = { },
            label = { Text(label) },
            avatar = if (avatar != null) {
                {
                    Icon(
                        imageVector = avatar,
                        contentDescription = null,
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else null,
            trailingIcon = {
                IconButton(
                    onClick = {
                        enabled = false
                        onDismiss()
                    },
                    modifier = Modifier.size(18.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Kaldır",
                        modifier = Modifier.size(18.dp)
                    )
                }
            },
            colors = InputChipDefaults.inputChipColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                labelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                trailingIconColor = MaterialTheme.colorScheme.onTertiaryContainer
            )
        )
    }
}

/**
 * Suggestion Chip
 * Kullanıcıya önerilerde bulunmak için
 *
 * @param label Chip etiketi
 * @param onClick Chip'e tıklandığında çalışacak fonksiyon
 */
@Composable
fun SuggestionChipExample(
    label: String = "Öneri",
    onClick: () -> Unit = {}
) {
    SuggestionChip(
        onClick = onClick,
        label = { Text(label) },
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            labelColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}

/**
 * Chip Group
 * Birden fazla chip'i bir arada gösteren composable
 *
 * @param chips Gösterilecek chip listesi
 * @param selectedIndex Seçili chip index'i (filter chip'ler için)
 * @param onChipSelected Chip seçildiğinde çalışacak fonksiyon
 */
@Composable
fun ChipGroup(
    chips: List<String> = listOf("Tümü", "Aktif", "Beklemede", "Tamamlandı"),
    selectedIndex: Int = 0,
    onChipSelected: (Int) -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        chips.forEachIndexed { index, chip ->
            FilterChipExample(
                label = chip,
                selected = index == selectedIndex,
                onSelectedChange = { onChipSelected(index) }
            )
        }
    }
}

