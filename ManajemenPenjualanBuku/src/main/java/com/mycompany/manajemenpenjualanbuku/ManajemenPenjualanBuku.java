/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenpenjualanbuku;

/**
 *
 * @author WINDOWS 11
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManajemenPenjualanBuku {
    private double modalAwal;
    private double modalBerjalan;
    private List<Buku> daftarBuku;

    public ManajemenPenjualanBuku(double modalAwal) {
        this.modalAwal = modalAwal;
        this.modalBerjalan = modalAwal;
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void laporanModal() {
        System.out.println("Modal Awal: " + modalAwal);
        System.out.println("Modal Berjalan: " + modalBerjalan);
    }

    public void laporanStok() {
        for (Buku buku : daftarBuku) {
            if (buku instanceof Majalah majalah) {
                System.out.println("Majalah: " + majalah.getJudul() + " | Edisi: " + majalah.getNomorEdisi() + " | Stok: " + majalah.getJumlahStok());
            } else {
                System.out.println("Buku: " + buku.getJudul() + " | Stok: " + buku.getJumlahStok());
            }
        }
    }

    public void jualBuku(String judul, int jumlah) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equals(judul)) {
                if (buku.getJumlahStok() >= jumlah) {
                    buku.kurangiStok(jumlah);
                    modalBerjalan += buku.getHargaJual() * jumlah;
                    System.out.println(jumlah + " eksemplar '" + judul + "' terjual.");
                } else {
                    System.out.println("Stok tidak mencukupi.");
                }
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    public void beliStok(String judul, int jumlah) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equals(judul)) {
                double totalHarga = buku.getHargaBeli() * jumlah;
                if (modalBerjalan >= totalHarga) {
                    buku.tambahStok(jumlah);
                    modalBerjalan -= totalHarga;
                    System.out.println(jumlah + " eksemplar '" + judul + "' berhasil dibeli.");
                } else {
                    System.out.println("Modal berjalan tidak mencukupi.");
                }
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ManajemenPenjualanBuku manajemen = new ManajemenPenjualanBuku(1000000); // Modal awal 1 juta
            
            // Tambahkan buku contoh
            manajemen.tambahBuku(new BukuFiksi("Harry Potter", 50000, 75000, 10));
            manajemen.tambahBuku(new BukuNonFiksi("Sejarah Dunia", 60000, 90000, 5));
            manajemen.tambahBuku(new Majalah("National Geographic", 30000, 50000, 7, 2023));
            
            // Tampilan awal program
            System.out.println("**********************************************");
            System.out.println("*             Sistem Penjualan Buku          *");
            System.out.println("*       By: Adhi Rasa P.j, Nim: 23201122     *");
            System.out.println("**********************************************");
            System.out.println("Silakan pilih menu:");
            System.out.println();
            System.out.println("1) Beli Buku          2) Jual Buku");
            System.out.println("3) Lihat Stok Buku    4) Lihat Laporan Keuangan");
            System.out.println("5) Exit");
            
            boolean running = true;
            while (running) {
                System.out.print("Pilihan Menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Masukkan judul buku yang dibeli: ");
                        String judulBeli = scanner.nextLine();
                        System.out.print("Masukkan jumlah: ");
                        int jumlahBeli = scanner.nextInt();
                        manajemen.beliStok(judulBeli, jumlahBeli);
                    }
                    case 2 -> {
                        System.out.print("Masukkan judul buku yang dijual: ");
                        String judulJual = scanner.nextLine();
                        System.out.print("Masukkan jumlah: ");
                        int jumlahJual = scanner.nextInt();
                        manajemen.jualBuku(judulJual, jumlahJual);
                    }
                    case 3 -> manajemen.laporanStok();
                    case 4 -> manajemen.laporanModal();
                    case 5 -> {
                        running = false;
                        System.out.println("Program selesai");
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }
        } // Modal awal 1 juta
    }
}
