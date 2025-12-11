package com.example.composematerialdesign.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composematerialdesign.components.cards.AdvancedCard
import com.example.composematerialdesign.components.cards.OutlinedCardExample
import com.example.composematerialdesign.components.cards.ElevatedCardExample
import com.example.composematerialdesign.components.cards.ImageCard

/**
 * Ana ekran - Farklı card türlerini gösterir
 * LazyColumn ile scroll desteği sağlanmıştır
 */
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            NormalCardSection()
        }

        item {
            OutlinedCardSection()
        }

        item {
            ElevatedCardSection()
        }

        item {
            ImageCardSection()
        }
    }
}

@Composable
private fun NormalCardSection() {
    SectionHeader(
        title = "📱 Gelişmiş Card Bileşeni",
        description = "Avatar, başlık, alt başlık ve menü içeren modern card"
    )
    AdvancedCard(
        title = "Emin Alan",
        subtitle = "Android Developer • Compose uzmanı",
        onClick = {}
    )
}

@Composable
private fun OutlinedCardSection() {
    SectionHeader(
        title = "🎯 Outlined Card",
        description = "Kenar çizgili minimal card tasarımı"
    )
    OutlinedCardExample()
}

@Composable
private fun ElevatedCardSection() {
    SectionHeader(
        title = "✨ Elevated Card",
        description = "Yüksek gölge efekti ile belirginleştirilmiş card"
    )
    ElevatedCardExample()
}

@Composable
private fun ImageCardSection() {
    SectionHeader(
        title = "🖼️ Image Card",
        description = "Görsel içerikli card bileşeni"
    )
    ImageCard()
}

@Composable
private fun SectionHeader(title: String, description: String) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

