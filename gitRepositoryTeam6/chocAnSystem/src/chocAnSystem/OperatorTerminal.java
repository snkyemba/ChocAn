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

    private static void viewMainMemberMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add Member");
        System.out.println("2. Update Member");
        System.out.println("3. Delete Member");
        System.out.println("4. Exit");
    }
    private static void viewMainOperatorMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Manage Member Records");
        System.out.println("2. Manage Provider Records");
        //System.out.println("3. Backup Data");
        System.out.println("3. Exit");
    }
    private static int getMenuChoiceOperator() {
        viewMainOperatorMenu();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private static int getMenuChoiceMember() {
        viewMainMemberMenu();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void manageMemberRecords(){
        int choice = 0;
        while (choice != 4) {
            switch (choice = getMenuChoiceMember()) {
                case 1:
                    memberController.addMember();
                    break;
                case 2:
                    memberController.updateMember();
                    break;
                case 3:
                    memberController.deleteMember();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
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

            int choice = 0;
            while(choice != 3) {
                switch (choice = getMenuChoiceOperator()) {
                    case 1:
                        manageMemberRecords();
                        viewMain = false;
                        break;
                    case 2:
                        //manageProviderRecords();
                        viewMain = false;
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        break;
                }
            }
        }
        else{
            System.out.println("Goodbye");
        }


    }



}
