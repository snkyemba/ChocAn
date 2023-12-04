package chocAnSystem;

/**
 * This class is a record of every Provider in the ChocAn system.
 * Each contact has the provider's name, number, address, cite, state, zip, and account fee..
 *
 * @author Emily Steinbach
 * @version 1.0
 */
 public class ProviderRecord extends RosterRecord {
    private double fee;

    /**
     * Constructs a new ProviderRecord with the specified information.
     *
     * @param name     The name of the provider.
     * @param number   The unique provider number.
     * @param address  The provider's address.
     * @param city     The provider's city.
     * @param state    The provider's state.
     * @param zip      The provider's zip code.
     * @param fee  The account fee.
     */
    public ProviderRecord(String name, long number, String address, String city, String state, int zip, double fee) {
        super(name, number, address, city, state, zip);
        this.fee = fee;
    }

    /**
     * Constructs a default ProviderRecord with empty information and no fees.
     */
    public ProviderRecord(){
        super("",1234567891,"","","",12345);
        fee = 0;

    }

    /**
     * Adds the specified amount to the provider's account fee.
     *
     * @param amount - The amount to be added to the account fee.
     */
    // Manage Fee
    public void manageFee(double amount) {
        this.fee += amount;
    }

    /**
     * Retrieves the provider's current account fee.
     *
     * @return The current account fee.
     */
    public double getFee() {
        return fee;
    }

}