package TPMODUL1_KEVIN;


import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public boolean removeAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<Account> getAllAccounts() {
        return accounts;
    }
}
