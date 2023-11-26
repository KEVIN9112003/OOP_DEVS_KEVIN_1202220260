class Kendaraan {
    private String nomorIdentifikasi;
    private double kecepatanMaksimum;
    private int kapasitasPenumpang;

    public Kendaraan(String nomorIdentifikasi, double kecepatanMaksimum, int kapasitasPenumpang) {
        this.nomorIdentifikasi = nomorIdentifikasi;
        this.kecepatanMaksimum = kecepatanMaksimum;
        this.kapasitasPenumpang = kapasitasPenumpang;
    }

    public String toString() {
        return "Kendaraan dengan nomor identifikasi " + nomorIdentifikasi +
                "\nKecepatan maksimum: " + kecepatanMaksimum + " km/jam" +
                "\nKapasitas penumpang: " + kapasitasPenumpang;
    }

    public double hitungWaktuTempuh(double jarak) {
        return jarak / kecepatanMaksimum;
    }
}
