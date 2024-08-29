/**
 * 
 * Person.java
 * A class that represents a person consisting of an id, name, home address, phone number, and email.
 * 
 * @author modified 8/28/24 by Katie Lieu
 */
package cmsc256;

public class Person {
    private int id;
    private Name name;
    private Address homeAddress;
    private String phoneNumber;
    private String email;
    private static int recordNumber;

    public Person() {
        name = new Name();
        homeAddress = new Address();
        phoneNumber = "None given";
        email = "None given";
        id = ++recordNumber; 
    }

    public Person(String first, String middle, String last, Address address, String phone, String email) {
        this.name = new Name(first, middle, last);
        this.homeAddress = address;
        this.phoneNumber = phone;
        this.email = email;
        id = ++recordNumber;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return (name + "\nHome Address: " + homeAddress + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + email + "\nID: " + id);
    }
}
