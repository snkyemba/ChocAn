package chocAnSystem;
import java.util.Vector;
import java.util.Scanner;



public class OperatorTerminal {

    private int operatorID;
    static Scanner scanner = new Scanner(System.in);
    static Vector<Integer> listID = new Vector<>();

    static{
        listID.add(1234567);
        listID.add(7654321);
        listID.add(3216547);
        listID.add(4561237);

    }


    public void manageMemberRecords(){

    }
    public void manageProviderRecords(){

    }
    public void backupData(){

    }
    public void viewMainMenu(){

    }

    public static boolean checkID(int testID){
        return listID.contains(testID);
    }
    public static void main(String[] args){
        int testOpID;
        int tries = 3;
        while(tries > 0) {
            System.out.println("Hello, please input your 7 digit Operator ID");
            testOpID = Integer.parseInt(scanner.nextLine());
            if (checkID(testOpID)) {
                System.out.println("Access Granted!");
                System.out.println("Welcome to the Operator Terminal!");
                tries = 0;
            } else if(tries > 1) {
                System.out.println("Access Denied, try again");
                tries--;
            }
            else{
                System.out.println("Access Denied, out of tries");
                tries--;
            }

        }


    }



}
