public class TelUExpress extends Ekspedisi //...
{
    // TO DO: Create Protected Atribute of TelUExpress(antarInter)
    protected boolean antarInter;

    // TO DO: Create Constructor of TelUExpress
    public TelUExpress(int jumlahCabang, String pusat, float tarif,
    boolean antarInter){
        super(jumlahCabang, pusat, tarif);
        this.antarInter=antarInter;
    }

    // TO DO: Create 'informasi' Method to show Information
    public void informasi(){
        System.out.println();
    }

    // TO DO: Create 'ambil' Method to pick up a package
    public void ambil(String tempat){
        System.out.println();
    }

    // TO DO: Create 'antar' Method to send a package
    public void antar(int resi){
        System.out.println();
    }

    // TO DO: Create 'antar' Method to send two packages
    public void antar(int resi_1 , int resi_2){
        System.out.println();
    }
}
