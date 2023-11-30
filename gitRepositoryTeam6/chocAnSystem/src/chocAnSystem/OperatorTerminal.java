package chocAnSystem;
import java.util.Vector;
import java.util.Scanner;



public class OperatorTerminal {
    static Scanner scanner = new Scanner(System.in);
    static Vector<Integer> listID = new Vector<>();

    private static MemberController memberController = new MemberController();

    static boolean isOperator = false;
    static boolean viewMain = true;

    static{
        listID.add(123456789);
        listID.add(987654321);
        listID.add(321654987);
        listID.add(456123789);

    }


    public static void manageMemberRecords(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add Member");
        System.out.println("2. Update Member");
        System.out.println("3. Delete Member");
        int choice = Integer.parseInt(scanner.nextLine());
        switch(choice){
            case 1:
                memberController.addMember();
                break;
            case 2:
                memberController.updateMember();
                break;
            case 3:
                memberController.deleteMember();
                break;
            default:
                System.out.println("Invalid choice, please try again");
                break;
        }


    }
    public void manageProviderRecords(){

    }
    public void backupData(){

    }
    public void viewMainMenu(){
        viewMain = true;
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
        if(isOperator && viewMain){
            System.out.println("What would you like to do?");
            System.out.println("1. Manage Member Records");
            System.out.println("2. Manage Provider Records");
            System.out.println("3. Backup Data");
            System.out.println("4. View Main Menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    manageMemberRecords();
                    viewMain = false;
                    break;
                case 2:
                    //manageProviderRecords();
                    viewMain = false;
                    break;
                case 3:
                    //backupData();
                    viewMain = false;
                    break;
                case 4:
                    viewMain = true;
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
