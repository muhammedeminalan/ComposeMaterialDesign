# 🏗️ Proje Mimarisi - Profesyonel Yapı

## 📐 Mimari Prensipler

Bu proje **Clean Architecture** ve **Single Responsibility Principle** (SRP) prensiplerine uygun olarak yapılandırılmıştır.

### Temel Prensipler:
1. ✅ **Her bileşen kendi dosyasında** - Modülerlik maksimum seviyede
2. ✅ **Tek sorumluluk prensibi** - Her dosya tek bir işten sorumlu
3. ✅ **Yeniden kullanılabilirlik** - Tüm bileşenler bağımsız çalışır
4. ✅ **Detaylı dokümantasyon** - Her dosya ve fonksiyon açıklanmış
5. ✅ **Material Design 3** - Modern tasarım standartları

---

## 📁 Dosya Yapısı

```
app/src/main/java/com/example/composematerialdesign/
│
├── 📱 MainActivity.kt                      (30 satır)
│   └── Uygulamanın giriş noktası
│
├── 📺 screens/
│   └── MainScreen.kt                       (91 satır)
│       └── Ana ekran layout'u ve scroll yönetimi
│
├── 🧩 components/
│   │
│   ├── 🔝 topbar/                          (5 dosya)
│   │   ├── TopBar.kt                       (75 satır)
│   │   │   └── Ana TopAppBar composable
│   │   │
│   │   ├── TopBarTitle.kt                  (50 satır)
│   │   │   └── Başlık ve arama alanı geçişi
│   │   │
│   │   ├── TopBarNavigationIcon.kt         (45 satır)
│   │   │   └── Geri butonu yönetimi
│   │   │
│   │   ├── TopBarActions.kt                (60 satır)
│   │   │   └── Arama ve menü butonları
│   │   │
│   │   └── TopBarDropdownMenu.kt           (85 satır)
│   │       └── Dropdown menü ve öğeleri
│   │
│   └── 🎴 cards/                           (4 dosya)
│       ├── AdvancedCard.kt                 (220 satır)
│       │   ├── AdvancedCard()              - Ana card composable
│       │   ├── CardAvatar()                - Avatar gösterimi
│       │   ├── CardContent()               - İçerik bölümü
│       │   └── CardMenu()                  - Menü yönetimi
│       │
│       ├── OutlinedCardExample.kt          (80 satır)
│       │   └── OutlinedCardExample()       - Kenar çizgili card
│       │
│       ├── ElevatedCardExample.kt          (140 satır)
│       │   ├── ElevatedCardExample()       - Gölgeli card
│       │   └── ActionButtons()             - İki aksiyon butonu
│       │
│       └── ImageCard.kt                    (200 satır)
│           ├── ImageCard()                 - Görsel içerikli card
│           ├── CardContentSection()        - İçerik bölümü
│           ├── CardActionButtons()         - Aksiyon butonları
│           └── ImagePlaceholder()          - Görsel placeholder
│
└── 🎨 ui/
    └── theme/
        └── Theme dosyaları
```

---

## 🎯 Bileşen Detayları

### 1. TopBar Bileşenleri

#### **TopBar.kt** - Ana Koordinatör
```kotlin
@Composable
fun TopBar(
    title: String = "Material Design Showcase",
    onMenuItemClick: (String) -> Unit = {}
)
```
**Sorumluluklar:**
- State yönetimi (searchMode, searchText, showMenu)
- Alt bileşenleri koordine etme
- TopAppBar yapılandırması
- Tema renkleri uygulama

**Kullanılan State'ler:**
- `searchMode: Boolean` - Arama modunu kontrol eder
- `searchText: String` - Arama metnini saklar
- `showMenu: Boolean` - Menü görünürlüğünü kontrol eder

---

