public class FRIExpress extends Ekspedisi //...
{
    // TO DO: Create Protected Attribute of FRIExpress (pecahBelah)
    protected boolean pecahBelah;

    // TO DO: Create Constructor of FRIExpress\
    public FRIExpress (int jumlahCabang, String pusat, float tarif,
    boolean pecahBelah){
        super(jumlahCabang,pusat,tarif);
        this.pecahBelah=pecahBelah;
    }
    

    // TO DO: Create 'informasi' Method to show Information
    public void informasi(){
        System.out.println();
    }

    // TO DO: Create 'terima' Method to accept a number of packages
    public void terima(int jumlahPaket){
        System.out.println();
    }

    // TO DO: Create 'kirim' Method to send a package to a destination
    public void kirim(String tujuan){
        System.out.println();
    }

    // TO DO: Create 'kirim' Method to send a package to two destinations
    public void kirim(String tujuan_1, String tujuan_2){
        System.out.println();
    }
}
