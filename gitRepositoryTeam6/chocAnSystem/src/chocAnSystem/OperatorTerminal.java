package chocAnSystem;
import java.util.Vector;
import java.util.Scanner;



public class OperatorTerminal {
    static Scanner scanner = new Scanner(System.in);
    static Vector<Integer> listID = new Vector<>();

    private bool isOperator = false;

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
        while(tries > 0 && !isOperator){
            System.out.println("Hello, please input your 9 digit Operator ID");
            testOpID = Integer.parseInt(scanner.nextLine());
            if (checkID(testOpID)) {
                System.out.println("Access Granted!");
                System.out.println("Welcome to the Operator Terminal!");
                isOperator = true;

                tries = 0;
            } else if(tries > 1) {
                int stries = tries - 1;
                if(stries > 1) {
                    System.out.println("Access Denied, try again\n" + stries + " tries remaining");
                }else{
                    System.out.println("Access Denied, try again\n" + stries + " try remaining");
                }
                tries--;
            }
            else{
                System.out.println("Access Denied, out of tries");
                tries--;
            }
        }
        if(isOperator){
            System.out.println("What would you like to do?");
            System.out.println("1. Manage Member Records");
            System.out.println("2. Manage Provider Records");
            System.out.println("3. Backup Data");
            System.out.println("4. View Main Menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    manageMemberRecords();
                    break;
                case 2:
                    manageProviderRecords();
                    break;
                case 3:
                    backupData();
                    break;
                case 4:
                    viewMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
        else{
            System.out.println("Goodbye");
        }


    }



}
