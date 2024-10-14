/**
 * This class represents a Faculty object which is a subclass of Employee but also specifies the rank of that person.
 * 
 * @author modified 8/30/24 by Katie Lieu
 * CMSC 256 Section 1
 */

package cmsc256;

public class Faculty extends Employee {
    private String rank;

    /**
     * Default constructor - calls the Employee default constructor and sets instance variables to default values
     */
    public Faculty() {
        super();
        rank = "Instructor";
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
     * @param rank      the rank
     */
    public Faculty(String first, String middle, String last, Address address, String phone, String email, String office, int salary, int month, int day, int year, String rank) {
        super(first, middle, last, address, phone, email, office, salary, month, day, year);

        //if rank is not a valid rank, throw an exception
        if (isValidRank(rank) == false) {
            throw new IllegalArgumentException("Please enter a valid rank");
        }
        this.rank = rank;
    }

    /**
     * Tests the provided rank variable to make sure it is on the last of valid ranks and returns a boolean
     * @param rankVar
     * @return true or false
     */
    private boolean isValidRank(String rankVar) {
        //set the list of rank levels
		String[] rankList = {"Adjunct", "Instructor", "Assistant Professor", "Associate Professor", "Professor"};

        //traverse the rank list and return true if a match is found
		for(int i = 0; i < rankList.length; i++)
			if(rankList[i].equals(rankVar))
				return true;

		return false; //return false if match is not found
	}

    /**
     * Getter method for rank
     * @return rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Setter method for rank but it only works if a valid rank is provided
     */
    public void setRank(String rank) {
        if (isValidRank(rank) == false) {
            throw new IllegalArgumentException("Please enter a valid rank");
        }
        this.rank = rank;
    }

    /**
     * Format the needed info and return as a String
     * @return String statement
     */
    public String toString() {
        return (super.toString() + "\nRank: " + rank + "\n");
    }
}
