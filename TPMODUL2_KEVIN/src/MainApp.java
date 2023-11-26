public class MainApp {
    public static void main(String[] args) {
        Kendaraan kendaraan1 = new Mobil(":M1", 120.0, 5, 4);
        Kendaraan kendaraan2 = new Bus(":B1", 80.0, 40, 30);

        System.out.println("Informasi Mobil:");
        System.out.println(kendaraan1.toString());
        double jarak = 300.0;
    
        System.out.println("\nWaktu Tempuh Mobil :" + kendaraan1.hitungWaktuTempuh(jarak) + "jam");
    


        System.out.println("\nInformasi Bus:");
        System.out.println(kendaraan2.toString());

        
        System.out.println("\nWaktu Tempuh Bus  : " + kendaraan2.hitungWaktuTempuh(jarak) + " jam");
    }
}