#### **TopBarTitle.kt** - Başlık/Arama Geçişi
```kotlin
@Composable
fun TopBarTitle(
    searchMode: Boolean,
    searchText: String,
    title: String,
    onSearchTextChange: (String) -> Unit
)
```
**Sorumluluklar:**
- Normal mod: Başlık gösterme
- Arama modu: TextField gösterme
- Tema uyumlu renklendirme

**Özellikler:**
- Dinamik geçiş (başlık ↔ arama)
- Tema renklerine uyumlu TextField
- Single-line input

---

#### **TopBarNavigationIcon.kt** - Navigasyon Yönetimi
```kotlin
@Composable
fun TopBarNavigationIcon(
    searchMode: Boolean,
    onBackClick: () -> Unit
)
```
**Sorumluluklar:**
- Geri butonu görüntüleme
- Arama modunda etkileşimli olma
- RTL dil desteği (AutoMirrored icon)

**Davranış:**
- Normal mod: Pasif geri butonu
- Arama modu: Aktif geri butonu (arama modundan çıkar)

---

#### **TopBarActions.kt** - Aksiyon Butonları
```kotlin
@Composable
fun TopBarActions(
    searchMode: Boolean,
    showMenu: Boolean,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
    onMenuDismiss: () -> Unit,
    onMenuItemClick: (String) -> Unit
)
```
**Sorumluluklar:**
- Arama butonunu gösterme (sadece normal modda)
- Menü butonunu gösterme (her zaman)
- Dropdown menüyü koordine etme

**Dinamik Davranış:**
- Normal mod: Arama + Menü
- Arama modu: Sadece menü

---

#### **TopBarDropdownMenu.kt** - Menü İçeriği
```kotlin
@Composable
fun TopBarDropdownMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    onMenuItemClick: (String) -> Unit = {}
)
```
**Sorumluluklar:**
- 4 menü öğesi gösterme
- Her öğe için başlık + açıklama
- Tıklama olaylarını yönetme
- Otomatik kapanma

**Menü Öğeleri:**
1. **Profilim** - Kullanıcı profili ve ayarları
2. **Ayarlar** - Uygulama tercihlerini düzenle
3. **Hakkında** - Uygulama bilgileri ve sürüm
4. **Çıkış Yap** - Hesaptan çıkış yap

---

### 2. Card Bileşenleri

#### **AdvancedCard.kt** - Profil Kartı
```kotlin
@Composable
fun AdvancedCard(
    modifier: Modifier = Modifier,
    title: String = "Başlık",
    subtitle: String = "Alt açıklama",
    avatarText: String = "AY",
    onClick: (() -> Unit)? = null,
    onEditClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {}
)
```

**Alt Bileşenler:**
```kotlin
@Composable private fun CardAvatar(text: String)
@Composable private fun CardContent(title: String, subtitle: String, modifier: Modifier)
@Composable private fun CardMenu(onEditClick, onShareClick, onDeleteClick)
```

**Kullanım Alanları:**
- Kullanıcı profil kartları
- Sosyal medya gönderileri
- Liste öğeleri
- Takım üyesi kartları

**Özellikler:**
- ✅ Dairesel avatar (baş harflerle)
- ✅ İki satır metin (başlık + alt başlık)
- ✅ Üç nokta menüsü (Düzenle, Paylaş, Sil)
- ✅ Tıklanabilir (onClick callback)
- ✅ Smooth animasyonlar
- ✅ Material Design 3 renkleri

---

#### **OutlinedCardExample.kt** - Minimal Kart
```kotlin
@Composable
fun OutlinedCardExample(
    modifier: Modifier = Modifier,
    title: String = "Minimal Tasarım",
    description: String = "...",
    borderWidth: Dp = 2.dp
)
```

**Kullanım Alanları:**
- Bilgi kutuları
- Form alanları
- Seçilebilir kartlar
- Veri grupları

**Özellikler:**
- ✅ 2dp outline border
- ✅ Gölge efekti yok (flat design)
- ✅ Tema outline rengi
- ✅ Geniş içerik alanı

