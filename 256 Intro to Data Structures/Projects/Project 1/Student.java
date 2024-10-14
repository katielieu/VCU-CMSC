/**
 * This class represents a Student object which is a subclass of Person but also specifies the grade level of that person.
 * 
 * @author modified 8/30/24 by Katie Lieu
 * CMSC 256 Section 1
 */

package cmsc256;

public class Student extends Person {
    private String level;

    /**
     * Default constructor - calls the Person default constructor and sets instance variables to default values
     */
    public Student() {
        super();
        level = "Freshman";
    }

    /**
     * Parameterized constructor - sets instance variables to specified values
     * @param firstName     the first name
     * @param middleName    the middle name
     * @param lastName      the last name
     * @param address       the address
     * @param phone         the phone number
     * @param email         the email address
     * @param level         the grade level
     * @throws IllegalArgumentException     checks if the grade level is valid using the isValidLevel method and throws an exception if not
     */
    public Student(String firstName, String middleName, String lastName, Address address, String phone, String email, String level) throws IllegalArgumentException {
        super (firstName, middleName, lastName, address, phone, email);

        //if level is not a valid rank, throw an exception
        if (isValidLevel(level) == false) {
            throw new IllegalArgumentException("Please enter a valid level");
        }
        this.level = level;
    }

    /**
     * Tests the provided level variable to make sure it is on the last of valid levels and returns a boolean
     * @param levelVar
     * @return true or false
     */
    private boolean isValidLevel(String levelVar) {
        //set the list of valid levels
		String[] levelList = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};

        //traverse the level list and return true if a match is found
		for(int i = 0; i < levelList.length; i++)
			if(levelList[i].equals(levelVar))
				return true;

		return false; //return false if match is not found
	}

    /**
     * Getter method for level
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Setter method for level but it only works if a valid grade level is provided
     */
    public void setLevel(String level) {
        if (isValidLevel(level) == false) {
            throw new IllegalArgumentException("Please enter a valid level");
        }
        this.level = level;
    }

    /**
     * Format the needed info and return as a String
     * @return String statement
     */
    public String toString() {
        return (super.toString() + "\nCollege Level: " + level + "\n");
    }
}
