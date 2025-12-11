package com.example.composematerialdesign.components.dialogs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Dialog bileşenleri
 *
 * Kullanıcıdan onay almak, bilgi vermek veya seçim yaptırmak için
 * kullanılan modal pencereler.
 *
 * Kullanım Alanları:
 * - Onay isteme (Silme, Çıkış vb.)
 * - Bilgilendirme
 * - Form girişi
 * - Seçim yapma
 *
 * Material Design 3 Özellikleri:
 * - AlertDialog: Standart bilgilendirme/onay dialogu
 * - İkon desteği
 * - Pozitif/Negatif butonlar
 * - Tema uyumlu renkler
 */

/**
 * Basit Alert Dialog
 * En yaygın kullanılan dialog türü
 *
 * @param showDialog Dialog'un gösterilip gösterilmeyeceği
 * @param onDismiss Dialog kapatıldığında çalışacak fonksiyon
 * @param onConfirm Onayla butonuna tıklandığında çalışacak fonksiyon
 * @param title Dialog başlığı
 * @param message Dialog mesajı
 * @param confirmText Onayla butonu metni
 * @param dismissText İptal butonu metni
 */
@Composable
fun SimpleAlertDialog(
    showDialog: Boolean = false,
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
    title: String = "Dikkat",
    message: String = "Bu işlemi gerçekleştirmek istediğinizden emin misiniz?",
    confirmText: String = "Evet",
    dismissText: String = "Hayır"
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text(confirmText)
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(dismissText)
                }
            },
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            textContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * İkonlu Alert Dialog
 * Görsel vurgu için ikon içeren dialog
 *
 * @param showDialog Dialog'un gösterilip gösterilmeyeceği
 * @param onDismiss Dialog kapatıldığında çalışacak fonksiyon
 * @param onConfirm Onayla butonuna tıklandığında çalışacak fonksiyon
 * @param icon Dialog ikonu
 * @param title Dialog başlığı
 * @param message Dialog mesajı
 */
@Composable
fun IconAlertDialog(
    showDialog: Boolean = false,
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
    icon: ImageVector = Icons.Filled.Warning,
    title: String = "Uyarı",
    message: String = "Bu işlem geri alınamaz!"
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            icon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            },
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = {
                Button(
                    onClick = onConfirm,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    )
                ) {
                    Text("Sil")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("İptal")
                }
            }
        )
    }
}

/**
 * Bilgilendirme Dialog'u
 * Sadece bilgi vermek için (tek buton)
 *
 * @param showDialog Dialog'un gösterilip gösterilmeyeceği
 * @param onDismiss Dialog kapatıldığında çalışacak fonksiyon
 * @param title Dialog başlığı
 * @param message Dialog mesajı
 * @param buttonText Buton metni
 */
@Composable
fun InfoDialog(
    showDialog: Boolean = false,
    onDismiss: () -> Unit = {},
    title: String = "Bilgi",
    message: String = "İşlem başarıyla tamamlandı.",
    buttonText: String = "Tamam"
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text(buttonText)
                }
            },
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            textContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

