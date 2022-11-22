import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    //set up main menu.
    public static void printMainMenu() {
        System.out.println("Main Menu: ");
        System.out.println("1: Add");
        System.out.println("2: Modify");
        System.out.println("3: Delete");
        System.out.println("4: Sort PhoneBook");
        System.out.println("5: Display PhoneBook Entries");
        System.out.println("6: Exit");
        System.out.println("Enter your choice (1-6): ");
    }

    //The add function of manager
    public static PhoneBookManager showAddMenu(PhoneBookManager manager) { //set up manager of the phone book.
        //New a scanner to get the input of User
        Scanner sc = new Scanner(System.in);
        //Prompts the user for input
        System.out.println("Please Enter New Entry Details:");
        System.out.println("(First name, Last Name, Phone Number, City, Address)");
        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        String phoneNumber = sc.nextLine();
        String city = sc.nextLine();
        String address = sc.nextLine();
        //Add the information to the manager ,then return the manager
        manager.addNewEntry(firstName, lastName, address, city, phoneNumber);
        return manager;
    }

    //The delete function of manager
    public static PhoneBookManager showDeleteMenu(PhoneBookManager manager) { //for delete option.
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter First Name to Delete Entry:");
        String firstName = sc.nextLine();
        manager.deleteEntry(firstName);
        return manager;
    }

    //The modify function of manager
    public static PhoneBookManager showModifyMenu(PhoneBookManager manager) { //for modify option.
        //New a Scanner to get the input of user
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter First Name to Modify Entry - ");
        String firstName = sc.nextLine();
        System.out.println("Please Enter Which Field to Modify - ");
        System.out.println("1: First Name:");
        System.out.println("2: Last Name:");
        System.out.println("3: Phone Number:");
        System.out.println("4: City:");
        System.out.println("5: Address");
        System.out.println("Enter your choice (1-5): ");
        int param = sc.nextInt();
        sc.nextLine();
        System.out.println("Please Enter The Modified Value - ");
        String val = sc.nextLine();
        manager.modifyEntry(firstName, val, param);
        return manager;
    }

    //The sort function of manager
    public static PhoneBookManager sortPhoneBook(PhoneBookManager manager) { //for sorting option.(by last name).
        System.out.println("Sorting PhoneBook by LastName");
        manager.sortPhoneBookByLastName();
        return manager;
    }

    public static void main(String[] args) { //Initial PhoneBook is empty.
        PhoneBookManager manager = new PhoneBookManager();
        Scanner sc = new Scanner(System.in);
        //Infinite loop
        while(true) { 
            printMainMenu();
            int choice = sc.nextInt();
            if(choice > 6 || choice <= 0) {
                System.out.println("\n==>> Sorry, can not understand! Please Enter A Choice Between 1-6!");
                continue;
            }

            if(choice == 1) manager = showAddMenu(manager);
            else if(choice == 2) manager = showModifyMenu(manager);
            else if(choice == 3) manager = showDeleteMenu(manager);
            else if(choice == 4) manager = sortPhoneBook(manager);
            else if(choice == 5) manager.displayPhoneBook();
            else break;//if choice==6 then we will jump out of the loop
        }

        System.out.println("\n\n-----------------------");
        System.out.println("Exiting The PhoneBook.");
        System.out.println("-----------------------");
    }
}