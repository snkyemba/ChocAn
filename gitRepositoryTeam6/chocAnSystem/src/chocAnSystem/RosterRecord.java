package chocAnSystem;

public class RosterRecord {
    private String name, address, city, state;
    private int number, zip;

    // Constructor
    public RosterRecord(String name, int number, String address, String city, String state, int zip){
        this.name = name;
        this.number = number;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

}