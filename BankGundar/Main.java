package BankGundar;

import java.util.Scanner;

public class Main {

    private static void pilihan(Transaksi transaksi, Scanner sc) {
        boolean run = true;
        while (run) {
            System.out.println("\n === Bank Gundar ===");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Menabung");
            System.out.println("3. Transfer");
            System.out.println("4. Menarik");
            System.out.println("5. Keluar");
            System.out.print("Pilihan anda: ");
            String pilih = sc.next();

            switch (pilih) {
                case "1":
                    transaksi.cekSaldo();
                    break;
                case "2":
                    System.out.print("Nominal Uang: Rp.");
                    double tb = sc.nextDouble();
                    transaksi.menabung(tb);
                    break;
                case "3":
                    transaksi.transfer();
                    break;
                case "4":
                    transaksi.menarik();
                    break;
                case "5":
                    run = false;
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Transaksi transaksi = new Transaksi(5000000, "Reza");

        System.out.print("Masukkan PIN: ");
        String pin = sc.next();

        if (pin.equals("252615")) {
            pilihan(transaksi, sc);
        } else {
            System.out.println("PIN Salah!");
        }
    }
}
