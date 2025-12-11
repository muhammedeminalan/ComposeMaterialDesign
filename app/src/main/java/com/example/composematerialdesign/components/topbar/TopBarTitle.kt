package com.example.composematerialdesign.components.topbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * TopBar başlık bölümü
 *
 * İki mod arasında geçiş yapar:
 * 1. Normal Mod: Sabit başlık metni gösterir
 * 2. Arama Modu: Arama alanı (OutlinedTextField) gösterir
 *
 * Normal mod tipik kullanım içindir. Arama moduna geçildiğinde
 * kullanıcı arama yapabilir ve TextField dinamik olarak güncellenir.
 *
 * @param searchMode Arama modunun aktif olup olmadığı
 * @param searchText Arama alanındaki mevcut metin
 * @param title Normal modda gösterilecek başlık
 * @param onSearchTextChange Arama metni değiştiğinde çağrılan callback
 *
 * Tasarım Notları:
 * - Arama alanı beyaz metin kullanır (tema uyumlu)
 * - Placeholder metni %70 opacity ile gösterilir
 * - Tek satırlı arama alanı (singleLine = true)
 * - TextField genişliği fillMaxWidth() ile maksimum
 */
@Composable
fun TopBarTitle(
    searchMode: Boolean,
    searchText: String,
    title: String,
    onSearchTextChange: (String) -> Unit
) {
    if (!searchMode) {
        // Normal Mod: Başlık göster
        Text(text = title)
    } else {
        // Arama Modu: TextField göster
        OutlinedTextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            placeholder = { Text("İçerik ara...") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f),
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f),
                focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f)
            )
        )
    }
}

