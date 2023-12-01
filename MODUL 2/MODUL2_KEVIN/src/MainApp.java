public class MainApp {
    public static void main(String[] args){

        
        // TO DO: Create expedisi Object from Ekspedisi Class
        System.out.println("class expedisi");
        Ekspedisi ekspedisi =new Ekspedisi(10,"jakarta",1000);
        ekspedisi.informasi();
        
      

        // TO DO: Create teluexpress Object from TelUExpress Class
        System.out.println("class TelUExpress");
    
        TelUExpress telUExpress= new TelUExpress(100,"bandung",5000,true);
        telUExpress.informasi();
        telUExpress.ambil("paket ke sukabirus");
        telUExpress.antar(1628389);
        telUExpress.antar(1922772, 7628765);
        System.out.println("");




        // TO DO: Create friexpress Object from FRIExpress Class
        System.out.println("class FRIExpress");
        FRIExpress friexpress= new FRIExpress(30,"bojongsoang",70000,true);
        friexpress.informasi();
        friexpress.terima(20000);
        friexpress.kirim("Lembang");
        friexpress.kirim("braga", "rancek");
        System.out.println("");


    }
}
