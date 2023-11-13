package chocAnSystem;
import java.util.Scanner;
import java.util.Vector;

// This Provider Terminal Class is by Walter Mink and Rayshaun Dunkin
public class ProviderTerminal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> providerIDs = new Vector<>();
        providerIDs.add(123456789);
        providerIDs.add(987654321);
        int tries = 5;

        System.out.println("Welcome to Provider Terminal. \nEnter your 9 digit provider ID:");
        int ID = sc.nextInt();
        while(!(providerIDs.contains(ID)) && tries > 0) {
            System.out.println("Invalid ID. Remaining attempts: " + tries);
            ID = sc.nextInt();
            tries --;
        }
        if(providerIDs.contains(ID)) {
            System.out.println("Welcome provider! Would you like to verify a member, enter a service, consult the provider directory, or exit?");
            System.out.println("Enter 1 for Member Verification\nEnter 2 for Service Entry\nEnter 3 for Provider Directory\nEnter 4 to Exit");
            int choice = sc.nextInt();
            if(choice == 1) {
                //enter service
            } else if(choice == 2) {

            } else if (choice == 3) {

            } else if (choice == 4) {

            } else {
                System.out.println("Invalid choice. Goodbye!");
            }
        }
    }
    public void enterService() {

    }
}