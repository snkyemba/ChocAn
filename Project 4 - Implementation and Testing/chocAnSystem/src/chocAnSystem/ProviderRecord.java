package chocAnSystem;

/** This class is by Emily Steinbach*/
public class ProviderRecord extends RosterRecord {
    private double fee;

    // Constructor
    public ProviderRecord(String name, long number, String address, String city, String state, int zip, double fee) {
        super(name, number, address, city, state, zip);
        this.fee = fee;
    }
    public ProviderRecord(){
        super("",1234567891,"","","",12345);
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

    //  Getter
    public long getProviderNumber() {
        return super.getNumber();
    }
}