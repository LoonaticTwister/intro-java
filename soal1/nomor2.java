/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nomor3;

/**
 *
 * @author ferdi
 */
import java.util.ArrayList;
import java.util.Scanner;
class Mahasiswa {
    String nama, status;
    int uts;
    int uas;
    float rataRata;

    public void inputData(Scanner sc) {
        System.out.print("Masukkan Nama: ");
        this.nama = sc.nextLine();
        System.out.print("Masukkan Nilai UTS: ");
        this.uts = sc.nextInt();
        System.out.print("Masukkan Nilai UAS: ");
        this.uas = sc.nextInt();
        sc.nextLine();

        this.rataRata = hitungRataRata();
        this.status = tentukanStatus();
    }


    public float hitungRataRata() {
        return (this.uts + this.uas) / 2.0f;
    }

    public String tentukanStatus() {
        if (this.rataRata >= 70) return "Lulus";
        else return "Tidak Lulus";
    }

    // Method untuk menampilkan data mahasiswa
    public void tampilkanData() {
        System.out.println("===============================");
            System.out.println("Nama Kamu: " + nama);
            System.out.println("Nilai UTS Kamu: " + uts);
            System.out.println("Nilai UAS Kamu: " + uas);
            System.out.printf("Nilai Rata-Rata kamu: %.1f \n", rataRata);
            System.out.println("Status Kamu: " + status);
        System.out.println();
    }
}

public class nomor3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nMahasiswa ke-" + (i + 1));
            Mahasiswa mhs = new Mahasiswa();
            mhs.inputData(sc); 
            daftarMahasiswa.add(mhs);
        }
        System.out.println("\n===== HASIL PENILAIAN =====");
        for (Mahasiswa mhs : daftarMahasiswa) {
            mhs.tampilkanData();
        }
    }
}
