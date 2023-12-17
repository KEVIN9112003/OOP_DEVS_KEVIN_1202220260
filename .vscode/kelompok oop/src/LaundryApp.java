import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Pesanan {
    private String namaPembeli;
    private String jenisPesanan;
    private boolean sudahSelesai;
    private LocalDate tanggalPesanan;

    public Pesanan(String namaPembeli, String jenisPesanan, LocalDate tanggalPesanan) {
        this.namaPembeli = namaPembeli;
        this.jenisPesanan = jenisPesanan;
        this.tanggalPesanan = tanggalPesanan;
        this.sudahSelesai = false;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public String getJenisPesanan() {
        return jenisPesanan;
    }

    public boolean isSudahSelesai() {
        return sudahSelesai;
    }

    public void setSudahSelesai(boolean sudahSelesai) {
        this.sudahSelesai = sudahSelesai;
    }

    public LocalDate getTanggalPesanan() {
        return tanggalPesanan;
    }
}

public class LaundryApp extends JFrame implements ActionListener {
    private JLabel label, labelNama, labelTanggal;
    private JTextField fieldNama, fieldTanggal;
    private JButton cuciButton, setrikaButton, selesaiButton, daftarButton;
    private ArrayList<Pesanan> listPesanan;

    public LaundryApp() {
        setTitle("Aplikasi Laundry");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        label = new JLabel("Selamat Datang di Aplikasi Laundry");
        label.setBounds(70, 20, 250, 30);
        add(label);

        labelNama = new JLabel("Nama Pembeli:");
        labelNama.setBounds(30, 60, 100, 30);
        add(labelNama);

        fieldNama = new JTextField();
        fieldNama.setBounds(140, 60, 200, 30);
        add(fieldNama);

        labelTanggal = new JLabel("Tanggal Pesanan (YYYY-MM-DD):");
        labelTanggal.setBounds(30, 100, 200, 30);
        add(labelTanggal);

        fieldTanggal = new JTextField();
        fieldTanggal.setBounds(230, 100, 110, 30);
        add(fieldTanggal);

        cuciButton = new JButton("Cuci");
        cuciButton.setBounds(30, 140, 100, 30);
        cuciButton.addActionListener(this);
        add(cuciButton);

        setrikaButton = new JButton("Setrika");
        setrikaButton.setBounds(140, 140, 100, 30);
        setrikaButton.addActionListener(this);
        add(setrikaButton);

        selesaiButton = new JButton("Selesai");
        selesaiButton.setBounds(30, 180, 100, 30);
        selesaiButton.addActionListener(this);
        add(selesaiButton);

        daftarButton = new JButton("Daftar Pesanan");
        daftarButton.setBounds(140, 180, 150, 30);
        daftarButton.addActionListener(this);
        add(daftarButton);

        listPesanan = new ArrayList<>();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cuciButton) {
            tambahPesanan("Cuci");
            JOptionPane.showMessageDialog(this, "Pesanan pencucian telah ditambahkan.");
        } else if (e.getSource() == setrikaButton) {
            tambahPesanan("Setrika");
            JOptionPane.showMessageDialog(this, "Pesanan penyetrikaan telah ditambahkan.");
        } else if (e.getSource() == selesaiButton) {
            selesaikanPesanan();
        } else if (e.getSource() == daftarButton) {
            tampilkanDaftarPesanan();
        }
    }

    private void tambahPesanan(String jenisPesanan) {
        String namaPembeli = fieldNama.getText();
        LocalDate tanggalPesanan = LocalDate.parse(fieldTanggal.getText(), DateTimeFormatter.ISO_DATE);
        Pesanan pesanan = new Pesanan(namaPembeli, jenisPesanan, tanggalPesanan);
        listPesanan.add(pesanan);
    }

    private void selesaikanPesanan() {
        // Kode sebelumnya untuk menyelesaikan pesanan tetap sama
    }

    private void tampilkanDaftarPesanan() {
        // Kode sebelumnya untuk menampilkan daftar pesanan tetap sama
    }

    public static void main(String[] args) {
        new LaundryApp();
    }
}
