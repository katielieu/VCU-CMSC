package Labs.Lab13;

// Make the Team class public
public class Team {
    private String name;
    private int numGoals;
    private double numShots;

    /**
     * default constructor that assigns all instance variables to default values
     */
    public Team() {
        this.name = "";
        this.numGoals = 0;
        this.numShots = 0;
    }

    /**
     * parameterized constructor that sets all variables to given values
     * @param name
     * @param numGoals
     * @param numShots
     */
    public Team(String name, int numGoals, double numShots) {
        this.name = name;
        this.numGoals = numGoals;
        this.numShots = numShots;
    }

    /**
     * setter method for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter method for numGoals
     * @param numGoals
     */
    public void setNumGoals(int numGoals) {
        this.numGoals = numGoals;
    }

    /**
     * setter method for numShots
     * @param numShots
     */
    public void setNumShots(double numShots) {
        this.numShots = numShots;
    }

    /**
     * getter method for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for numGoals
     * @return
     */
    public int getNumGoals() {
        return numGoals;
    }

    /**
     * getter method for numShots
     * @return
     */
    public double getNumShots() {
        return numShots;
    }
}