/**
 * Node is a class to store the information of people
 * It will store firstName,lastName,phoneNumber,city and address of the people
 */
public class Node {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String address;

    //The constructor of Node
    public Node(String firstName, String lastName, String phoneNumber, String city, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Full Name: '" + firstName + " " + lastName + '\'' +
                ", Phone_Number: '" + phoneNumber + '\'' +
                ", City: '" + city + '\'' +
                ", Address: '" + address + '\'';
    }

    public String getFirstName() {//Getter for firstName.
        return firstName;
    }
   
    public void setFirstName(String firstName) { //Setter for firstName.
        this.firstName = firstName;
    }
    
    public String getLastName() { //Getter for lastName.
        return lastName;
    }
    
    public void setLastName(String lastName) { //Setter for lastName.
        this.lastName = lastName;
    }
   
    public String getPhone_Number() {  //Getter for phone number.
        return phoneNumber;
    }
   
    public void setMobile(String phoneNumber) { //Setter for phone number.
        this.phoneNumber = phoneNumber;
    }
    
    
    public String getCity() { //Getter for city.
        return city;
    }
    
    public void setCity(String city) { //Setter for city.
        this.city = city;
    }
    
    public String getAddress() { //Getter for address.
        return address;
    }
    //Setter for address
    public void setAddress(String address) { //Setter for address.
        this.address = address;
    }   
}