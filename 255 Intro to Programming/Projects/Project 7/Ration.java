package Projects.Project7;

/**
 * Ration.java
 *
 * Defining a class for the specifications of a ration
 *_____________________________________________________
 * Katie Lieu
 * 4/29/24
 * CMSC 255 Section 4
 */

public class Ration {
    private String brand;
    private double carbohydrates;
    private double protein;
    private double fat;

    /**
     * Default constructor that sets all instance variables to default values
     */
    public Ration() {
        brand = "";
        carbohydrates = 0.0;
        protein = 0.0;
        fat = 0.0;
    }

    /**
     * Parameterized constructor that sets all instance variables to given values
     * @param brand
     * @param carbohydrates
     * @param protein
     * @param fat
     */
    public Ration(String brand, double carbohydrates, double protein, double fat) {
        this.brand = brand;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.fat = fat;
    }

    /**
     * Setter method for brand
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Setter method for carbohydrates
     * @param carbohydrates
     */
    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    /**
     * Setter method for protein
     * @param protein
     */
    public void setProtein(double protein) {
        this.protein = protein;
    }

    /**
     * Setter method for fat
     * @param fat
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Getter method for brand
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Getter method for carbohydrates
     * @return brand
     */
    public double getCarbohydrates() {
        return carbohydrates;
    }

    /**
     * Getter method for protein
     * @return carbohydrates
     */
    public double getProtein() {
        return protein;
    }

    /**
     * Getter method for fat
     * @return protein
     */
    public double getFat() {
        return fat;
    }

    /**
     * Returns information as a String and rounds the doubles to 2 decimal places
     * @return fat
     */
    public String toString() {
        return brand + " " + String.format("%.2f", carbohydrates) + " " + String.format("%.2f", protein) + " " + String.format("%.2f", fat);
    }
}
