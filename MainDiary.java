package com.tugaspraktikum.modul5;

public class MainDiary {
    public static void main(String[] args) {
        // 1. Instansiasi objek BukuHarian
        BukuHarian diary = new BukuHarian("Arifa");

        // 2. Tambahkan minimal dua catatan
        diary.tulisCatatan("12-09-2026", "Menyelesaikan modul 5 praktikum PBO.");
        diary.tulisCatatan("13-09-2026", "Mempelajari konsep persistensi data dan I/O stream.");

        // 3. Tampilkan isi catatan
        diary.bacaCatatan();
    }
}