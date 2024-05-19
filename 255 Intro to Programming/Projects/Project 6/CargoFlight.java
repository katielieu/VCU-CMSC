package Projects.Project6;

import java.util.ArrayList;

/**
 * CargoFlight.java
 *
 * Design a data type that models a cargo flight for the shipments
 *_____________________________________________________
 * Katie Lieu
 * 4/7/24
 * CMSC 255 Section 4
 */

public class CargoFlight {
    private String flightNumber;
    private double weightCapacity;
    private double volumeCapacity;
    private String danger;
    private ArrayList<Shipment> shipments;

    /**
     * default constructor that assigns default values to instance variables and initializes shipments ArrayList
     */
    public CargoFlight() {
        flightNumber = "";
        weightCapacity = 0.0;
        volumeCapacity = 0.0;
        danger = "";
        shipments = new ArrayList<>();
    }

    /**
     * parameterized constructor that assigns each instance variable with the new values
     * @param aFlightNumber
     * @param aWeightCapacity
     * @param aVolumeCapacity
     * @param aDanger
     */
    public CargoFlight(String aFlightNumber, double aWeightCapacity, double aVolumeCapacity, String aDanger) {
        flightNumber = aFlightNumber;
        weightCapacity = aWeightCapacity;
        volumeCapacity = aVolumeCapacity;
        danger = aDanger;
    }

    /**
     * setter method for flightNumber
     * @param flightNumber
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * setter method for weightCapacity
     * @param weightCapacity
     */
    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    /**
     * setter method for volumeCapacity
     * @param volumeCapacity
     */
    public void setVolumeCapacity(double volumeCapacity) {
        this.volumeCapacity = volumeCapacity;
    }

    /**
     * setter method for danger
     * @param danger
     */
    public void setDanger(String danger) {
        this.danger = danger;
    }

    /**
     * add the given shipment to the ArrayList
     * @param shipment
     */
    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    /**
     * getter method for flightNumber
     * @return value of flightNumber
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * getter method for weightCapacity
     * @return value of weightCapacity
     */
    public double getWeightCapacity() {
        return weightCapacity;
    }

    /**
     * getter method for volumeCapacity
     * @return value of volumeCapacity
     */
    public double getVolumeCapacity() {
        return volumeCapacity;
    }

    /**
     * getter method for danger
     * @return value of danger
     */
    public String getDanger() {
        return danger;
    }

    /**
     * get the number of shipments
     * @return the size of shipments ArrayList
     */
    public int getNumShipments() {
        return shipments.size();
    }

    /**
     * get the shipments in the ArrayList
     * @return the shipments in the shipments ArrayList
     */
    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    /**
     * store the needed info in a variable and return it as a String
     * @return string, the variable that stores the needed info
     */
    public String toString() {
        String string = "";
        string += flightNumber + "\n";
        string += weightCapacity + "\n";
        string += volumeCapacity + "\n";
        string += danger + "\n";
        string += "Shipments:\n";

        //for each shipment in shipments, add it to string
        for(Shipment shipment : shipments) {
            string += shipment.toString();
        }

        return string;
    }
}
