package chocAnSystem;
import java.util.Scanner;
import java.util.Vector;

/** This Manager Terminal class is by Sophia Kyemba.*/
public class ManagerTerminal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector<Integer> managerIDs = new Vector<>();
		managerIDs.add(123456789);
		managerIDs.add(987654321);
		int tries = 5;
		
		System.out.println("Welcome to Manager Terminal. \nEnter your 9 digit manager ID:");
		int ID = sc.nextInt();
		while(!(managerIDs.contains(ID)) && tries > 0) {
			System.out.println("Invalid ID. Remaining attempts: " + tries);
			ID = sc.nextInt();
			tries --;
		}
		if(managerIDs.contains(ID)) {
			System.out.println("Welcome manager! Which report would you like to request?");
			System.out.println("Enter 1 for Member Report, 2 for Provider Report, "
								+ "and 3 for Manager Report.");
		}
		
	}
	public void requestReport() {
		
	}
}
