package chocAnSystem;
import java.util.Vector;
import java.util.Scanner;



public class OperatorTerminal {
    static Scanner scanner = new Scanner(System.in);
    static Vector<Integer> listID = new Vector<>();

    static{
        listID.add(123456789);
        listID.add(987654321);
        listID.add(321654987);
        listID.add(456123789);

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
            System.out.println("Hello, please input your 9 digit Operator ID");
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
