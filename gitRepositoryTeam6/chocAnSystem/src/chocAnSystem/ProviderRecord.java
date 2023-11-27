package chocAnSystem;

public class ProviderRecord extends RosterRecord {
    private double fee;

    // Constructor
    public ProviderRecord(String name, int number, String address, String city, String state, int zip, double fee) {
        super(name, number, address, city, state, zip);
        this.fee = fee;
    }
    public ProviderRecord(){
        super("",0,"","","",0);
        fee = 0;

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