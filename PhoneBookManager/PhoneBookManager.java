import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PhoneBookManager {
    //We use a linkedList to store the information of phone and people
    private LinkedList<Node> phoneBook;

    PhoneBookManager() { //Initial PhoneBook is empty.
        this.phoneBook = new LinkedList<>();
    }

    public boolean addNewEntry(String firstName, String lastName, String phoneNumber, String city, String address) {
        //Add a new people in the phonebook.
        return this.phoneBook.add(new Node(firstName, lastName, phoneNumber, city, address));
    }

    /**
     * @param firstName the firstName of people
     * @param val  the value that we will change
     * @param param  the index to express the change
     *               1 change firstName,
     *               2 change lastName,
     *               3 change address,
     *               4 change phoneNum,
     *               5 change address
     */
    public void modifyEntry(String firstName, String val, int param) { //modify the people by first name.
        //Travel all people of the phoneBook
        for(Node contact: this.phoneBook) {
            //If the firstName of contact equals to firstName,then we found the people that we need
            if(contact.getFirstName().equals(firstName)) {
                if(param == 1) contact.setFirstName(val);
                else if(param == 2) contact.setLastName(val);
                else if(param == 3) contact.setAddress(val);
                else if(param == 4) contact.setMobile(val);
                else if(param == 5) contact.setCity(val);
                //if the value of param is not in [1,5],we will print some message to prompt the user
                else {
                    System.out.println("Entry Modification Unsuccessful, please try again.");
                    return;
                }
                System.out.println("Entry Modified Successfully.");
                return;
            }
        }
        //If we don't find the people,that print some message to prompt the user
        System.out.println("Entry Modification Unsuccessful, please try again.");
    }

    /**
     * Delete people by first name
     * @param firstName the firstName of the people that we want to delete
     */
    public void deleteEntry(String firstName) { //Delete people by fist name.
        for(Node contact: this.phoneBook) {
            if(contact.getFirstName().equals(firstName)){
                this.phoneBook.remove(contact);
                System.out.println("Entry Deleted Successfully!");
                return;
            }
        }
        //If we don't find the people,then print some message to prompt the user
        System.out.println("Entry Deletion Unsuccessful, please try again.");
    }

    /**
     * Displays the phoneBook
     */
    public void displayPhoneBook() {
        for(Node contact: this.phoneBook) {
            System.out.println(contact.toString());
        }
        System.out.println();
        System.out.println();
    }

    /**
     * Sort the phoneBook by lastName
     */
    public void sortPhoneBookByLastName() {
        //Use anonymous functions for sorting
        Collections.sort(this.phoneBook, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
    } 
}