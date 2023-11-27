package chocAnSystem;

public class ProviderRecord extends RosterRecord {
    private double fee;

    // Constructor
    public ProviderRecord(String name, int number, String address, String city, String state, int zip, double fee) {
        super(name, number, address, city, state, zip);
        this.fee = fee;
    }

    // Manage Fee
    public void manageFee(double amount) {
        this.fee += amount;
    }

    // Getter
    public double getFee() {
        return fee;
    }

}