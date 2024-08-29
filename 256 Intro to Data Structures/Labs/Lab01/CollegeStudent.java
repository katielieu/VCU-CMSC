package cmsc256;

public class CollegeStudent extends Person {
    private String level;

    public CollegeStudent() {
        super();
        level = "Freshman";
    }

    
    public CollegeStudent(String firstName, String middleName, String lastName, Address address, String phone, String email, String level) throws IllegalArgumentException {
        super (firstName, middleName, lastName, address, phone, email);

        if (isValidLevel(level) == false) {
            throw new IllegalArgumentException("Please enter a valid level");
        }
        this.level = level;
    }

    private boolean isValidLevel(String levelVar)
	{
		String[] levelList = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};

		for(int i = 0; i < levelList.length; i++)
			if(levelList[i].equals(levelVar))
				return true;

		return false;
	}

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) throws IllegalArgumentException {
        this.level = level;
    }

    public String toString() {
        return (super.toString() + "\nCollege Level: " + level);
    }
}
