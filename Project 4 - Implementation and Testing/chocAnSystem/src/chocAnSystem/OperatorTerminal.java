package chocAnSystem;
import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;


/**
 * Class for Controlling the logic for the Operator Terminal
 *
 * @author Joseph Hampton
 * @version 1.0
 */
public class OperatorTerminal {
    static Scanner scanner = new Scanner(System.in);

    private static MemberController memberController = new MemberController();

    private static ProviderControllerOp providerController = new ProviderControllerOp();

    static boolean isOperator = false;
    static boolean viewMain = true;


    /**
     * Function to check if ID number is in JSON file
     *
     * @param idNumber ID number to be checked
     * @param filePath Path to JSON file to be read from
     * @return Boolean value indicating whether ID number is in JSON file
     */
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

    /**
     * Function to print out the main menu for the Member Terminal
     */
    private static void viewMainMemberMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add Member");
        System.out.println("2. Update Member");
        System.out.println("3. Delete Member");
        System.out.println("4. Exit");
    }
    /**
     * Function to print out the main menu for the Provider Terminal
     */
    private static void viewMainProviderMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Add Provider");
        System.out.println("2. Update Provider");
        System.out.println("3. Delete Provider");
        System.out.println("4. Exit");
    }/**
     * Function to print out the main menu for the Operator Terminal
     */
    private static void viewMainOperatorMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Manage Member Records");
        System.out.println("2. Manage Provider Records");
        System.out.println("3. Backup Data");
        System.out.println("4. Exit");
    }
    /**
     * Function to read in the user's choice from the main menu for Operator
     * @return int value of the user's choice
     */
    private static int getMenuChoiceOperator() {
        viewMainOperatorMenu();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    /**
     * Function to read in the user's choice from the main menu for Member
     * @return int value of the user's choice
     */
    private static int getMenuChoiceMember() {
        viewMainMemberMenu();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    /**
     * Function to read in the user's choice from the main menu for Provider
     * @return int value of the user's choice
     */
    private static int getMenuChoiceProvider() {
        viewMainProviderMenu();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    /**
     * Function to control the logic of the Member Terminal in a switch statement
     */
    public static void manageMemberRecords(){
        int choice = 0;
        while (choice != 4) {
            switch (choice = getMenuChoiceMember()) {
                case 1:
                    //add member
                    memberController.addMember();
                    break;
                case 2:
                    //update member
                    memberController.updateMember();
                    break;
                case 3:
                    //delete member
                    memberController.deleteMember();
                    break;
                case 4:
                    //exit
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }


    }
    /**
     * Function to control the logic of the Provider Terminal in a switch statement
     */
    public static void manageProviderRecords(){
        int choice = 0;
        while (choice != 4) {
            switch (choice = getMenuChoiceProvider()) {
                case 1:
                    //add provider
                    providerController.addProvider();
                    break;
                case 2:
                    //update provider
                    providerController.updateProvider();
                    break;
                case 3:
                    //delete provider
                    providerController.deleteProvider();
                    break;
                case 4:
                    //exit
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }

    }
    /**
     * Function to backup data
     */
    public static void backupData(){
        System.out.println("Backing up data...");
        System.out.println("Data backed up successfully.");

    }
    /**
     * Function to view the main menu, used for testing
     */
    public void viewMainMenu(){
        viewMain = true;
    }


    /**
     * Function to run the Operator Terminal
     * @param args
     */
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
