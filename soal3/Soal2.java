public class Soal2 {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Terjadi Kesalahan: Masukkan 2 angka sebagai argumen!");
                return;
            }

            int angka1 = Integer.parseInt(args[0]);
            int angka2 = Integer.parseInt(args[1]);

            int hasil = angka1 / angka2;
            System.out.println("Hasil Pembagian: " + hasil);
        }
        // Menangani jika input bukan angka
        catch (NumberFormatException e) {
            System.out.println("Terjadi kesalahan: Mohon masukkan angka yang valid!");
        }
        // Menangani jika terjadi pembagian dengan nol
        catch (ArithmeticException e) {
            System.out.println("Terjadi kesalahan: Tidak bisa membagi dengan 0!");
        }
    }
}
