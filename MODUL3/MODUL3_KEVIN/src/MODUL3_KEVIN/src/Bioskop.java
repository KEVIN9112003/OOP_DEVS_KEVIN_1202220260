public class Bioskop {
    
    // TO DO: Create Private Attributes of rows and assign rows to 5
    private static final int Row =5;
    
    
    // TO DO: Create Private Attributes of seats per rows and assign seats per rows to 10
    private static final int SEATS_PER_ROW=10;
    
    // TO DO: Create 2 dimensional array to store seat reservation status
    int[][] ini_array=new int [Row][SEATS_PER_ROW];
    
    
    // TO DO:  Add a constructor to initialize multiple chairs
    public Bioskop() {
        ini_array[0][2]=1;
        ini_array[1][5]=1;
        ini_array[3][7]=1;
       
    }
    //  TO DO: Add a method to display the seat layout
    public void displaySeating() {
        for(int a=0;a<Row;a++){
            for(int b=0;b<SEATS_PER_ROW;b++){
                System.out.println(ini_array[a][b]+" ");
                
            }
            System.out.println();

        }
        

    }
    //  TO DO: Add a method to reserve seats
    public void bookSeat(int row, int seat) {
        if(ini_array[Row][SEATS_PER_ROW]==0){
            ini_array[Row][SEATS_PER_ROW]=1;
            System.out.println("kursi berhasil di pesan "+ (Row+1)+(SEATS_PER_ROW+1));

        }
        
    }
}