package chocAnSystem;

import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;
import java.net.URL;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Class for controlling logic for Provider Terminal
 *
 * @author Walter Mink, Rayshaun Dunkin
 * @version 1.0
 */
public class ProviderTerminal {
    /**
     * Main method for Provider Terminal
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProviderController controller = new ProviderController();
        providerVerify(sc, controller);
        mainMenu(sc, controller);
    }

    /**
     * Method to scan for valid integer length
     *
     * @param sc Scanner object
     * @param length Length of integer to be scanned
     * @return Valid integer
     */
    public static int scanValidIntLength(Scanner sc, int length) {
        int input;
        while (true) {
            input = sc.nextInt();
            sc.nextLine(); // consume the remaining newline
            if (Integer.toString(input).length() != length) {
                System.out.println("Invalid input. Please enter a " + length + " digit number.");
            } else {
                break;
            }
        }
        return input;
    }

    /**
     * Method to scan for valid string length
     *
     * @param sc Scanner object
     * @param length Length of string to be scanned
     * @return Valid string
     */
    public static String scanValidStringLength(Scanner sc, int length) {
        String input;
        while (true) {
            input = sc.nextLine();
            sc.nextLine(); // consume the remaining newline
            if (input.length() > length) {
                System.out.println("Invalid input. Please enter a string less than " + length + " characters.");
            } else {
                break;
            }
        }
        return input;
    }

