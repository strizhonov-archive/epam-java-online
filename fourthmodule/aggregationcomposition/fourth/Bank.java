package aggregationcomposition.fourth;

public class Bank {

    private Client[] clients;
    private Account[] accounts;

    public Bank(Client[] clients) {
        this.clients = clients;

        int numOfAcc = 0;
        for (Client client : clients) {
            numOfAcc += client.getAccounts().length;
        }

        accounts = new Account[numOfAcc];

        numOfAcc = 0;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                accounts[numOfAcc] = account;
                numOfAcc++;
            }
        }
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Account[] findAccounts(int clientId) {

        int numOfAcc = 0;
        for (Account account : accounts) {
            if (account.getOwner().getId() == clientId) {
                numOfAcc++;
            }
        }

        Account[] foundAccs = new Account[numOfAcc];

        numOfAcc = 0;
        for (Account account : accounts) {
            if (account.getOwner().getId() == clientId) {
                foundAccs[numOfAcc] = account;
                numOfAcc++;
            }
        }

        return foundAccs;
    }

    public Account findAccount(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public Account[] getSortedById() {

        Account[] accounts = this.accounts.clone();

        for (int i = 0; i < accounts.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < accounts.length; j++) {
                if (accounts[j].getId() < accounts[minIndex].getId()) {
                    minIndex = j;
                }
            }

            Account buf = accounts[i];
            accounts[i] = accounts[minIndex];
            accounts[minIndex] = buf;

        }

        return accounts;
    }

    public Account[] getSortedByBalance() {

        Account[] accounts = this.accounts.clone();

        for (int i = 0; i < accounts.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < accounts.length; j++) {
                if (accounts[j].getBalance() > accounts[maxIndex].getBalance()) {
                    maxIndex = j;
                }
            }

            Account buf = accounts[i];
            accounts[i] = accounts[maxIndex];
            accounts[maxIndex] = buf;

        }

        return accounts;
    }

    public double getTotal() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public double getTotalPos() {
        double total = 0;
        for (Account account : accounts) {
            if (account.getBalance() > 0) {
                total += account.getBalance();
            }
        }

        return total;
    }

    public double getTotalNeg() {
        int total = 0;
        for (Account account : accounts) {
            if (account.getBalance() < 0) {
                total += account.getBalance();
            }
        }

        return total;
    }
}
