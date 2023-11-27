package chocAnSystem;

public class RosterRecord {
    private String name, address, city, state;
    private long number;
    private int zip;

    // Constructor
    public RosterRecord(String name, long number, String address, String city, String state, int zip) {
        this.name = name;
        setNumber(number); // Use the setter to ensure validation
        this.address = address;
        this.city = city;
        this.state = state;
        setZip(zip); // Use the setter to ensure validation
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for number
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        if (String.valueOf(number).length() == 10) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number must be 10 digits");
        }
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter and Setter for state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Getter and Setter for zip with validation
    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        // Check if zip is exactly 5 digits
        if (String.valueOf(zip).length() == 5) {
            this.zip = zip;
        } else {
            throw new IllegalArgumentException("Zip code must be 5 digits");
        }
    }
}