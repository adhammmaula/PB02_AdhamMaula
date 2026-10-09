package com.example.pb02_adhammaulatirtasaputra_0102524001

// 1. Model Data dengan minimal 4 properti dan 1 nullable
data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val category: String, // Contoh: "Wajib" atau "Pilihan"
    val lecturer: String? // Nullable (pengganti prerequisite): nama dosen atau null jika belum ditentukan
)

fun main() {
    // 2. Minimal 8 item data
    val courses = listOf(
        Course("IF24A", "Pemrograman Bergerak", 3, "Wajib", "Pak Dody"),
        Course("IF24A", "Keamanan Komputer", 3, "Pilihan", "Bu Andi"),
        Course("IF24A", "Dasar Kecerdasan AI & ML", 3, "Pilihan", null),
        Course("IF24A", "Pengujian Perangkat Lunak", 2, "Pilihan", null),
        Course("IF24A", "Teknopreneurship", 2, "Wajib", null),
        Course("IF24A", "Manajemen Projek Perangkat Lunak", 3, "Wajib", null),
        Course("IF24A", "Jaringan Syaraf Tiruan", 3, "Pilihan", "Pak Ade"),
        Course("IF24A", "Kapita Selekta", 3, "Wajib", "Pak Denny")
    )

    // Validasi Input Sederhana
    val maxCreditsFilter = 3
    if (maxCreditsFilter <= 0) {
        println("Error: Filter jumlah SKS harus lebih besar dari 0.")
        return
    }

    println("=== KATALOG COURSE INFORMATIKA ANGKATAN 2024 ===")
    println("Menampilkan mata kuliah Wajib (Maks $maxCreditsFilter SKS), diurutkan berdasarkan nama:\n")

    // 3. Pipeline Collection (Filter, Sort, Transform/Map)
    val result = courses
        .filter { it.category == "Wajib" }                 // Filter 1: Hanya mata kuliah pilihan
        .filter { it.credits <= maxCreditsFilter }           // Filter 2: SKS maksimal sesuai validasi
        .sortedBy { it.title }                               // Sort: Urutkan alfabetis berdasarkan judul
        .map { course ->                                     // Transform/Map: Mengubah format output
            // Menggunakan Elvis operator (?:) untuk menangani null safety
            val dosen = course.lecturer ?: "Belum ditentukan"
            "- ${course.title} (${course.credits} SKS) | Kode: ${course.code} | Dosen: $dosen"
        }

    // 4. Output terformat
    if (result.isEmpty()) {
        println("Tidak ada mata kuliah yang sesuai kriteria pencarian.")
    } else {
        result.forEach { println(it) }
    }
}