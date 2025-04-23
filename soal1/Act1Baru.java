/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nomor2;

/**
 *
 * @author ferdi
 */
import java.util.Scanner;
public class Act1Baru {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            String nama, status;
            int uts, uas;
            float rataRata;
            char ulang;

            System.out.print("Masukkan Nama: ");
            nama = sc.next();
            System.out.print("Masukkan Nilai UTS: ");
            uts = sc.nextInt();
            System.out.print("Masukakn Nilai UAS:");
            uas = sc.nextInt();

            rataRata = ((float) uts + (float) uas) / 2;

            if (rataRata >= 70){
                status = "Lulus";
            }else {
                status = "Tidak Lulus";
            }
            
            System.out.println("===============================");
            System.out.println("Nama Kamu: " + nama);
            System.out.println("Nilai UTS Kamu: " + uts);
            System.out.println("Nilai UAS Kamu: " + uas);
            System.out.printf("Nilai Rata-Rata kamu: %.1f \n", rataRata);
            System.out.println("Status Kamu: " + status);
            
            System.out.print("Apkah ingin mengulang? (y/n)");
            ulang = sc.next().charAt(0);
            
            if(ulang == 'n' || ulang == 'N'){
                System.out.println("Terimakasih!");
                break;
            }
        }
    }
    
}
