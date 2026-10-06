package com.tugaspraktikum.modul5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BukuHarian {
    private String namaPemilik;
    private String namaFile;

    // Constructor: inisialisasi namaPemilik dan menentukan namaFile
    public BukuHarian(String namaPemilik) {
        this.namaPemilik = namaPemilik;
        this.namaFile = "diary_" + namaPemilik.toLowerCase().replaceAll("\\s+", "_") + ".txt";
    }

    // Method untuk menulis catatan dengan mode append true
    public void tulisCatatan(String tanggal, String isi) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile, true))) {
            bw.write("[" + tanggal + "] - " + isi);
            bw.newLine();
            System.out.println("Catatan berhasil ditambahkan ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Gagal menulis catatan: " + e.getMessage());
        }
    }

    // Method untuk membaca dan menampilkan isi catatan
    public void bacaCatatan() {
        File file = new File(namaFile);

        // Validasi jika file belum dibuat atau ukurannya 0 byte
        if (!file.exists() || file.length() == 0) {
            System.out.println("Belum ada catatan harian.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String baris;
            System.out.println("\n=== Catatan Harian: " + namaPemilik + " ===");
            while ((baris = br.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Belum ada catatan harian.");
        }
    }
}