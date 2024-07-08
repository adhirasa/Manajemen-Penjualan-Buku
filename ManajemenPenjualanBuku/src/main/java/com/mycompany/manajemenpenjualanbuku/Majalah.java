/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenpenjualanbuku;

/**
 *
 * @author WINDOWS 11
 */
public class Majalah extends Buku {
    private int nomorEdisi;

    public Majalah(String judul, double hargaBeli, double hargaJual, int jumlahStok, int nomorEdisi) {
        super(judul, hargaBeli, hargaJual, jumlahStok);
        this.nomorEdisi = nomorEdisi;
    }

    @Override
    public void tambahStok(int jumlah) {
        this.jumlahStok += jumlah;
    }

    @Override
    public void kurangiStok(int jumlah) {
        this.jumlahStok -= jumlah;
        if (this.jumlahStok <= 0) {
            System.out.println("Stok majalah '" + this.judul + " edisi " + this.nomorEdisi + "' sudah mencapai nol.");
        }
    }

    public int getNomorEdisi() {
        return nomorEdisi;
    }
}
