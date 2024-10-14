/**
 * This class represents a Staff object which is a subclass of Employee but also specifies the title of that person.
 * 
 * @author modified 8/30/24 by Katie Lieu
 * CMSC 256 Section 1
 */

package cmsc256;

public class Staff extends Employee {
    private String title;

    /**
     * Default constructor - calls the Employee default constructor and sets instance variables to default values
     */
    public Staff() {
        super();
        title = "None given";
    }

    /**
     * Parameterized constructor - sets instance variables to specified values
     * @param first     the first name
     * @param middle    the middle name
     * @param last      the last name
     * @param address   the address
     * @param phone     the phone number
     * @param email     the email address
     * @param office    the office number
     * @param salary    the salary
     * @param month     the month
     * @param day       the day
     * @param year      the year
     * @param title     the position title
     */
    public Staff (String first, String middle, String last, Address address, String phone, String email, String office, int salary, int month, int day, int year, String title) {
        super(first, middle, last, address, phone, email, office, salary, month, day, year);
        
        this.title = title;
    }

    /**
     * Getter method for title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Format the needed info and return as a String
     * @return String statement
     */
    public String toString() {
        return (super.toString() + "\nTitle: " + title + "\n");
    }
}
