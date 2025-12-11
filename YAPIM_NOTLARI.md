# Compose Material Design - Kod Yapısı

## 📁 Proje Yapısı

Proje, daha okunabilir ve bakımı kolay bir yapıya kavuşturuldu. Tüm kodlar fonksiyonel bileşenlere ayrıldı.

### Dosya Organizasyonu

```
app/src/main/java/com/example/composematerialdesign/
├── MainActivity.kt                      # Ana Activity (sadece giriş noktası)
├── screens/
│   └── MainScreen.kt                    # Ana ekran composable'ları
├── components/
│   ├── topbar/
│   │   └── TopBar.kt                    # TopAppBar bileşenleri
│   └── cards/
│       └── CardComponents.kt            # Card bileşenleri
└── ui/
    └── theme/                           # Tema dosyaları
```

## 📦 Bileşenler

### 1. MainActivity.kt
**Sorumluluk:** Uygulamanın giriş noktası
- Tek görevi: Activity oluşturma ve temel yapıyı kurma
- Edge-to-edge ekran desteği
- Material Design teması uygulama

### 2. screens/MainScreen.kt
**Sorumluluk:** Ana ekran görünümü
- Farklı card türlerini organize eder
- Her card türü için ayrı section fonksiyonları:
  - `NormalCardSection()` - Standart card
  - `OutlinedCardSection()` - Kenar çizgili card
  - `ElevatedCardSection()` - Gölgeli card
  - `ImageCardSection()` - Görsel içeren card

### 3. components/topbar/TopBar.kt
**Sorumluluk:** Üst bar (TopAppBar) bileşenleri
- **TopBar()** - Ana top bar composable
- **TopBarTitle()** - Başlık veya arama alanı
- **TopBarNavigationIcon()** - Geri butonu
- **TopBarActions()** - Aksiyon butonları (arama, menü)
- **SimpleDropdownMenu()** - Dropdown menü

**Özellikler:**
- Arama modu desteği
- Dropdown menü (Profil, Ayarlar, Çıkış)
- Material Design 3 renk şeması

### 4. components/cards/CardComponents.kt
**Sorumluluk:** Tüm card bileşenleri

#### AdvancedCard
Gelişmiş özelliklere sahip card:
- Avatar placeholder
- Başlık ve alt başlık
- Dropdown menü (Düzenle, Sil)
- Tıklanabilir özellik
- Animasyonlu içerik boyutu

**Alt Bileşenler:**
- `CardAvatar()` - Avatar gösterimi
- `CardContent()` - İçerik alanı
- `CardMenu()` - Menü butonu

#### OutlinedCardExample
Kenar çizgili basit card örneği

#### ElevatedCardExample
Yüksek gölge efektli card örneği

#### ImageCard
Görsel içeren card bileşeni:
- `ImagePlaceholder()` - Resim placeholder

## ✨ Yapılan İyileştirmeler

### 1. **Modülerlik**
- Her bileşen kendi dosyasında
- Tek sorumluluk prensibi uygulandı
- Yeniden kullanılabilir fonksiyonlar

### 2. **Okunabilirlik**
- Açıklayıcı fonksiyon isimleri
- KDoc yorumları eklendi
- Kodlar mantıksal gruplara ayrıldı

### 3. **Bakım Kolaylığı**
- Değişiklik yapmak daha kolay
- Test edilebilir yapı
- Bağımlılıklar azaltıldı

### 4. **Best Practices**
- Composable fonksiyonlar küçük ve odaklanmış
- Private fonksiyonlar ile kapsülleme
- Material Design 3 standartları

## 🎨 Kullanılan Material Design Bileşenleri

- **TopAppBar** - Üst navigasyon barı
- **Card** - İçerik kartları
- **OutlinedCard** - Kenar çizgili kartlar
- **ElevatedCard** - Gölgeli kartlar
- **IconButton** - İkon butonları
- **DropdownMenu** - Açılır menüler
- **OutlinedTextField** - Arama alanı

## 🚀 Kullanım

Her bileşen bağımsız olarak kullanılabilir:

```kotlin
// TopBar kullanımı
TopBar()

// Card kullanımı
AdvancedCard(
    title = "Başlık",
    subtitle = "Açıklama",
    onClick = { /* tıklama işlemi */ }
)

// Ana ekran
MainScreen(modifier = Modifier.padding(16.dp))
```

## 📝 Notlar

- Tüm fonksiyonlar Kotlin Composable olarak yazılmıştır
- Material Design 3 kullanılmaktadır
- Edge-to-edge ekran desteği mevcuttur
- Animasyon efektleri eklenmiştir