---

#### **ElevatedCardExample.kt** - Vurgulu Kart
```kotlin
@Composable
fun ElevatedCardExample(
    modifier: Modifier = Modifier,
    title: String = "Yükseltilmiş Tasarım",
    description: String = "...",
    primaryActionText: String = "Aksiyon 1",
    secondaryActionText: String = "Aksiyon 2",
    onPrimaryAction: () -> Unit = {},
    onSecondaryAction: () -> Unit = {},
    elevation: Dp = 8.dp
)
```

**Alt Bileşenler:**
```kotlin
@Composable private fun ActionButtons(primaryText, secondaryText, onPrimaryClick, onSecondaryClick)
```

**Kullanım Alanları:**
- Önemli duyurular
- Call-to-action kartları
- İnteraktif paneller
- Dashboard widget'ları

**Özellikler:**
- ✅ 8dp yüksek elevation (gölge)
- ✅ Horizontal divider
- ✅ İki aksiyon butonu (Filled + Outlined)
- ✅ Zengin içerik alanı

---

#### **ImageCard.kt** - Medya Kartı
```kotlin
@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    imageContent: @Composable () -> Unit = { ImagePlaceholder() },
    title: String = "Görsel İçerikli Card",
    description: String = "...",
    detailButtonText: String = "DETAY",
    shareButtonText: String = "PAYLAŞ",
    onDetailClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
)
```

**Alt Bileşenler:**
```kotlin
@Composable private fun CardContentSection(...)
@Composable private fun CardActionButtons(...)
@Composable fun ImagePlaceholder(height: Dp, emoji: String)
```

**Kullanım Alanları:**
- Haber kartları
- Ürün kartları (e-ticaret)
- Blog önizlemeleri
- Galeri öğeleri
- Video önizlemeleri

**Özellikler:**
- ✅ 180dp görsel alan
- ✅ Özelleştirilebilir görsel içerik
- ✅ İki text button (DETAY, PAYLAŞ)
- ✅ Emoji placeholder (gerçek resim kullanılabilir)

**Gerçek Resim Kullanımı:**
```kotlin
ImageCard(
    imageContent = {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Ürün",
            contentScale = ContentScale.Crop
        )
    }
)
```

---

## 📊 Kod Metrikleri

### Dosya Dağılımı:
| Kategori | Dosya Sayısı | Toplam Satır |
|----------|--------------|--------------|
| Activity | 1 | ~30 |
| Screens | 1 | ~90 |
| TopBar | 5 | ~315 |
| Cards | 4 | ~640 |
| **TOPLAM** | **11** | **~1075** |

### Modülerlik Oranı:
- ✅ **%100** - Her bileşen ayrı dosyada
- ✅ **%100** - Dokümantasyon coverage
- ✅ **%100** - Material Design 3 uyumluluğu

---

## 🎨 Material Design 3 Kullanımı

### Renk Sistemi:
```kotlin
MaterialTheme.colorScheme.primary              // Ana renk
MaterialTheme.colorScheme.primaryContainer     // Container rengi
MaterialTheme.colorScheme.surfaceVariant       // Surface varyant
MaterialTheme.colorScheme.outline              // Outline rengi
MaterialTheme.colorScheme.onSurface            // Yüzey üstü metin
MaterialTheme.colorScheme.onSurfaceVariant     // Varyant metin
MaterialTheme.colorScheme.error                // Hata rengi
MaterialTheme.colorScheme.outlineVariant       // Outline varyant
```

### Tipografi:
```kotlin
MaterialTheme.typography.displayLarge          // Büyük görsel içerik
MaterialTheme.typography.titleLarge            // Büyük başlıklar
MaterialTheme.typography.titleMedium           // Orta başlıklar
MaterialTheme.typography.bodyLarge             // Büyük body metni
MaterialTheme.typography.bodyMedium            // Orta body metni
MaterialTheme.typography.bodySmall             // Küçük body metni
```

