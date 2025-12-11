package com.example.composematerialdesign.components.progress

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Progress Indicator bileşenleri
 *
 * Yükleme durumlarını ve işlem ilerlemesini gösterir.
 * İki ana tür: Determinate (belirli) ve Indeterminate (belirsiz)
 *
 * Kullanım Alanları:
 * - Dosya yükleme/indirme
 * - API istekleri
 * - Sayfa yükleme
 * - Görev tamamlanma yüzdesi
 *
 * Material Design 3 Özellikleri:
 * - Linear ve Circular progress
 * - Renk özelleştirme
 * - Progress değeri gösterimi
 * - Tema uyumlu
 */

/**
 * Belirsiz dairesel progress
 * Süre bilinmeyen işlemler için
 */
@Composable
fun IndeterminateCircularProgress() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Yükleniyor...",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * Belirli dairesel progress
 * İlerleme yüzdesi bilinen işlemler için
 *
 * @param progress İlerleme değeri (0.0 - 1.0 arası)
 * @param showPercentage Yüzde gösterimi yapılsın mı
 */
@Composable
fun DeterminateCircularProgress(
    progress: Float = 0.65f,
    showPercentage: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { progress },
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                strokeWidth = 8.dp,
                modifier = Modifier.size(80.dp)
            )
            if (showPercentage) {
                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "İndiriliyor...",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * Belirsiz linear progress
 * Sayfa yükleme gibi durumlarda kullanılır
 */
@Composable
fun IndeterminateLinearProgress() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "İşlem devam ediyor...",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

/**
 * Belirli linear progress
 * Dosya yükleme, görev tamamlama için
 *
 * @param progress İlerleme değeri (0.0 - 1.0 arası)
 * @param label Progress etiketi
 * @param showPercentage Yüzde gösterimi yapılsın mı
 */
@Composable
fun DeterminateLinearProgress(
    progress: Float = 0.75f,
    label: String = "Yükleniyor",
    showPercentage: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (showPercentage) {
                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.tertiary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

/**
 * Renkli progress göstergesi
 * Farklı durumlar için farklı renkler
 *
 * @param progress İlerleme değeri
 * @param status Durum (success, warning, error)
 */
@Composable
fun ColoredLinearProgress(
    progress: Float = 0.85f,
    status: ProgressStatus = ProgressStatus.SUCCESS
) {
    val (color, label) = when (status) {
        ProgressStatus.SUCCESS -> MaterialTheme.colorScheme.primary to "Tamamlanıyor"
        ProgressStatus.WARNING -> MaterialTheme.colorScheme.tertiary to "Devam ediyor"
        ProgressStatus.ERROR -> MaterialTheme.colorScheme.error to "Hata oluştu"
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = color
            )
            Text(
                text = "${(progress * 100).toInt()}%",
                style = MaterialTheme.typography.bodyMedium,
                color = color
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = color,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

/**
 * Progress durumu enum'u
 */
enum class ProgressStatus {
    SUCCESS,
    WARNING,
    ERROR
}

