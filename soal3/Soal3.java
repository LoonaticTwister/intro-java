import java.io.File;
import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama file: ");
        String namaFile = input.nextLine();

        Scanner fileScanner = new Scanner(new File(namaFile));

        System.out.println("\nIsi file: ");
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }

        fileScanner.close();
        input.close();
    }
}
