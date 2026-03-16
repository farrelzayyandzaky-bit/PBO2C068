/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fzyynm
 */
public class Mahasiswa {

    private String nama;
    private int umur;

    public Mahasiswa(String nama, int umur) {
        this.nama = nama;   
        this.umur = umur;
    }

    public void tampilkanData() {
        System.out.println("Nama : " + nama);
        System.out.println("Umur : " + umur);
    }

    public static void main(String[] args) {

        Mahasiswa mhs1 = new Mahasiswa("Farrel Zayyan Dzaki Muhammaad", 20);

        mhs1.tampilkanData();
    }
}
