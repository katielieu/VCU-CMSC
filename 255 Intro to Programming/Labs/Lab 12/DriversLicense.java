package Labs.Lab12;

public class DriversLicense extends IDCard {
    private int expirationYear;
    private Month expirationMonth;

    /**
     * default constructor that sets the variables to default values
     */
    public DriversLicense() {
        super();
        expirationYear = 1969;
        expirationMonth = Month.JANUARY;
    }

    /**
     * pass name and idNumber to IDCard constructor and initialize other variables
     * @param name
     * @param idNumber
     * @param expirationYear
     * @param expirationMonth
     */
    public DriversLicense(String name, int idNumber, int expirationYear, Month expirationMonth) {
        super(name, idNumber);
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
    }

    /**
     * return info as a string
     * @return card holder's name, exp month and year
     */
    public String toString() {
        return super.toString() + " Expiration Month & Year: " + expirationMonth + " " + expirationYear;
    }
}
