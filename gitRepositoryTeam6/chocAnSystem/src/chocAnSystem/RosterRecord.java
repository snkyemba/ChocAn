package chocAnSystem;

public class RosterRecord {
    private String name, address, city, state;
    private int number, zip;

    public void RosterRecord(String name,int number, String address, String city, String state, int zip){
        this.name = name;
        this.number = number;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public void setName(String n){
        name = n;
    }
    public void setNumber(int n){
        number = n;
    }
    public void setAddress(String a){
        address = a;
    }
    public void setCity(String c){
        city = c;
    }
    public void setState(String s){
        state = s;
    }
    public void setZip(int z){
        zip = z;
    }

    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public int getZip(){
        return zip;
    }


}
