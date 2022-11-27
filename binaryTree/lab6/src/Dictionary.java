import java.util.Scanner;

/**
 * A Dictionary App that can add, delete or modify records.
 * Based on BinarySearchTree.
 */
public class Dictionary {
    private final BinarySearchTree<String, Data> bst = new BinarySearchTree<>();
    private final Scanner scanner = new Scanner(System.in);
    private static final String art = "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢛⣬⣷⣝⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⢠⣿⣿⣿⣿⢾⣏⣵⣞⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠳⠿⠿⠟⠃⢐⢾⣿⡿⣻⣿⣿⡯⣿⣿⣼⡛⠛⠿⠷⠟⠿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣾⣽⣡⣾⣿⣧⣥⣷⡟⡴⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠙⠛⠛⠛⠋⠙⠁⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣂⠤⠤⣄⡀⠀⠀⠀⠀⠀⢀⣠⡴⣶⢞⣒⠒⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⢀⡔⣭⠖⠊⠁⠐⠫⣝⢶⣷⣾⣛⡯⠛⠉⠉⠛⠯⣟⣦⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⡜⡜⠁⠀⠀⠀⠀⠀⠈⢪⢿⣡⠏⠀⠀⠀⠀⠀⠀⠈⣿⣇⠀⠀⠄⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⢹⡇⠀⠀⠀⢠⣾⣏⣷⣦⡿⣏⣾⣏⣹⣶⠀⠀⠀⠀⣼⡯⠇⠈⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠈⣶⡀⠀⠀⠸⢟⡿⣟⣽⣯⣽⡟⡿⢿⠻⠁⠀⢀⣴⣿⢃⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠙⢷⡤⣀⡀⢈⣡⣽⣿⡿⢯⣷⣅⣈⠀⢀⣀⣼⡿⣋⠈⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⠿⠙⠁⠉⠈⠙⠋⠀⠀⠄⠀⠀⠉⠟⠿⠿⠿⠛⠉⠀⠀⠙⠻⠿⠿⠿⠿⠏⠓⠐⠺⠀⠘⠛⠉⠁⠉⢙⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣃⠁⠈⠁⠐⠂⠂⠤⠤⡀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⢠⠠⠤⣤⡴⠲⠄⠊⠉⠁⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣀⠀⢀⣀⣀⠀⠀⠀⠉⢉⠀⠀⠀⠀⠀⠄⠂⠄⠰⠀⣀⣀⣀⣀⠍⠁⠀⠀⠀⠀⠀⠀⢀⣠⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n";

    /**
     * Run the application.
     */
    public void run() {
        System.out.println(art);
        Integer choice;
        do {
            choice = 0;
            displayMenu();
            while (choice < 1 || choice > 6) {
                choice = readInteger("");
                if (choice == null) {
                    choice = 0;
                }
                switch (choice) {
                    case 1: Add(); break;
                    case 2: Delete(); break;
                    case 3: Modify(); break;
                    case 4: Lookup(); break;
                    case 5: System.out.println(bst.getSize()); break;
                    case 6: break;
                    default: System.out.println("Please enter a number between 1 and 6."); break;
                }
            }
        } while (choice != 6);
    }

    /**
     * Display the application menu.
     */
    private void displayMenu() {
        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. Modify");
        System.out.println("4. Lookup");
        System.out.println("5. List number of records");
        System.out.println("6. Exit");
    }

    /**
     * Read a Long from user's inputs.
     * @param help prompt string.
     * @return The Long just read.
     */
    private Long readLong(String help) {
        System.out.print(help);
        while (scanner.hasNextLine()) {
            if (scanner.hasNextLong()) {
                long ret = scanner.nextLong();
                scanner.nextLine();
                return ret;
            } else {
                scanner.nextLine();
                System.out.print(help);
            }
        }
        return null;
    }

    /**
     * Read an Integer from user's inputs.
     * @param help prompt string.
     * @return The Integer just read.
     */
    private Integer readInteger(String help) {
        System.out.print(help);
        while (scanner.hasNextLine()) {
            if (scanner.hasNextInt()) {
                int ret = scanner.nextInt();
                scanner.nextLine();
                return ret;
            } else {
                scanner.nextLine();
                System.out.print(help);
            }
        }
        return null;
    }

    /**
     * Read a string from user's inputs.
     * @param help prompt string.
     * @return The string just read.
     */
    private String readString(String help) {
        System.out.print(help);
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }

