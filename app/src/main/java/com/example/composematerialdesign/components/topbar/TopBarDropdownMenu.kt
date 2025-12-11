package com.example.composematerialdesign.components.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * TopBar dropdown menü bileşeni
 *
 * Üç nokta menü butonuna tıklandığında açılan dropdown menü.
 * Dört ana seçenek sunar: Profilim, Ayarlar, Hakkında, Çıkış Yap
 *
 * Menü Yapısı:
 * Her menü öğesi iki satırdan oluşur:
 * - Başlık: Menü öğesinin ana metni (büyük font)
 * - Açıklama: Menü öğesinin kısa açıklaması (küçük font, gri renk)
 *
 * Kullanıcı Deneyimi:
 * - Menü öğelerine tıklandığında otomatik kapanır
 * - Menü dışına tıklandığında kapanır
 * - Her öğe için callback fonksiyonu çalıştırılır
 *
 * @param expanded Menünün açık olup olmadığı
 * @param onDismiss Menü kapatıldığında çalışacak fonksiyon
 * @param onMenuItemClick Menü öğesine tıklandığında çalışacak fonksiyon (öğe başlığı parametresi alır)
 *
 * Menü Öğeleri:
 * 1. Profilim - Kullanıcı profil sayfasına yönlendirir
 * 2. Ayarlar - Uygulama ayarları sayfasına yönlendirir
 * 3. Hakkında - Uygulama hakkında bilgi gösterir
 * 4. Çıkış Yap - Kullanıcıyı logout eder
 *
 * Örnek Kullanım:
 * ```
 * TopBarDropdownMenu(
 *     expanded = showMenu,
 *     onDismiss = { showMenu = false },
 *     onMenuItemClick = { item ->
 *         when(item) {
 *             "Profilim" -> navController.navigate("profile")
 *             "Ayarlar" -> navController.navigate("settings")
 *             "Hakkında" -> showAboutDialog()
 *             "Çıkış Yap" -> logout()
 *         }
 *     }
 * )
 * ```
 */
@Composable
fun TopBarDropdownMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    onMenuItemClick: (String) -> Unit = {}
) {
    // Menü öğeleri: Başlık ve Açıklama çiftleri
    val menuItems = listOf(
        "Profilim" to "Kullanıcı profili ve ayarları",
        "Ayarlar" to "Uygulama tercihlerini düzenle",
        "Hakkında" to "Uygulama bilgileri ve sürüm",
        "Çıkış Yap" to "Hesaptan çıkış yap"
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss
    ) {
        menuItems.forEach { (title, description) ->
            DropdownMenuItem(
                text = {
                    Column {
                        // Menü öğesi başlığı
                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        // Menü öğesi açıklaması
                        Text(
                            text = description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                onClick = {
                    onDismiss()
                    onMenuItemClick(title)
                }
            )
        }
    }
}

