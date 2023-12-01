class Mobil extends Kendaraan {
    private int jumlahPintu;

    public Mobil(String nomorIdentifikasi, double kecepatanMaksimum, int kapasitasPenumpang, int jumlahPintu) {
        super(nomorIdentifikasi, kecepatanMaksimum, kapasitasPenumpang);
        this.jumlahPintu = jumlahPintu;
    }

    
    public String toString() {
        return super.toString() + "\nJumlah pintu: " + jumlahPintu;
    }
}