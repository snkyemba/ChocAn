package chocAnSystem;

/** This class is by Emily Steinbach*/
public class MemberRecord extends RosterRecord {
    private double balance;

    // Constructor
    public MemberRecord(String name, long number, String address, String city, String state, int zip, double balance) {
        super(name, number, address, city, state, zip);
        this.balance = balance;
    }
    public MemberRecord(){
        super("",1234567891,"","","",12345);
        balance = 0;
    }

    // Manage Balance

    public void manageBalance(double amount) {
        this.balance += amount;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Getter
    public String getName() {
        return super.getName();
    }
}
