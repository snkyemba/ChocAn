package chocAnSystem;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
/**
 * Class for Controlling the logic for the Provider Terminal
 *
 * @author Joseph Hampton
 * @version 1.0
 */
public class ProviderControllerOp {

    ProviderRecord providerRecord = new ProviderRecord();
    Vector<ProviderRecord> providerRecordVector = new Vector<>();
    OperatorTerminal operatorTerminal = new OperatorTerminal();

    static Scanner scanner = new Scanner(System.in);

    /**
     * Function to create ProviderControllerOp object, used for testing
     * @param providerRecord ProviderRecord object
     * @param operatorTerminal OperatorTerminal object
     */
    public void ProviderControllerOp(ProviderRecord providerRecord, OperatorTerminal operatorTerminal) {
        this.providerRecord = providerRecord;
        this.operatorTerminal = operatorTerminal;
    }

    /**
     * Function to add and save provider to JSON file
     */
    public void addProvider() {
        System.out.println("Enter provider name: ");
        String name = scanner.nextLine();
        System.out.println("Enter provider number: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter provider address: ");
        String address = scanner.nextLine();
        System.out.println("Enter provider city: ");
        String city = scanner.nextLine();
        System.out.println("Enter provider state: ");
        String state = scanner.nextLine();
        System.out.println("Enter provider zip: ");
        int zip = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter provider fee: ");
        double fee = Double.parseDouble(scanner.nextLine());
        providerRecord = new ProviderRecord(name, number, address, city, state, zip, fee);
        GenericSerializer.processJsonFile("gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json", providerRecord);
        System.out.println("Provider added successfully");
        operatorTerminal.viewMainMenu();
    }

    /**
     * Function to add and save provider to JSON file from the GUI
     * @param name Name of provider
     * @param number Number of provider
     * @param address Address of provider
     * @param city City of provider
     * @param state State of provider
     * @param zip Zip code of provider
     * @param fee Fee of provider
     */
    public void addProvider(String name, int number, String address, String city, String state, int zip, double fee) {
        providerRecord = new ProviderRecord(name, number, address, city, state, zip, fee);
        GenericSerializer.processJsonFile("gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json", providerRecord);
    }

    /**
     * Function to update provider information and save it to the JSON file
     */
    public void updateProvider() {
        System.out.println("Enter provider name to change: ");
        String name = scanner.nextLine();
        System.out.println("Enter aspect to change: ");
        String aspect = scanner.nextLine();
        System.out.println("Enter new value: ");
        String newValue = scanner.nextLine();
        //search the json file for the name
        try{
            providerRecordVector = GenericSerializer.deserializeJsonArray("gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json", ProviderRecord.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < providerRecordVector.size(); i++) {
            if (providerRecordVector.get(i).getName().equals(name)) {
                if (aspect.equals("name")) {
                    providerRecord = new ProviderRecord(newValue, providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("number")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), Integer.parseInt(newValue), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("address")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), newValue, providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("city")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), newValue, providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("state")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), newValue, providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("zip")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), Integer.parseInt(newValue), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("fee")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), Double.parseDouble(newValue));
                }
                providerRecordVector.set(i, providerRecord);
            }
        }
        try{
            GenericSerializer.serializeJsonArray(providerRecordVector,"gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Provider updated successfully");
    }

    /**
     * Function to update provider information and save it to the JSON file from the GUI
     * @param provName Name of provider
     * @param provAspect Aspect of provider to change
     * @param provNewValue New value of provider
     */
    public void updateProvider(String provName, String provAspect, String provNewValue) {
        String name = provName;
        String aspect = provAspect;
        String newValue = provNewValue;
        //search the json file for the name
        try{
            providerRecordVector = GenericSerializer.deserializeJsonArray("gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json", ProviderRecord.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < providerRecordVector.size(); i++) {
            if (providerRecordVector.get(i).getName().equals(name)) {
                if (aspect.equals("name")) {
                    providerRecord = new ProviderRecord(newValue, providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("number")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), Integer.parseInt(newValue), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("address")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), newValue, providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("city")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), newValue, providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("state")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), newValue, providerRecordVector.get(i).getZip(), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("zip")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), Integer.parseInt(newValue), providerRecordVector.get(i).getFee());

                } else if (aspect.equals("fee")) {
                    providerRecord = new ProviderRecord(providerRecordVector.get(i).getName(), providerRecordVector.get(i).getNumber(), providerRecordVector.get(i).getAddress(), providerRecordVector.get(i).getCity(), providerRecordVector.get(i).getState(), providerRecordVector.get(i).getZip(), Double.parseDouble(newValue));
                }
                providerRecordVector.set(i, providerRecord);
            }
        }
        try{
            GenericSerializer.serializeJsonArray(providerRecordVector,"gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Provider updated successfully");
    }

    /**
     * Function to delete provider from JSON file
     */
    public void deleteProvider() {
        System.out.println("Enter provider name to delete: ");
        String name = scanner.nextLine();

        try{
            GenericSerializer.deserializeJsonArray("gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json", ProviderRecord.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < providerRecordVector.size(); i++) {
            if (providerRecordVector.get(i).getName().equals(name)) {
                providerRecordVector.remove(i);
            }
        }
        try{
            GenericSerializer.serializeJsonArray(providerRecordVector,"gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Provider deleted successfully");
    }

    /**
     * Function to delete provider from JSON file from the GUI
     * @param provName Name of provider
     */
    public void deleteProvider(String provName) {
        String name = provName;

        try{
            GenericSerializer.deserializeJsonArray("gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json", ProviderRecord.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < providerRecordVector.size(); i++) {
            if (providerRecordVector.get(i).getName().equals(name)) {
                providerRecordVector.remove(i);
            }
        }
        try{
            GenericSerializer.serializeJsonArray(providerRecordVector,"gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Provider deleted successfully");
    }
}
