package Labs.Lab12;

public class IDCard extends Card {
    private int idNumber;

    /**
     * default constructor that sets the variables to default values
     */
    public IDCard() {
        super("Jane Smith");
        idNumber = 0;
    }

    /**
     * Pass name to Card constructor and initialize idNumber
     * @param name
     * @param idNumber
     */
    public IDCard(String name, int idNumber) {
        super(name);
        this.idNumber = idNumber;
    }

    /**
     * return info as a string
     * @return the card holder's name and id number
     */
    public String toString() {
        return super.toString() + " ID Number: " + idNumber;
    }
}
