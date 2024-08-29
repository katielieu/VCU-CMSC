package Labs.Lab10;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(int newSpeed, boolean newOn, double newRadius, String newColor) {
        speed = newSpeed;
        on = newOn;
        radius = newRadius;
        color = newColor;
    }
    public Fan() {
        this(1, false, 5, "blue");
    }

    /**
     * set speed to new speed
     * @param newSpeed
     */
    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    /**
     * set on to new on
     * @param newOn
     */
    public void setOn(boolean newOn) {
        on = newOn;
    }

    /**
     * set radius to new radius
     * @param newRadius
     */
    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    /**
     * set color to new color
     * @param newColor
     */
    public void setColor(String newColor) {
        color = newColor;
    }

    /**
     * This method returns the status of whether the fan on or off
     * @return true if the fan is on, false otherwise
     */
    public boolean isOn() {
        return on;
    }
    /**
     * This method returns the speed of the fan
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * This method returns the radius of the fan
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * This method returns the color of the fan
     * @return color
     */
    public String getColor() {
        return color;
    }

    public String toString() {
        if (isOn()) {
            return ("fan is " + getSpeed() + ", " + getColor() + ", and size " + getRadius());
        } else {
            return ("fan is off");
        }
    }
}
