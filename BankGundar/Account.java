package BankGundar;

import java.util.Scanner;

public class Account {
    private double saldo;
    private String pemilikRekening;
    protected Scanner input = new Scanner(System.in);

    public Account(double saldo, String pemilikRekening) {
        this.saldo = saldo;
        this.pemilikRekening = pemilikRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo tidak boleh dibawah 0");
        }
    }

    public String getPemilikRekening() {
        return pemilikRekening;
    }

    public void setPemilikRekening(String pemilikRekening) {
        this.pemilikRekening = pemilikRekening;
    }

    public void cekSaldo() {
        System.out.println("Pemilik rekening " + pemilikRekening);
        System.out.println("Saldo anda saat ini adalah: " + saldo + ",-");
    }
}
