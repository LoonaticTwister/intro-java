import javax.swing.*;
import java.awt.*;

public class DownloadSimulator extends JFrame {
    private JProgressBar progressBar;
    private JButton startButton;
    
    public DownloadSimulator() {
        setTitle("Simulasi Download File");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Membuat progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        // Tombol untuk memulai download
        startButton = new JButton("Mulai Download");
        startButton.addActionListener(e -> {
            startButton.setEnabled(false); // Disable tombol saat download berlangsung
            new DownloadThread().start(); // Jalankan thread
        });

        // Tambahkan komponen ke dalam frame
        add(progressBar, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    // Kelas Thread untuk proses download
    class DownloadThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                progressBar.setValue(i); // Perbarui progress bar
                try {
                    Thread.sleep(50); // Simulasi waktu download
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            startButton.setEnabled(true); // Aktifkan kembali tombol setelah selesai
            JOptionPane.showMessageDialog(null, "Download Selesai!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DownloadSimulator frame = new DownloadSimulator();
            frame.setVisible(true);
        });
    }
}
