/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenpenjualanbuku;

/**
 *
 * @author WINDOWS 11
 */
public class BukuNonFiksi extends Buku {

    public BukuNonFiksi(String judul, double hargaBeli, double hargaJual, int jumlahStok) {
        super(judul, hargaBeli, hargaJual, jumlahStok);
    }

    @Override
    public void tambahStok(int jumlah) {
        this.jumlahStok += jumlah;
    }

    @Override
    public void kurangiStok(int jumlah) {
        this.jumlahStok -= jumlah;
        if (this.jumlahStok <= 0) {
            System.out.println("Stok buku non-fiksi '" + this.judul + "' sudah mencapai nol.");
        }
    }
}
