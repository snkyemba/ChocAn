package chocAnSystem;
import java.io.*;
import java.util.Vector;
import java.util.Scanner;

/**
 * Class for Controlling the logic for the Member Terminal
 *
 * @author Joseph Hampton
 * @version 1.0
 */
public class MemberController {
    MemberRecord memberRecord = new MemberRecord();
    Vector<MemberRecord> memberRecordVector = new Vector<>();
    OperatorTerminal operatorTerminal = new OperatorTerminal();

    String filePath = "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/memberFile.json";


    static Scanner scanner = new Scanner(System.in);

    /**
     * Function to save member record to JSON file, used for testing
     *
     * @param memberRecord Member record to be saved
     * @param operatorTerminal OperatorTerminal object to be used to call viewMainMenu()
     */
    public void MemberController(MemberRecord memberRecord, OperatorTerminal operatorTerminal) {
        this.memberRecord = memberRecord;
        this.operatorTerminal = operatorTerminal;
    }

    /**
     * Function to add and save member record to JSON file
     *
     */
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
        GenericSerializer.processJsonFile(filePath, memberRecord);
        System.out.println("Member added successfully");
        operatorTerminal.viewMainMenu();
    }
    /**
     * Function to add and save member record to JSON file in the GUI
     *
     */
    public void addMember(String name, int number, String address, String city, String state, int zip, double balance) {
        memberRecord = new MemberRecord(name, number, address, city, state, zip, balance);
        GenericSerializer.processJsonFile(filePath, memberRecord);
//        memberToFile(memberFile, memberRecord);

    }
    /**
     * Function to get the memberRecord from the vector
     *
     */
    public MemberRecord getMemberRecord(String name){
        MemberRecord record = new MemberRecord();
        for (int i = 0; i < memberRecordVector.size(); i++) {
            if (memberRecordVector.get(i).getName().equals(name)) {
                record = memberRecordVector.get(i);
            }
        }
        return record;
    }

    /**
     * Function to update and save the member to the JSON file
     */
    public void updateMember(){
        System.out.println("Enter member name to change: ");
        String name = scanner.nextLine();
        System.out.println("Enter aspect to change: ");
        String aspect = scanner.nextLine();
        System.out.println("Enter new value: ");
        String newValue = scanner.nextLine();
        //search the json file for the name
        try{
            memberRecordVector = GenericSerializer.deserializeJsonArray(filePath, MemberRecord.class);
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
            GenericSerializer.serializeJsonArray(memberRecordVector,filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Member updated successfully");

    }
    /**
     * Function to update and save the member to the JSON file in the GUI
     */
    public void updateMember(String selectedName, String selectedAspect, String selectedNewValue){
        String name = selectedName;
        String aspect = selectedAspect;
        String newValue = selectedNewValue;
        //search the json file for the name
        try{
            memberRecordVector = GenericSerializer.deserializeJsonArray(filePath, MemberRecord.class);
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
            GenericSerializer.serializeJsonArray(memberRecordVector,filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Member updated successfully");

    }

    /**
     * Function to delete the member from the JSON file
     */
    public void deleteMember(){
        System.out.println("Enter member name to delete: ");
        String name = scanner.nextLine();
        //search the json file for the name
        try{
            memberRecordVector = GenericSerializer.deserializeJsonArray(filePath, MemberRecord.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < memberRecordVector.size(); i++){
            if (memberRecordVector.get(i).getName().equals(name)){
                memberRecordVector.remove(i);
            }
        }
        try {
            GenericSerializer.serializeJsonArray(memberRecordVector,filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Member deleted successfully");

    }
    /**
     * Function to delete the member from the JSON file in the GUI
     */
    public void deleteMember(String memName){
        String name = memName;
        //search the json file for the name
        try{
            memberRecordVector = GenericSerializer.deserializeJsonArray(filePath, MemberRecord.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < memberRecordVector.size(); i++){
            if (memberRecordVector.get(i).getName().equals(name)){
                memberRecordVector.remove(i);
            }
        }
        try {
            GenericSerializer.serializeJsonArray(memberRecordVector,filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Member deleted successfully");

    }





}
