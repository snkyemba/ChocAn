package chocAnSystem;
import java.util.Scanner;
import java.util.Vector;

/**
 * Class for Controlling the logic for the Manager Terminal
 *
 * @author Sophia Kyemba
 * @version 1.0
 */
public class ManagerTerminal {

    private Scanner sc;
    private Vector<Integer> managerIDs;
    private ReportController reportController;
    private int intInput;

    /**
     * Constructor for ManagerTerminal
     *
     */
    public ManagerTerminal() {
        this.sc = new Scanner(System.in);
        this.managerIDs = new Vector<>();
        this.managerIDs.add(123456789);
        this.managerIDs.add(987654321);
        this.reportController = new ReportController();
    }

    /**
     * Function to give input to the Manager Terminal
     *
     * @param input Input to be given to the Manager Terminal
     */
    public void giveInput(String input){
        intInput = Integer.parseInt(input);
    }

    /**
     * Function to get the manager IDs
     *
     * @return Vector of manager IDs
     */
    public Vector<Integer> getManagerIDs() {
        return managerIDs;
    }

    /**
     * Function to run the Manager Terminal in the console
     *
     */
	public static void main(String[] args) {
		ManagerTerminal managerTerminal = new ManagerTerminal();
		managerTerminal.startManagerTerminal();
	}

    /**
     * Function to start the Manager Terminal
     *
     */
    public void startManagerTerminal() {
        //int tries = 5;
        System.out.println("Welcome to Manager Terminal. \nEnter your 9-digit manager ID:");
        int ID = intInput;

        /*while (!(managerIDs.contains(ID)) && tries > 0) {
            System.out.println("Invalid ID. Remaining attempts: " + tries);
            ID = intInput;
            tries--;
        }*/
        if (managerIDs.contains(ID)) {
            System.out.println("Welcome manager! Which report would you like to request?");
            System.out.println("Enter 1 for Member Report, 2 for Provider Report, "
                    + "and 3 for Manager Report.");

            int reportChoice = sc.nextInt();
            requestReport(reportChoice);
        }
    }

    /**
     * Function to get the menu choice for the Manager Terminal
     *
     * @param reportChoice Choice of report to be requested
     */
    void requestReport(int reportChoice){
        switch (reportChoice) {
            case 1:
                reportController.generateMemberReport();
                break;
            case 2:
                reportController.generateProviderReport();
                break;
            case 3:
                reportController.generateManagerReport();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
        }
    }
}