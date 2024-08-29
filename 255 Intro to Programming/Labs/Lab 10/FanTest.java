package Labs.Lab10;

public class FanTest {
    public static void main (String[] args) {
        Fan Fan1 = new Fan(3, true, 10, "yellow");

        Fan Fan2 = new Fan(2, false, 20, "blue");

        System.out.println(Fan1.toString());
        System.out.println(Fan2.toString());
    }
}
