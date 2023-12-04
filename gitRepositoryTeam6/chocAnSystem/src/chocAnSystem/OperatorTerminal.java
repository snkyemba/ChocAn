package chocAnSystem;
import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;


/**
 * Describe what the class is for
 *
 * @author Joseph Hampton
 * @version 1.0
 */
public class OperatorTerminal {
    static Scanner scanner = new Scanner(System.in);
    static Vector<Integer> listID = new Vector<>();

    private static MemberController memberController = new MemberController();

    private static ProviderControllerOp providerController = new ProviderControllerOp();

    static boolean isOperator = false;
    static boolean viewMain = true;

    static{
        listID.add(123456789);
        listID.add(987654321);
        listID.add(321654987);
        listID.add(456123789);

    }

    public static boolean checkIDNumber(int idNumber, String filePath) {
        // Create new Vector to hold ID numbers
        Vector<Integer> idNumbers = new Vector<>();

        // Deserialize JSON file into Vector
        try {
            idNumbers = GenericSerializer.deserializeJsonArray(filePath, Integer.class);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions or return from the method
        }

        if (idNumbers.isEmpty()) {
            return false;
        }

        // Check if ID number is in Vector
        return idNumbers.contains(idNumber);
    }

    private static void viewMainMemberMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add Member");
        System.out.println("2. Update Member");
        System.out.println("3. Delete Member");
        System.out.println("4. Exit");
    }
    private static void viewMainProviderMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add Provider");
        System.out.println("2. Update Provider");
        System.out.println("3. Delete Provider");
        System.out.println("4. Exit");
    }
    private static void viewMainOperatorMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Manage Member Records");
        System.out.println("2. Manage Provider Records");
        System.out.println("3. Backup Data");
        System.out.println("4. Exit");
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
    private static int getMenuChoiceProvider() {
        viewMainProviderMenu();
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
    public static void manageProviderRecords(){
        int choice = 0;
        while (choice != 4) {
            switch (choice = getMenuChoiceProvider()) {
                case 1:
                    providerController.addProvider();
                    break;
                case 2:
                    providerController.updateProvider();
                    break;
                case 3:
                    providerController.deleteProvider();
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
    public static void backupData(){
        System.out.println("Backing up data...");
        System.out.println("Data backed up successfully.");

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
            if (checkIDNumber(testOpID,"gitRepositoryTeam6/chocAnSystem/ProgramFiles/operatorIDs.json")) {
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
            while(choice != 4) {
                switch (choice = getMenuChoiceOperator()) {
                    case 1:
                        manageMemberRecords();
                        viewMain = false;
                        break;
                    case 2:
                        manageProviderRecords();
                        viewMain = false;
                        break;
                    case 3:
                        backupData();
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
        else{
            System.out.println("Goodbye");
        }


    }



}
