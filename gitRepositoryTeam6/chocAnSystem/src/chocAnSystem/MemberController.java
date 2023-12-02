package chocAnSystem;
import java.io.*;
import java.util.Vector;
import java.util.Scanner;

public class MemberController {
    MemberRecord memberRecord = new MemberRecord();
    Vector<MemberRecord> memberRecordVector = new Vector<>();
    OperatorTerminal operatorTerminal = new OperatorTerminal();


    static Scanner scanner = new Scanner(System.in);

    public void MemberController(MemberRecord memberRecord, OperatorTerminal operatorTerminal) {
        this.memberRecord = memberRecord;
        this.operatorTerminal = operatorTerminal;
    }

    public void addMember() {
        System.out.println("Enter member name: ");
        String name = scanner.nextLine();
        System.out.println("Enter member number: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter member address: ");
        String address = scanner.nextLine();
        System.out.println("Enter member city: ");
        String city = scanner.nextLine();
        System.out.println("Enter member state: ");
        String state = scanner.nextLine();
        System.out.println("Enter member zip: ");
        int zip = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter member balance: ");
        double balance = Double.parseDouble(scanner.nextLine());
        memberRecord = new MemberRecord(name, number, address, city, state, zip, balance);
        GenericSerializer.processJsonFile("memberFile.json", memberRecord);
        System.out.println("Member added successfully");
        operatorTerminal.viewMainMenu();
    }
    public void addMember(String name, int number, String address, String city, String state, int zip, double balance) {
        memberRecord = new MemberRecord(name, number, address, city, state, zip, balance);
        GenericSerializer.processJsonFile("memberFile.json", memberRecord);
//        memberToFile(memberFile, memberRecord);

    }
    public MemberRecord getMemberRecord(String name){
        MemberRecord record = new MemberRecord();
        for (int i = 0; i < memberRecordVector.size(); i++) {
            if (memberRecordVector.get(i).getName().equals(name)) {
                record = memberRecordVector.get(i);
            }
        }
        return record;
    }

    public void updateMember(){
        System.out.println("Enter member name to change: ");
        String name = scanner.nextLine();
        System.out.println("Enter aspect to change: ");
        String aspect = scanner.nextLine();
        System.out.println("Enter new value: ");
        String newValue = scanner.nextLine();
        //search the json file for the name
        try{
            memberRecordVector = GenericSerializer.deserializeJsonArray("memberFile.json", MemberRecord.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < memberRecordVector.size(); i++){
            if (memberRecordVector.get(i).getName().equals(name)){
                if (aspect.equals("name")){
                    memberRecord = new MemberRecord(newValue, memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());

                }
                else if (aspect.equals("number")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), Integer.parseInt(newValue), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());
                }
                else if (aspect.equals("address")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), newValue, memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());

                }
                else if (aspect.equals("city")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), newValue, memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());
                }
                else if (aspect.equals("state")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), newValue, memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());
                }
                else if (aspect.equals("zip")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), Integer.parseInt(newValue), memberRecordVector.get(i).getBalance());
                }
                else if (aspect.equals("balance")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), Double.parseDouble(newValue));
                }
                else{
                    System.out.println("Invalid aspect");
                }
                memberRecordVector.set(i, memberRecord);
            }
        }

        try {
            GenericSerializer.serializeJsonArray(memberRecordVector,"memberFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Member updated successfully");

    }
    public void updateMember(String selectedName, String selectedAspect, String selectedNewValue){
        String name = selectedName;
        String aspect = selectedAspect;
        String newValue = selectedNewValue;
        //search the json file for the name
        try{
            memberRecordVector = GenericSerializer.deserializeJsonArray("memberFile.json", MemberRecord.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < memberRecordVector.size(); i++){
            if (memberRecordVector.get(i).getName().equals(name)){
                if (aspect.equals("name")){
                    memberRecord = new MemberRecord(newValue, memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());

                }
                else if (aspect.equals("number")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), Integer.parseInt(newValue), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());
                }
                else if (aspect.equals("address")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), newValue, memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());

                }
                else if (aspect.equals("city")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), newValue, memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());
                }
                else if (aspect.equals("state")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), newValue, memberRecordVector.get(i).getZip(), memberRecordVector.get(i).getBalance());
                }
                else if (aspect.equals("zip")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), Integer.parseInt(newValue), memberRecordVector.get(i).getBalance());
                }
                else if (aspect.equals("balance")){
                    memberRecord = new MemberRecord(memberRecordVector.get(i).getName(), memberRecordVector.get(i).getNumber(), memberRecordVector.get(i).getAddress(), memberRecordVector.get(i).getCity(), memberRecordVector.get(i).getState(), memberRecordVector.get(i).getZip(), Double.parseDouble(newValue));
                }
                else{
                    System.out.println("Invalid aspect");
                }
                memberRecordVector.set(i, memberRecord);
            }
        }

        try {
            GenericSerializer.serializeJsonArray(memberRecordVector,"memberFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Member updated successfully");

    }

    public void deleteMember(){
        System.out.println("Enter member name to delete: ");
        String name = scanner.nextLine();
        //search the json file for the name
        try{
            memberRecordVector = GenericSerializer.deserializeJsonArray("memberFile.json", MemberRecord.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < memberRecordVector.size(); i++){
            if (memberRecordVector.get(i).getName().equals(name)){
                memberRecordVector.remove(i);
            }
        }
        try {
            GenericSerializer.serializeJsonArray(memberRecordVector,"memberFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Member deleted successfully");

    }
    public void deleteMember(String memName){
        String name = memName;
        //search the json file for the name
        try{
            memberRecordVector = GenericSerializer.deserializeJsonArray("memberFile.json", MemberRecord.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < memberRecordVector.size(); i++){
            if (memberRecordVector.get(i).getName().equals(name)){
                memberRecordVector.remove(i);
            }
        }
        try {
            GenericSerializer.serializeJsonArray(memberRecordVector,"memberFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Member deleted successfully");

    }





}
