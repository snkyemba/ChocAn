package chocAnSystem;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ProviderControllerOp {

    ProviderRecord providerRecord = new ProviderRecord();
    Vector<ProviderRecord> providerRecordVector = new Vector<>();
    OperatorTerminal operatorTerminal = new OperatorTerminal();

    static Scanner scanner = new Scanner(System.in);

    public void ProviderControllerOp(ProviderRecord providerRecord, OperatorTerminal operatorTerminal) {
        this.providerRecord = providerRecord;
        this.operatorTerminal = operatorTerminal;
    }
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
        GenericSerializer.processJsonFile("providerFile.json", providerRecord);
        System.out.println("Provider added successfully");
        operatorTerminal.viewMainMenu();
    }

    public void updateProvider() {
        System.out.println("Enter provider name to change: ");
        String name = scanner.nextLine();
        System.out.println("Enter aspect to change: ");
        String aspect = scanner.nextLine();
        System.out.println("Enter new value: ");
        String newValue = scanner.nextLine();
        //search the json file for the name
        try{
            providerRecordVector = GenericSerializer.deserializeJsonArray("providerFile.json", ProviderRecord.class);
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
            GenericSerializer.serializeJsonArray(providerRecordVector,"providerFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Provider updated successfully");
    }

    public void deleteProvider() {
        System.out.println("Enter provider name to delete: ");
        String name = scanner.nextLine();

        try{
            GenericSerializer.deserializeJsonArray("providerFile.json", ProviderRecord.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < providerRecordVector.size(); i++) {
            if (providerRecordVector.get(i).getName().equals(name)) {
                providerRecordVector.remove(i);
            }
        }
        try{
            GenericSerializer.serializeJsonArray(providerRecordVector,"providerFile.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Provider deleted successfully");
    }
}
