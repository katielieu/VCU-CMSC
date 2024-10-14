/**
 * This class represents a Person object which contains an id, name, address, phone number, and email
 * 
 * @author modified 8/30/24 by Katie Lieu
 * CMSC 256 Section 1
 */

package cmsc256;

public class Person {
    private int id;
    private Name name;
    private Address homeAddress;
    private String phoneNumber;
    private String email;
    private static int recordNumber;

    /**
     * Default constructor - sets instance variables to default values and increments id by recordNumber
     */
    public Person() {
        name = new Name();
        homeAddress = new Address();
        phoneNumber = "None given";
        email = "None given";
        id = ++recordNumber; 
    }

    /**
     * Parameterized constructor - sets instance variables to specified values
     * @param first     the first name
     * @param middle    the middle name
     * @param last      the last name
     * @param address   the address
     * @param phone     the phone number
     * @param email     the email address
     */
    public Person(String first, String middle, String last, Address address, String phone, String email) {
        this.name = new Name(first, middle, last);
        this.homeAddress = address;
        this.phoneNumber = phone;
        this.email = email;
        id = ++recordNumber;
    }

    /**
     * Getter method for id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method for name
     * @return name
     */
    public Name getName() {
        return name;
    }

    /**
     * Getter method for homeAddress
     * @return homeAddress
     */
    public Address getHomeAddress() {
        return homeAddress;
    }

    /**
     * Getter method for phoneNumber
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter method for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Setter method for homeAdress
     */
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * Setter method for phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Setter method for email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Format the needed info and return as a String
     * @return String statement
     */
    public String toString() {
        return (this.getClass().getSimpleName() + ": \n---------------------------------------\n" + name.getFirstName() + " " + name.getLastName() + "\n---------------------------------------\nHome Address: " + homeAddress + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + email + "\nID: " + id);
    }
}
