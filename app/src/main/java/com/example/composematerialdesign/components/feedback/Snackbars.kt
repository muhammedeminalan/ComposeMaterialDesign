package com.example.composematerialdesign.components.feedback

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Snackbar bileşenleri
 *
 * Kısa süreli bildirimler ve geri bildirimler için kullanılır.
 * Ekranın alt kısmında belirir ve otomatik kaybolur.
 *
 * Kullanım Alanları:
 * - İşlem sonuç bildirimi (başarılı/başarısız)
 * - Geri al (Undo) özelliği
 * - Kısa bilgilendirmeler
 * - Hata mesajları
 *
 * Material Design 3 Özellikleri:
 * - Action butonu desteği
 * - İkon desteği
 * - Farklı renkler (başarı, hata, bilgi)
 * - Dismiss butonu
 */

/**
 * Basit Snackbar
 * Tek satırlı mesaj gösterir
 *
 * @param snackbarHostState Snackbar state yönetimi
 * @param message Gösterilecek mesaj
 * @param actionLabel Aksiyon butonu etiketi (opsiyonel)
 * @param onActionClick Aksiyon butonuna tıklandığında çalışacak fonksiyon
 */
@Composable
fun SimpleSnackbar(
    snackbarHostState: SnackbarHostState,
    message: String = "İşlem başarıyla tamamlandı",
    actionLabel: String? = null,
    onActionClick: () -> Unit = {}
) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
            Snackbar(
                snackbarData = data,
                containerColor = MaterialTheme.colorScheme.inverseSurface,
                contentColor = MaterialTheme.colorScheme.inverseOnSurface,
                actionColor = MaterialTheme.colorScheme.inversePrimary
            )
        }
    )
}

/**
 * Başarı Snackbar'ı
 * Başarılı işlemler için yeşil/pozitif tema
 *
 * @param snackbarHostState Snackbar state yönetimi
 */
@Composable
fun SuccessSnackbar(
    snackbarHostState: SnackbarHostState
) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
            Snackbar(
                snackbarData = data,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionColor = MaterialTheme.colorScheme.primary
            )
        }
    )
}

/**
 * Hata Snackbar'ı
 * Hata durumları için kırmızı tema
 *
 * @param snackbarHostState Snackbar state yönetimi
 */
@Composable
fun ErrorSnackbar(
    snackbarHostState: SnackbarHostState
) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
            Snackbar(
                snackbarData = data,
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer,
                actionColor = MaterialTheme.colorScheme.error,
                actionContentColor = MaterialTheme.colorScheme.error,
                dismissActionContentColor = MaterialTheme.colorScheme.onErrorContainer
            )
        }
    )
}

/**
 * Aksiyon butonu ile Snackbar
 * Geri al gibi aksiyonlar için
 *
 * @param snackbarHostState Snackbar state yönetimi
 * @param icon Snackbar ikonu (opsiyonel)
 */
@Composable
fun ActionSnackbar(
    snackbarHostState: SnackbarHostState,
    icon: ImageVector? = Icons.Filled.Check
) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
            Snackbar(
                snackbarData = data,
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                actionColor = MaterialTheme.colorScheme.secondary,
                actionContentColor = MaterialTheme.colorScheme.secondary,
                dismissActionContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    )
}

