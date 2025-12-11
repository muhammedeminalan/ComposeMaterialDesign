package com.example.composematerialdesign.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composematerialdesign.components.buttons.*
import com.example.composematerialdesign.components.chips.*
import com.example.composematerialdesign.components.dialogs.*
import com.example.composematerialdesign.components.feedback.*
import com.example.composematerialdesign.components.lists.*
import com.example.composematerialdesign.components.progress.*

/**
 * Bileşenler showcase ekranı
 * Tüm modern UI bileşenlerini gösterir
 */
@Composable
fun ComponentsShowcaseScreen(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }
    var showDialog by remember { mutableStateOf(false) }
    var showIconDialog by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SuccessSnackbar(snackbarHostState) },
        floatingActionButton = {
            ExtendedFABExample(
                text = "Yeni Oluştur",
                icon = Icons.Filled.Add,
                onClick = {}
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = modifier.padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // FAB Bölümü
            item {
                ComponentSection(
                    title = "Floating Action Buttons",
                    description = "Ana aksiyonları temsil eden öne çıkan butonlar"
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SmallFAB(
                            icon = Icons.Filled.Edit,
                            onClick = {}
                        )
                        StandardFAB(
                            icon = Icons.Filled.Add,
                            onClick = {}
                        )
                        LargeFAB(
                            icon = Icons.Filled.Create,
                            onClick = {}
                        )
                    }
                }
            }

            // Chips Bölümü
            item {
                ComponentSection(
                    title = "Chips",
                    description = "Filtreler, etiketler ve seçimler için compact öğeler"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        // Filter Chips
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            var selected1 by remember { mutableStateOf(true) }
                            var selected2 by remember { mutableStateOf(false) }

                            FilterChipExample(
                                label = "Tümü",
                                selected = selected1,
                                onSelectedChange = { selected1 = it }
                            )
                            FilterChipExample(
                                label = "Aktif",
                                selected = selected2,
                                onSelectedChange = { selected2 = it }
                            )
                        }

                        // Assist ve Input Chips
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            AssistChipExample(
                                label = "Yardım",
                                icon = Icons.Filled.Info
                            )
                            InputChipExample(
                                label = "Android",
                                avatar = Icons.Filled.Person
                            )
                            SuggestionChipExample(label = "Kotlin")
                        }
                    }
                }
            }

            // Dialogs Bölümü
            item {
                ComponentSection(
                    title = "Dialogs",
                    description = "Onay, bilgi ve seçim için modal pencereler"
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { showDialog = true }) {
                            Text("Basit Dialog")
                        }
                        Button(onClick = { showIconDialog = true }) {
                            Text("İkonlu Dialog")
                        }
                    }
                }
            }

            // Progress Indicators Bölümü
            item {
                ComponentSection(
                    title = "Progress Indicators",
                    description = "Yükleme ve ilerleme göstergeleri"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        DeterminateLinearProgress(
                            progress = 0.65f,
                            label = "Dosya indiriliyor"
                        )
                        DeterminateLinearProgress(
                            progress = 0.85f,
                            label = "Yükleme tamamlanıyor"
                        )
                        ColoredLinearProgress(
                            progress = 0.95f,
                            status = ProgressStatus.SUCCESS
                        )
                    }
                }
            }

            // List Items Bölümü
            item {
                ComponentSection(
                    title = "List Items",
                    description = "Mesajlar, bildirimler ve içerik listeleri"
                ) {
                    Column {
                        SimpleListItem(
                            title = "Ahmet Yılmaz",
                            subtitle = "Merhaba, nasılsın?",
                            avatarText = "AY"
                        )
                        HorizontalDivider()
                        NotificationListItem(
                            title = "Yeni Mesaj",
                            message = "Mehmet size bir mesaj gönderdi",
                            time = "2 dk önce",
                            isUnread = true,
                            icon = Icons.Filled.Email
                        )
                        HorizontalDivider()
                        var isFavorite by remember { mutableStateOf(false) }
                        ActionListItem(
                            title = "Favori Şarkı",
                            subtitle = "Artist - 3:45",
                            isFavorite = isFavorite,
                            onFavoriteClick = { isFavorite = !isFavorite }
                        )
                    }
                }
            }

            // Circular Progress
            item {
                ComponentSection(
                    title = "Circular Progress",
                    description = "Dairesel ilerleme göstergeleri"
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        DeterminateCircularProgress(
                            progress = 0.75f,
                            showPercentage = true
                        )
                    }
                }
            }
        }
    }

    // Dialogs
    SimpleAlertDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onConfirm = { showDialog = false },
        title = "İşlemi Onayla",
        message = "Bu işlemi gerçekleştirmek istediğinizden emin misiniz?"
    )

    IconAlertDialog(
        showDialog = showIconDialog,
        onDismiss = { showIconDialog = false },
        onConfirm = { showIconDialog = false },
        icon = Icons.Filled.Warning,
        title = "Uyarı",
        message = "Bu işlem geri alınamaz!"
    )
}

/**
 * Bileşen bölümü başlığı
 */
@Composable
private fun ComponentSection(
    title: String,
    description: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
            )
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                content()
            }
        }
    }
}


