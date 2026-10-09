# PB02_AdhamMaula

<img width="1918" height="1020" alt="image" src="https://github.com/user-attachments/assets/25b2f3de-855a-455c-9c08-6e4abfb4ec90" />

Tujuan Program:
Menampilkan daftar mata kuliah wajib yang sesuai dengan kriteria mahasiswa, yaitu memiliki maksimal 3 SKS, lalu diurutkan berdasarkan nama secara alfabet

Model Data & Logika Utama:
Program ini menggunakan data class Course dengan 5 properti, di mana properti lecturer bersifat nullable (String?). Logika utamanya menggunakan collection pipeline (filter, sortedBy, dan map) untuk menyaring data, serta menggunakan Elvis operator (?:) untuk menangani dosen yang nilainya null

Catatan bagian yang sulit:
Bagian tersulit dari tugas ini adalah memahami mengapa fungsi main() tidak bisa langsung dirun di dalam Android Studio karena struktur gradle untuk jetpack compose yang bikin bingung. Dan dalam merangkai urutan pipeline collection membutuhkan ketelitian agar tipe datanya tidak bentrok. Cara mengatasinya adalah dengan menguji coba logika code terlebih dahulu di Kotlin Playground agar output teksnya terlihat jelas tanpa terhalang error build Android, lalu menerapkan Elvis operator agar nilai yang kosong tidak menyebabkan program crash