    /**
     * Method to verify provider ID
     *
     * @param sc Scanner object
     * @param controller ProviderController object
     * @return Valid provider ID
     */
    public static int providerVerify(Scanner sc, ProviderController controller) {
        int ID;

        while (true) {
            System.out.println("Welcome to Provider Terminal. \nEnter your 9 digit provider ID:");
            ID = scanValidIntLength(sc, 9);

            // Validate ID
            if (controller.checkIDNumber(ID, "Project s4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerIDs.json")) {
                System.out.println("Verification Successful.");
                break;
            } else {
                System.out.println("Invalid ID number. Please enter a valid ID.");
            }
        }
        return ID;
    }
    public boolean providerVerify(int ID, ProviderController controller) {
        // Validate ID
        if (controller.checkIDNumber(ID, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerIDs.json")) {
            System.out.println("Verification Successful.");
            return true;
        } else {
            System.out.println("Invalid ID number. Please enter a valid ID.");
            return false;
        }
    }

    /**
     * Method to search provider directory
     *
     * @param sc Scanner object
     * @param controller ProviderController object
     */
    public static void providerDirectorySearch(Scanner sc, ProviderController controller) {
        int choice;

        // Display search options
        System.out.println("""
                Would you like to:
                1. Search by Service Code
                2. Search by Service Name
                3. View all Services
                4. Return to Main Menu""");

        // Get user choice
        choice = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        switch (choice) {
            // Search by service code
            case 1:
                int serviceCode;
                System.out.println("Enter the Six Digit Service Code you would like to search for:");
                serviceCode = scanValidIntLength(sc, 6);

                Optional<ProviderDirectory> serviceByCode = controller.searchServiceCode(serviceCode, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerDirectory.json");
                if (serviceByCode.isPresent()) {
                    System.out.println("Service Code: " + serviceByCode.get().getServiceCode() + "\n" +
                            "Service Name: " + serviceByCode.get().getServiceName() + "\n" +
                            "Service Fee: " + serviceByCode.get().getServiceFee());
                } else {
                    System.out.println("Service Code not found. Please enter a valid Service Code.");
                    providerDirectorySearch(sc, controller);
                }
                break;

            // Search by service name
            case 2:
                System.out.println("Enter the Service Name you would like to search for:");
                String serviceName = scanValidStringLength(sc, 20);

                Optional<ProviderDirectory> serviceByName = controller.searchServiceName(serviceName, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerDirectory.json");
                if (serviceByName.isPresent()) {
                    System.out.println("Service Code: " + serviceByName.get().getServiceCode() + "\n" +
                            "Service Name: " + serviceByName.get().getServiceName() + "\n" +
                            "Service Fee: " + serviceByName.get().getServiceFee());
                } else {
                    System.out.println("Service Name not found. Please enter a valid Service Name.");
                    providerDirectorySearch(sc, controller);
                }
                break;

            // View all services
            case 3:
                Vector<ProviderDirectory> serviceTypes;
                serviceTypes = controller.getServiceTypes("Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerDirectory.json");

                for (ProviderDirectory entry : serviceTypes) {
                    System.out.println("Service Code: " + entry.getServiceCode() + "\n" +
                            "Service Name: " + entry.getServiceName() + "\n" +
                            "Service Fee: " + entry.getServiceFee() + "\n");
                }
                break;

            // Return to main menu
            case 4:
                System.out.println("Returning to Main Menu...");
                break;

            default:
                System.out.println("Invalid choice. Please enter a valid choice.");
                providerDirectorySearch(sc, controller);
        }
    }

    /**
     * Method to log a service
     *
     * @param sc Scanner object
     * @param controller ProviderController object
     */
    public static void logService(Scanner sc, ProviderController controller) {
        // Get member ID
        int memberID;
        loop: while (true) {
            System.out.println("Enter the Nine Digit Member ID of the Member you would like to log a service for:");
            memberID = scanValidIntLength(sc, 9);

            // Validate member ID
            if (!controller.checkIDNumber(memberID, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/memberIDs.json")) {
                System.out.println("Invalid Member ID. Please enter a valid Member ID.");
            } else {
                // Double check member ID
                System.out.println("Is this the correct Member? 1 for yes, 2 for no.\n" +
                        "Member ID: " + memberID);
                int choice = sc.nextInt();
                sc.nextLine(); // consume the remaining newline
                switch (choice) {
                    case 1:
                        System.out.println("Member Verified.");
                        break loop;
                    case 2:
                        System.out.println("Please enter the correct Member ID.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }
                break;
            }
        }

        // Get service code
        int serviceCode;
        loop: while (true) {
            System.out.println("Enter the Service Code of the Service you would like to log:");
            serviceCode = scanValidIntLength(sc, 6);

            // Validate service code
            Optional<ProviderDirectory> serviceByCode = controller.searchServiceCode(serviceCode, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerDirectory.json");
            if (serviceByCode.isPresent()) {
                // Double check service code
                System.out.println("Is this the correct Service? 1 for yes, 2 for no.\n" +
                        "Service Code: " + serviceByCode.get().getServiceCode() + "\n" +
                        "Service Name: " + serviceByCode.get().getServiceName() + "\n" +
                        "Service Fee: " + serviceByCode.get().getServiceFee());
                int choice = sc.nextInt();
                sc.nextLine(); // consume the remaining newline
                switch (choice) {
                    case 1:
                        System.out.println("Service Code Verified.");
                        break loop;
                    case 2:
                        System.out.println("Please enter the correct Service Code.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }
            } else {
                System.out.println("Service Code not found. Please enter a valid Service Code.");
            }
        }

        // Get service date
        String serviceDate;
        loop: while (true) {
            System.out.println("Enter the Date of Service in the format MM-DD-YYYY:");
            serviceDate = scanValidStringLength(sc, 10);

            // Double check service date
            System.out.println("Is this the correct Date? 1 for yes, 2 for no.\n" +
                    "Date: " + serviceDate);
            int choice = sc.nextInt();
            sc.nextLine(); // consume the remaining newline
            switch (choice) {
                case 1:
                    System.out.println("Date Verified.");
                    break loop;
                case 2:
                    System.out.println("Please enter the correct Date.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }

        // Get comments
        String comments;
        loop: while (true) {
            System.out.println("Enter any Comments you would like to add:");
            comments = scanValidStringLength(sc, 100);

            // Double check comments
            System.out.println("Is this the correct Comment? 1 for yes, 2 for no.\n" +
                    "Comment: " + comments);
            int choice = sc.nextInt();
            sc.nextLine(); // consume the remaining newline
            switch (choice) {
                case 1:
                    System.out.println("Comment Verified.");
                    break loop;
                case 2:
                    System.out.println("Please enter the correct Comment.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }

        // Save service record
        controller.saveServiceRecord(serviceDate, providerVerify(sc, controller), memberID, serviceCode, comments, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/serviceRecords.json");
    }

    /**
     * Method to add member ID
     *
     * @param sc Scanner object
     * @param controller ProviderController object
     */
    public static void addMemberID(Scanner sc, ProviderController controller) {
        int memberID;

        // Get member ID
        loop: while (true) {
            System.out.println("Enter the Nine Digit Member ID you would like to add:");
            memberID = scanValidIntLength(sc, 9);

            // Validate member ID
            if (controller.checkIDNumber(memberID, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/memberIDs.json")) {
                System.out.println("Member ID already exists. Please enter a valid Member ID.");
            } else {
                // Double check member ID
                System.out.println("Is this the correct Member? 1 for yes, 2 for no.\n" +
                        "Member ID: " + memberID);
                int choice = sc.nextInt();
                sc.nextLine(); // consume the remaining newline
                switch (choice) {
                    case 1:
                        System.out.println("Member Verified.");
                        break loop;
                    case 2:
                        System.out.println("Please enter the correct Member ID.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }
            }
        }

        // Save member ID
        controller.saveIDNumber(memberID, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/memberIDs.json");
    }

    /**
     * Method to add provider ID
     *
     * @param sc Scanner object
     * @param controller ProviderController object
     */
    public static void addProviderID(Scanner sc, ProviderController controller) {
        int providerID;

        // Get provider ID
        loop: while (true) {
            System.out.println("Enter the Nine Digit Provider ID you would like to add:");
            providerID = scanValidIntLength(sc, 9);

            // Validate provider ID

            if (controller.checkIDNumber(providerID, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerIDs.json")) {
                System.out.println("Provider ID already exists. Please enter a valid Provider ID.");
            } else {
                // Double check provider ID
                System.out.println("Is this the correct Provider? 1 for yes, 2 for no.\n" +
                        "Provider ID: " + providerID);
                int choice = sc.nextInt();
                sc.nextLine(); // consume the remaining newline
                switch (choice) {
                    case 1:
                        System.out.println("Provider Verified.");
                        break loop;
                    case 2:
                        System.out.println("Please enter the correct Provider ID.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }
            }
        }

        // Save provider ID
        controller.saveIDNumber(providerID, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerIDs.json");
    }

    /**
     * Method to add provider directory entry
     *
     * @param sc Scanner object
     * @param controller ProviderController object
     */
    public static void addProviderDirectoryEntry(Scanner sc, ProviderController controller) {
        int serviceCode;
        String serviceName;
        float serviceFee;

        // Get service code
        loop: while (true) {
            System.out.println("Enter the Six Digit Service Code you would like to add:");
            serviceCode = scanValidIntLength(sc, 6);

            // Validate service code
            if (controller.searchServiceCode(serviceCode, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerDirectory.json").isPresent()) {
                System.out.println("Service Code already exists. Please enter a valid Service Code.");
            } else {
                // Double check service code
                System.out.println("Is this the correct Service? 1 for yes, 2 for no.\n" +
                        "Service Code: " + serviceCode);
                int choice = sc.nextInt();
                sc.nextLine(); // consume the remaining newline
                switch (choice) {
                    case 1:
                        System.out.println("Service Code Verified.");
                        break loop;
                    case 2:
                        System.out.println("Please enter the correct Service Code.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }
            }
        }

        // Get service name
        loop: while (true) {
            System.out.println("Enter the Service Name you would like to add:");
            serviceName = scanValidStringLength(sc, 20);

            // Double check service name
            System.out.println("Is this the correct Service Name? 1 for yes, 2 for no.\n" +
                    "Service Name: " + serviceName);
            int choice = sc.nextInt();
            sc.nextLine(); // consume the remaining newline
            switch (choice) {
                case 1:
                    System.out.println("Service Name Verified.");
                    break loop;
                case 2:
                    System.out.println("Please enter the correct Service Name.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }

        // Get service fee
        loop: while (true) {
            System.out.println("Enter the Service Fee you would like to add:");
            serviceFee = sc.nextFloat();
            sc.nextLine(); // consume the remaining newline

            // Validate service fee
            if (serviceFee < 0) {
                System.out.println("Invalid Service Fee. Please enter a valid Service Fee.");
            } else {
                // Double check service fee
                System.out.println("Is this the correct Service Fee? 1 for yes, 2 for no.\n" +
                        "Service Fee: " + serviceFee);
                int choice = sc.nextInt();
                sc.nextLine(); // consume the remaining newline
                switch (choice) {
                    case 1:
                        System.out.println("Service Fee Verified.");
                        break loop;
                    case 2:
                        System.out.println("Please enter the correct Service Fee.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }
            }
        }

        // Save provider directory entry
        controller.saveServiceType(serviceCode, serviceName, serviceFee, "Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/providerDirectory.json");
    }

    /**
     * Method to print all service records
     *
     * @param controller ProviderController object
     */
    public static void printAllServiceRecords(ProviderController controller) {
        Vector<ServiceRecord> serviceRecords;
        serviceRecords = controller.getServiceRecords("Project 4 - Implementation and Testing/chocAnSystem/ProgramFiles/serviceRecords.json");

        // Print all service records
        for (ServiceRecord record : serviceRecords) {
            System.out.println("Date of Service: " + record.getServiceDate() + "\n" +
                    "Provider Number: " + record.getProviderNumber() + "\n" +
                    "Member Number: " + record.getMemberNumber() + "\n" +
                    "Service Code: " + record.getServiceCode() + "\n" +
                    "Comments: " + record.getComments() + "\n");
        }
    }

    /**
     * Method to display main menu
     *
     * @param sc Scanner object
     * @param controller ProviderController object
     */
    public static void mainMenu(Scanner sc, ProviderController controller) {
        System.out.println("""
                What would you like to do?
                1. Request Provider Directory
                2. Log a Service
                3. Developer Options
                4. Exit""");

        int choice = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        switch (choice) {
            case 1:
                providerDirectorySearch(sc, controller);
                mainMenu(sc, controller);
                break;
            case 2:
                logService(sc, controller);
                mainMenu(sc, controller);
                break;
            case 3:
                developerOptions(sc, controller);
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid choice.");
                mainMenu(sc, controller);
        }
    }

    /**
     * Method to display developer options
     *
     * @param sc Scanner object
     * @param controller ProviderController object
     */
    public static void developerOptions(Scanner sc, ProviderController controller) {
        System.out.println("""
                What would you like to do?
                1. Add Member ID
                2. Add Provider ID
                3. Add Provider Directory Entry
                4. Print all Service Records
                5. Return to Main Menu""");

        int choice = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        switch (choice) {
            case 1:
                addMemberID(sc, controller);
                developerOptions(sc, controller);
                break;
            case 2:
                addProviderID(sc, controller);
                developerOptions(sc, controller);
                break;
            case 3:
                addProviderDirectoryEntry(sc, controller);
                developerOptions(sc, controller);
                break;
            case 4:
                printAllServiceRecords(controller);
                developerOptions(sc, controller);
                break;
            case 5:
                System.out.println("Returning to Main Menu...");
                mainMenu(sc, controller);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid choice.");
                developerOptions(sc, controller);
        }
    }
}