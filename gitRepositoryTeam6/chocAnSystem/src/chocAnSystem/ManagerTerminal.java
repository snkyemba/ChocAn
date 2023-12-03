package chocAnSystem;
import java.util.Scanner;
import java.util.Vector;

/** This class is by Sophia Kyemba. */
public class ManagerTerminal {

    private Scanner sc;
    private Vector<Integer> managerIDs;
    private ReportController reportController;
    private int intInput;

    public ManagerTerminal() {
        this.sc = new Scanner(System.in);
        this.managerIDs = new Vector<>();
        this.managerIDs.add(123456789);
        this.managerIDs.add(987654321);
        this.reportController = new ReportController();
    }
    public void giveInput(String input){
        intInput = Integer.parseInt(input);
    }
    public Vector<Integer> getManagerIDs() {
        return managerIDs;
    }
	public static void main(String[] args) {
		ManagerTerminal managerTerminal = new ManagerTerminal();
		managerTerminal.startManagerTerminal();
	}
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