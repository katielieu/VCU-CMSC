package Labs.Lab12;

public class CardTest {
    public static void main (String[] args) {
        Card janeDoe = new Card ("Jane Doe");
        System.out.println(janeDoe.toString());

        DebitCard williamCard = new DebitCard("William Jones", 12039479, 2);
        System.out.println(williamCard.toString());

        IDCard smithCard = new IDCard("Jane Smith", 124);
        System.out.println(smithCard.toString());

        DriversLicense janeLicense = new DriversLicense("Jane Doe", 0, 1969, Month.JANUARY);
        System.out.println(janeLicense.toString());
    }
}
