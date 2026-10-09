package com.example.pb02_adhammaulatirtasaputra_0102524001

// 1. model data dengan minimal 4 properti dan 1 nullable
data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val category: String,
    val lecturer: String?
)

fun main() {
    // 2. minimal 8 data
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

    // validasi input
    val maxCreditsFilter = 3
    if (maxCreditsFilter <= 0) {
        println("Error: Filter jumlah SKS harus lebih besar dari 0.")
        return
    }

    println("=== KATALOG COURSE INFORMATIKA ANGKATAN 2024 ===")
    println("Menampilkan mata kuliah Wajib (Maks $maxCreditsFilter SKS), diurutkan berdasarkan nama:\n")

    // 3. pipeline vollection (Filter, Sort, Transform/Map)
    val result = courses
        .filter { it.category == "Wajib" }
        .filter { it.credits <= maxCreditsFilter }
        .sortedBy { it.title }
        .map { course ->

            val dosen = course.lecturer ?: "Belum ditentukan"
            "- ${course.title} (${course.credits} SKS) | Kode: ${course.code} | Dosen: $dosen"
        }

    // 4. output
    if (result.isEmpty()) {
        println("Tidak ada mata kuliah yang sesuai kriteria pencarian.")
    } else {
        result.forEach { println(it) }
    }
}