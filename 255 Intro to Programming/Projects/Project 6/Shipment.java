package Projects.Project6;

/**
 * Shipment.java
 *
 * Design a data type that models a shipment
 *_____________________________________________________
 * Katie Lieu
 * 4/7/24
 * CMSC 255 Section 4
 */

public class Shipment {
    private String destination;
    private int shipmentID;
    private double weight;
    private Roads roads;
    private Runways runways;
    private Danger danger;

    /**
     * default constructor that assigns default values to instance variables
     */
    public Shipment() {
        destination = "";
        shipmentID = 1;
        weight = 0;
        roads = Roads.none;
        runways = Runways.none;
        danger = Danger.none;
    }

    /**
     * parameterized constructor that assigns each instance variable with the new values
     * @param aDestination
     * @param aShipmentID
     * @param aWeight
     * @param aRoads
     * @param aRunways
     * @param aDanger
     */
    public Shipment(String aDestination, int aShipmentID, double aWeight, Roads aRoads, Runways aRunways, Danger aDanger) {
        destination = aDestination;
        shipmentID = aShipmentID;
        weight = aWeight;
        roads = aRoads;
        runways = aRunways;
        danger = aDanger;
    }

    /**
     * setter method for destination
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * setter method for shipmentID
     * @param shipmentID
     */
    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    /**
     * setter method for weight
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * setter method for roads
     * @param roads
     */
    public void setRoads(Roads roads) {
        this.roads = roads;
    }

    /**
     * setter method for runways
     * @param runways
     */
    public void setRunways(Runways runways) {
        this.runways = runways;
    }

    /**
     * setter method for danger
     * @param danger
     */
    public void setDanger(Danger danger) {
        this.danger = danger;
    }

    /**
     * getter method for destination
     * @return value of destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * getter method for shipmentID
     * @return value of shipmentID
     */
    public int getShipmentID() {
        return shipmentID;
    }

    /**
     * getter method for weight
     * @return value of weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * getter method for roads
     * @return value of roads
     */
    public Roads getRoads() {
        return roads;
    }

    /**
     * getter method for runways
     * @return value of runways
     */
    public Runways getRunways() {
        return runways;
    }

    /**
     * getter method for danger
     * @return value of danger
     */
    public Danger getDanger() {
        return danger;
    }

    /**
     * return the needed info as a String
     * @return the formatted string of info
     */
    public String toString() {
        return "\n\t" + destination + "\n\t" + shipmentID + "\n\t" + String.format("%.2f", weight) + "\n\t" + roads + "\n\t" + runways + "\n\t" + danger + "\n";
    }
}
