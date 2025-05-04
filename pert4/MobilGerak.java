import javax.swing.*;
import java.awt.*;
public class MobilGerak extends JFrame {
    private CarPanel carPanel;

    public MobilGerak() {
        setTitle("Keluarga Mudik Menggunakan Mobil");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        carPanel = new CarPanel();
        add(carPanel);

        startAnimation();
    }

    private void startAnimation() {
        Thread thread = new Thread(carPanel);
        thread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MobilGerak frame = new MobilGerak();
            frame.setVisible(true);
        });
    }
}

class CarPanel extends JPanel implements Runnable {
    private int carX = 0;  // Posisi awal mobil
    private final int DELAY = 15; // Delay untuk animasi

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCar(g, carX, 100); // Gambar mobil di posisi saat ini
    }

    private void drawCar(Graphics g, int x, int y) {
        // Gambar badan mobil
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, 60, 30);

        // Gambar atap mobil
        g.setColor(Color.PINK);
        g.fillRect(x + 10, y - 15, 40, 15);

        // Gambar roda
        g.setColor(Color.BLACK);
        g.fillOval(x + 5, y + 25, 15, 15);
        g.fillOval(x + 40, y + 25, 15, 15);
    }

    @Override
    public void run() {
        while (true) {
            carX += 2; // Geser mobil ke kanan

            if (carX > getWidth()) {
                carX = -60; // Reset posisi ke awal jika keluar dari layar
            }

            repaint(); // Gambar ulang panel

            try {
                Thread.sleep(DELAY); // Delay untuk efek animasi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}