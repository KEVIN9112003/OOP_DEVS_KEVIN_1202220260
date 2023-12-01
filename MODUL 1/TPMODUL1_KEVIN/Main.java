package TPMODUL1_KEVIN;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        
        Account account1 = new Account("kevin", "120220260");
        Account account2 = new Account("Kevin", "1202220260");
        Account account3 = new Account("Kevin", "1202220260");

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

     
    }
}