---

## 🚀 Kullanım Örnekleri

### TopBar Kullanımı:
```kotlin
TopBar(
    title = "My Application",
    onMenuItemClick = { menuItem ->
        when(menuItem) {
            "Profilim" -> navController.navigate("profile")
            "Ayarlar" -> navController.navigate("settings")
            "Hakkında" -> showAboutDialog()
            "Çıkış Yap" -> performLogout()
        }
    }
)
```

### AdvancedCard Kullanımı:
```kotlin
AdvancedCard(
    title = "Ahmet Yılmaz",
    subtitle = "Senior Android Developer",
    avatarText = "AY",
    onClick = { openProfile(userId) },
    onEditClick = { editProfile(userId) },
    onShareClick = { shareProfile(userId) },
    onDeleteClick = { deleteProfile(userId) }
)
```

### ElevatedCard Kullanımı:
```kotlin
ElevatedCardExample(
    title = "Yeni Özellik!",
    description = "Uygulamaya yeni özellikler eklendi. Keşfetmek ister misiniz?",
    primaryActionText = "Keşfet",
    secondaryActionText = "Daha Sonra",
    onPrimaryAction = { exploreNewFeatures() },
    onSecondaryAction = { dismissNotification() }
)
```

### ImageCard Kullanımı:
```kotlin
ImageCard(
    imageContent = {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop
        )
    },
    title = product.name,
    description = product.description,
    onDetailClick = { navController.navigate("product/${product.id}") },
    onShareClick = { shareProduct(product) }
)
```

---

## ✅ Best Practices

### 1. **Bağımlılık Yönetimi**
- Her dosya sadece ihtiyacı olan import'ları içerir
- Wildcard import'lar kullanılmaz
- Açık ve spesifik import'lar tercih edilir

### 2. **Dokümantasyon**
- Her fonksiyon KDoc ile dokümante edilmiş
- Parametreler açıklanmış
- Kullanım örnekleri verilmiş
- Sorumluluklar belirtilmiş

### 3. **State Yönetimi**
- State'ler ilgili oldukları dosyada tutulur
- remember ile local state yönetimi
- Callback'ler üst bileşene state değişikliği bildirir

### 4. **Composable Hiyerarşisi**
- Public composable'lar: Dışarıdan kullanılabilir
- Private composable'lar: Sadece dosya içinde kullanılır
- Alt bileşenler mantıksal olarak gruplandırılmış

### 5. **Material Design Uyumu**
- Tema renkleri kullanılır (hardcoded renkler yok)
- Dinamik renk sistemi desteklenir
- Accessibility standartları uygulanır

---

## 🎓 Öğrenme Kaynakları

### Material Design 3:
- [Material Design 3 Guidelines](https://m3.material.io/)
- [Compose Material 3](https://developer.android.com/jetpack/compose/designsystems/material3)

### Jetpack Compose:
- [Compose Documentation](https://developer.android.com/jetpack/compose)
- [Compose Samples](https://github.com/android/compose-samples)

### Clean Architecture:
- [Android Clean Architecture](https://developer.android.com/topic/architecture)

---

## 📝 Notlar

1. **Yeniden Kullanılabilirlik**: Tüm bileşenler parametrelendirilmiş, farklı projelerde kullanılabilir
2. **Genişletilebilirlik**: Yeni card türleri veya topbar özellikleri kolayca eklenebilir
3. **Test Edilebilirlik**: Her bileşen bağımsız test edilebilir
4. **Bakım Kolaylığı**: Değişiklik yapmak çok kolay, etki alanı sınırlı
5. **Performance**: LazyColumn kullanımı ile optimize edilmiş scroll

---

**Mimari Tasarım Tarihi:** 11 Aralık 2025  
**Versiyon:** 2.0  
**Durum:** ✅ Production Ready