    /**
     * Add a new record to the Dictionary.
     */
    private void Add() {
        do {
            Integer zip;
            Long phoneNumber;
            String ID, firstName, lastName, streetAddress, city, state, email;
            ID = readString("Please enter ID Number: ");
            firstName = readString("Please enter first name: ");
            lastName = readString("Please enter last name: ");
            streetAddress = readString("Please enter street address: ");
            city = readString("Please enter city: ");
            state = readString("Please enter state: ");
            zip = readInteger("Please enter zip code: ");
            email = readString("Please enter email: ");
            phoneNumber = readLong("Please enter phone number: ");
            Data data = new Data(firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
            System.out.println("Please confirm the data that you want to add: ");
            System.out.println(data);
            String choice = readString("Do you want to add it to dictionary? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                bst.insert(ID, data);
                break;
            } else {
                choice = readString("Do you want to enter again or back to menu? (e/b)");
                if (choice != null && (choice.compareTo("e") != 0 || choice.compareTo("E") == 0)) {
                    break;
                }
            }
        } while (true);
    }

    /**
     * Delete a record from the Dictionary.
     */
    private void Delete() {
        while (true) {
            String ID;
            String choice;
            Node<String, Data> node;
            while (true) {
                ID = readString("Please enter the ID number of the data that you want to delete: ");
                node = bst.search(ID);
                if (node == null) {
                    choice = readString("Invalid ID number. Do you want to enter again or back to menu? (e/b) ");
                    if (choice == null || choice.compareTo("e") != 0 && choice.compareTo("E") != 0) {
                        ID = null;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (ID == null) {
                break;
            }
            if (node == null) {
                continue;
            }
            System.out.println("Please confirm the data that you want to delete: ");
            System.out.println("ID: " + ID + ", " + node.getValue());
            choice = readString("Do you want to delete it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                bst.delete(ID);
                break;
            } else {
                choice = readString("Do you want to enter again or back to menu? (e/b)");
                if (choice == null || choice.compareTo("e") != 0 && choice.compareTo("E") != 0) {
                    break;
                }
            }
        }
    }


    /**
     * Modify a record in the Dictionary.
     */
    private void Modify() {
        while (true) {
            String ID, newID = null;
            String choice;
            Node<String, Data> node;
            while (true) {
                ID = readString("Please enter the ID number of the data that you want to modify: ");
                node = bst.search(ID);
                if (node == null) {
                    choice = readString("Invalid ID number. Do you want to enter again or back to menu? (e/b)");
                    if (choice == null || choice.compareTo("e") != 0 && choice.compareTo("E") != 0) {
                        ID = null;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (ID == null) {
                break;
            }
            if (node == null) {
                continue;
            }
            Data data = node.getValue();
            choice = readString("ID: " + ID + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                newID = readString("Please enter new ID: ");
            }
            choice = readString("First Name: " + data.getFirstName() + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                data.setFirstName(readString("Please enter new First Name: "));
            }
            choice = readString("Last Name: " + data.getLastName() + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                data.setLastName(readString("Please enter new Last Name: "));
            }
            choice = readString("Street Address: " + data.getStreetAddress() + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                data.setStreetAddress(readString("Please enter new Street Address: "));
            }
            choice = readString("City: " + data.getCity() + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                data.setCity(readString("Please enter new City: "));
            }
            choice = readString("State: " + data.getState() + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                data.setState(readString("Please enter new State: "));
            }
            choice = readString("Zip Code: " + data.getZip() + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                data.setZip(readInteger("Please enter new Zip Code: "));
            }
            choice = readString("Email: " + data.getEmail() + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                data.setEmail(readString("Please enter new Email: "));
            }
            choice = readString("Phone Number: " + data.getPhoneNumber() + ". Do you want to modify it? (y/n) ");
            if (choice != null && (choice.compareTo("y") == 0 || choice.compareTo("Y") == 0)) {
                data.setPhoneNumber(readLong("Please enter new Phone Number: "));
            }
            if (newID != null) {
                bst.insert(newID, data);
                bst.delete(ID);
            }
            break;
        }
    }


    /**
     * Lookup the Dictionary.
     */
    private void Lookup() {
        System.out.println("1. pre-order");
        System.out.println("2. in-order");
        System.out.println("3. post-order");
        System.out.println("4. back");
        Integer choice = 0;
        while (choice < 1 || choice > 4) {
            choice = readInteger("");
            if (choice == null) {
                choice = 0;
            }
            if (choice == 4) {
                break;
            }
            switch (choice) {
                case 1: bst.Lookup(Order.PreOrder); break;
                case 2: bst.Lookup(Order.InOrder); break;
                case 3: bst.Lookup(Order.PostOrder); break;
                default: System.out.println("Please enter a number between 1 to 3."); break;
            }
        }
    }
}
