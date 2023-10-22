package TPMODUL1_KEVIN;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Membuat objek akun minimal 3
        Account account1 = new Account("NamaPendek1_Kelas1", "NIM1");
        Account account2 = new Account("NamaPendek2_Kelas2", "NIM2");
        Account account3 = new Account("NamaPendek3_Kelas3", "NIM3");

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        // Contoh penggunaan program
        // Anda dapat menambahkan logika interaktif di sini sesuai kebutuhan.
    }
}
