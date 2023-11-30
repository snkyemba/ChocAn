package chocAnSystem;
import java.io.*;
import java.util.Vector;
import java.util.Scanner;

public class MemberController {
    MemberRecord memberRecord = new MemberRecord();
    OperatorTerminal operatorTerminal = new OperatorTerminal();

    BufferedWriter memberFile;



    {
        try {
            memberFile = new BufferedWriter(new FileWriter("memberFileAdd.txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
        memberToFile(memberFile, memberRecord);
        System.out.println("Member added successfully");
        operatorTerminal.viewMainMenu();
    }

    public void updateMember(){

        try {
            File memberFileUpdate = new File("memberFileUpdate.txt");
            Scanner myReader = new Scanner(memberFileUpdate);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            //e.printStackTrace();
        }
        System.out.println("Enter Number of Member to Update: ");
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter aspect to change: ");
        String aspect = scanner.nextLine();
        System.out.println("Enter new value: ");
        String newValue = scanner.nextLine();


    }


    public void deleteMember(){

    }

    public void memberToFile(BufferedWriter memberFile, MemberRecord memberRecord){
        try {
            memberFile.write("name: " + memberRecord.getName() + "\n");
            memberFile.write("number: " + String.valueOf(memberRecord.getNumber())+ "\n");
            memberFile.write("address: " + memberRecord.getAddress()+ "\n");
            memberFile.write("city: " + memberRecord.getCity()+ "\n");
            memberFile.write("state: " + memberRecord.getState()+ "\n");
            memberFile.write("zip: " + String.valueOf(memberRecord.getZip())+ "\n");
            memberFile.write("balance: " + String.valueOf(memberRecord.getBalance())+ "\n\n");
            memberFile.close();
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }

    }



}
