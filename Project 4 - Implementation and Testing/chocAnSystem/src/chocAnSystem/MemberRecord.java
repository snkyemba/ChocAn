package chocAnSystem;

/**
 * This class is a record of every Member in the ChocAn system.
 * Each contact has the member's name, number, address, cite, state, zip, and account balance.
 *
 * @author Emily Steinbach
 * @version 1.0
 */
public class MemberRecord extends RosterRecord {
    private double balance;

    // Constructor
    /**
     * Constructs a new MemberRecord with the specified information.
     *
     * @param name     The name of the member.
     * @param number   The unique member number.
     * @param address  The member's address.
     * @param city     The member's city.
     * @param state    The member's state.
     * @param zip      The member's zip code.
     * @param balance  The initial account balance.
     */
    public MemberRecord(String name, long number, String address, String city, String state, int zip, double balance) {
        super(name, number, address, city, state, zip);
        this.balance = balance;
    }

    /**
     * Constructs a default MemberRecord with empty information and zero balance.
     */
    public MemberRecord(){
        super("",1234567891,"","","",12345);
        balance = 0;
    }

    /**
     * Adds the specified amount to the member's account balance.
     *
     * @param amount The amount to be added to the account balance.
     */
    public void manageBalance(double amount) {
        this.balance += amount;
    }

    /**
     * Retrieves the member's current account balance.
     *
     * @return The current account balance.
     */
    public double getBalance() {
        return balance;
    }

    // Getter
    public String getName() {
        return super.getName();
    }
}
