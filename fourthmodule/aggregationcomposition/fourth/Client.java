package aggregationcomposition.fourth;

import java.util.Arrays;

public class Client {

    private int id;
    private Account[] accounts;

    public Client(int id, Account[] accounts) {
        this.id = id;
        this.accounts = accounts;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
