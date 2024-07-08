/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajemenpenjualanbuku;

/**
 *
 * @author WINDOWS 11
 */
public abstract class Buku {
    protected String judul;
    protected double hargaBeli;
    protected double hargaJual;
    protected int jumlahStok;

    public Buku(String judul, double hargaBeli, double hargaJual, int jumlahStok) {
        this.judul = judul;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.jumlahStok = jumlahStok;
    }

    public abstract void tambahStok(int jumlah);
    public abstract void kurangiStok(int jumlah);
    
    public String getJudul() {
        return judul;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    int getHargaBeli() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
