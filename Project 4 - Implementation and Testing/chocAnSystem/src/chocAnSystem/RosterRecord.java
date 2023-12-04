package chocAnSystem;

/**
 * This class is a generic template for all records, both member and provider.
 *
 * @author Emily Steinbach
 * @version 1.0
 */
public class RosterRecord {
    private String name, address, city, state;
    private long number;
    private int zip;

    /**
     * Constructor for creating a RosterRecord object.
     *
     * @param name    The name of the record.
     * @param number  The unique identification number of the record.
     * @param address The street address of the record.
     * @param city    The city of the record.
     * @param state   The state of the record.
     * @param zip     The ZIP code of the record.
     */
    public RosterRecord(String name, long number, String address, String city, String state, int zip) {
        this.name = name;
        setNumber(number); // Use the setter to ensure validation
        this.address = address;
        this.city = city;
        this.state = state;
        setZip(zip); // Use the setter to ensure validation
    }

    /**
     * Gets the name of the record.
     *
     * @return The name of the record.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the record.
     *
     * @param name The new name for the record.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the unique identification number of the record.
     *
     * @return The unique identification number.
     */
    public long getNumber() {
        return number;
    }

    /**
     * Sets the unique identification number of the record with validation.
     *
     * @param number The new identification number for the record.
     * @throws IllegalArgumentException If the number is not 10 digits.
     */
    public void setNumber(long number) {
        if (String.valueOf(number).length() == 10) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number must be 10 digits");
        }
    }

    /**
     * Gets the street address of the record.
     *
     * @return The street address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the street address of the record.
     *
     * @param address The new street address for the record.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the city of the record.
     *
     * @return The city of the record.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the record.
     *
     * @param city The new city for the record.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of the record.
     *
     * @return The state of the record.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of the record.
     *
     * @param state The new state for the record.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the ZIP code of the record.
     *
     * @return The ZIP code of the record.
     */
    public int getZip() {
        return zip;
    }

    /**
     * Sets the ZIP code of the record with validation.
     *
     * @param zip The new ZIP code for the record.
     * @throws IllegalArgumentException If the ZIP code is not 5 digits.
     */
    public void setZip(int zip) {
        // Check if zip is exactly 5 digits
        if (String.valueOf(zip).length() == 5) {
            this.zip = zip;
        } else {
            throw new IllegalArgumentException("Zip code must be 5 digits");
        }
    }
}