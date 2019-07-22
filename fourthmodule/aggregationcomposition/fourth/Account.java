package aggregationcomposition.fourth;

public class Account {

    private long id;
    private double balance;
    private Client owner;
    private boolean isBlocked;

    public Account(long id, double balance, boolean isBlocked) {
        this.isBlocked = isBlocked;
        this.balance = balance;
        this.id = id;
    }

    public Account(long id, double balance, Client owner, boolean isBlocked) {
        this.owner = owner;
        this.isBlocked = isBlocked;
        this.balance = balance;
        this.id = id;
    }

    public Client getOwner() {
        return owner;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public double getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", isBlocked=" + isBlocked +
                '}' + "\n";
    }
}
