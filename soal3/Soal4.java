import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Soal4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan nama file: ");
            String namaFile = input.nextLine();

            bacaFile(namaFile);
        } catch (FileNotFoundException e) {
            System.out.println("Terjadi kesalahan: File '" + e.getMessage() + "' tidak ditemukan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    public static void bacaFile(String namaFile) throws FileNotFoundException {
        File file = new File(namaFile);
        Scanner fileScanner = new Scanner(file);

        if (!fileScanner.hasNextLine()) {
            fileScanner.close();
            throw new IllegalArgumentException("File kosong!");
        }

        System.out.println("\nIsi file:");
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }

        fileScanner.close();
    }
}
