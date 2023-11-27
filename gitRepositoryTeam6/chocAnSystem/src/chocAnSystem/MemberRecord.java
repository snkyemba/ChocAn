package chocAnSystem;

public class MemberRecord extends RosterRecord {
    private double balance;

    // Constructor
    public MemberRecord(String name, int number, String address, String city, String state, int zip, double balance) {
        super(name, number, address, city, state, zip);
        this.balance = balance;
    }

    // Manage Balance

    public void manageBalance(double amount) {
        this.balance += amount;
    }

    // Getter
    public double getBalance() {
        return balance;
    }

}
