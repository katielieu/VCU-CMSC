package Labs.Lab12;

public class DebitCard extends Card {
    private int cardNumber;
    private int pin;

    /**
     * Default constructor that passes "Jane Doe" to the superclass' constructor and sets cardNumber and pin to default values
     */
    public DebitCard() {
        super("Jane Doe");
        cardNumber = 00000000;
        pin = 0;
    }

    /**
     * Parameterized constructor that passes name to the superclass' constructor and intializes the other variables
     * @param name
     * @param cardNumber
     * @param pin
     */
    public DebitCard(String name, int cardNumber, int pin) {
        super(name);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    /**
     * Return info as a string
     * @return the card holder's name and the card number
     */
    public String toString() {
        return super.toString() + " Card Number: " + cardNumber;
    }
}
