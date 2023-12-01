public class App {
    public static void main(String[] args) {

        for (byte i = 0; i < 5; i++) {
            for (byte j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // System.out.println();
        ganteng: for (byte x = 0; x < 5; x++) {
            for (byte y = 0; y <= 5; y++) {
                System.out.print("* ");
                if (y > x) {
                    System.out.println();
                    continue ganteng;
                }
                System.out.print("* ");
            }
        }

    }

    // cantik: for(byte a = 0; a < 5; a++){
    // for(byte b = 5; b > 0; b--)
    // }

}