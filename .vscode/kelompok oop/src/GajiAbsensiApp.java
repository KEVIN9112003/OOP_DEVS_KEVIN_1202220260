import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

class Karyawan {
    private String nama;
    private double tarifPerJam;
    private ArrayList<Absensi> daftarAbsensi;

    public Karyawan(String nama, double tarifPerJam) {
        this.nama = nama;
        this.tarifPerJam = tarifPerJam;
        this.daftarAbsensi = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public double getTarifPerJam() {
        return tarifPerJam;
    }

    public ArrayList<Absensi> getDaftarAbsensi() {
        return daftarAbsensi;
    }
}

class Absensi {
    private LocalDateTime waktuMasuk;
    private LocalDateTime waktuKeluar;

    public Absensi(LocalDateTime waktuMasuk) {
        this.waktuMasuk = waktuMasuk;
        this.waktuKeluar = null;
    }

    public LocalDateTime getWaktuMasuk() {
        return waktuMasuk;
    }

    public LocalDateTime getWaktuKeluar() {
        return waktuKeluar;
    }

    public void setWaktuKeluar(LocalDateTime waktuKeluar) {
        this.waktuKeluar = waktuKeluar;
    }
}

public class GajiAbsensiApp extends JFrame implements ActionListener {
    private ArrayList<Karyawan> daftarKaryawan;
    private JLabel labelNama, labelStatus;
    private JTextField fieldNama;
    private JButton masukButton, keluarButton, hitungButton;

    public GajiAbsensiApp() {
        setTitle("Aplikasi Gaji dan Absensi Karyawan");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labelNama = new JLabel("Nama Karyawan:");
        labelNama.setBounds(20, 20, 100, 30);
        add(labelNama);

        fieldNama = new JTextField();
        fieldNama.setBounds(130, 20, 150, 30);
        add(fieldNama);

        masukButton = new JButton("Masuk");
        masukButton.setBounds(50, 70, 100, 30);
        masukButton.addActionListener(this);
        add(masukButton);

        keluarButton = new JButton("Keluar");
        keluarButton.setBounds(180, 70, 100, 30);
        keluarButton.addActionListener(this);
        add(keluarButton);

        labelStatus = new JLabel("");
        labelStatus.setBounds(20, 120, 300, 30);
        add(labelStatus);

        daftarKaryawan = new ArrayList<>();
        daftarKaryawan.add(new Karyawan("John", 10.0)); // Contoh satu karyawan dengan tarif per jam

        hitungButton = new JButton("Hitung Gaji");
        hitungButton.setBounds(100, 170, 150, 30);
        hitungButton.addActionListener(this);
        add(hitungButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String namaKaryawan = fieldNama.getText();
        boolean karyawanDitemukan = false;

        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getNama().equals(namaKaryawan)) {
                karyawanDitemukan = true;

                if (e.getSource() == masukButton) {
                    absensiMasuk(karyawan);
                } else if (e.getSource() == keluarButton) {
                    absensiKeluar(karyawan);
                } else if (e.getSource() == hitungButton) {
                    hitungGaji(karyawan);
                }
                break;
            }
        }

        if (!karyawanDitemukan) {
            labelStatus.setText("Karyawan tidak ditemukan.");
        }
    }

    private void absensiMasuk(Karyawan karyawan) {
        LocalDateTime waktuSekarang = LocalDateTime.now();
        karyawan.getDaftarAbsensi().add(new Absensi(waktuSekarang));
        labelStatus.setText("Absensi masuk untuk " + karyawan.getNama() + " pada " + waktuSekarang);
    }

    private void absensiKeluar(Karyawan karyawan) {
        LocalDateTime waktuSekarang = LocalDateTime.now();
        ArrayList<Absensi> daftarAbsensi = karyawan.getDaftarAbsensi();

        for (Absensi absensi : daftarAbsensi) {
            if (absensi.getWaktuKeluar() == null) {
                absensi.setWaktuKeluar(waktuSekarang);
                labelStatus.setText("Absensi keluar untuk " + karyawan.getNama() + " pada " + waktuSekarang);
                return;
            }
        }

        labelStatus.setText("Anda sudah melakukan absensi keluar sebelumnya.");
    }

    private void hitungGaji(Karyawan karyawan) {
        double totalGaji = 0;
        ArrayList<Absensi> daftarAbsensi = karyawan.getDaftarAbsensi();

        for (Absensi absensi : daftarAbsensi) {
            if (absensi.getWaktuKeluar() != null) {
                double jamKerja = absensi.getWaktuMasuk().until(absensi.getWaktuKeluar()).toHours();
                totalGaji += jamKerja * karyawan.getTarifPerJam();
            }
        }

        labelStatus.setText("Total gaji untuk " + karyawan.getNama() + " adalah: Rp " + totalGaji);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GajiAbsensiApp());
    }
}

