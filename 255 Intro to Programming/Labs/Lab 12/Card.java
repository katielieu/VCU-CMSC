package Labs.Lab12;

public class Card {
    private String name;

    /**
     * Default constructor that sets name to an empty string
     */
    public Card() {
        name = "";
    }

    /**
     * Parameterized constructor that sets name to the given name
     * @param name
     */
    public Card(String name) {
        this.name = name;
    }

    /**
     * Return info as a string
     * @return the card holder's name
     */
    public String toString() {
        return "Card Holder: " + name;
    }
}

