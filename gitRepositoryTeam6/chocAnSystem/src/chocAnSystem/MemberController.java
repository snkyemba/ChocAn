package chocAnSystem;
import java.io.*;
import java.util.Vector;
import java.util.Scanner;

public class MemberController {
    MemberRecord memberRecord = new MemberRecord();
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

    public void updateMember(){




    }


    public void deleteMember(){

    }





}
