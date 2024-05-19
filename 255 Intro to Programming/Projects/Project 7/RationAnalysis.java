package Projects.Project7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * RationAnalysis.java
 *
 * Reads and processes an input file full of data to analyze rations
 *_____________________________________________________
 * Katie Lieu
 * 4/29/24
 * CMSC 255 Section 4
 */

public class RationAnalysis {
    /**
     * Main method to invoke the necessary methods
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        File inputFile, outputFile;
        Scanner input = new Scanner(System.in);

        if (args.length > 0) {
            inputFile = new File(args[0]);
            outputFile = new File(args[1]);
        } else {
            inputFile = new File(input.next());
            outputFile = new File(input.next());
        }

        ArrayList<String> lines = openFile(inputFile);
        ArrayList<Ration> rations = createObjects(lines);

        PrintWriter out = new PrintWriter(outputFile);

        outputToFile("The average carbohydrates of all rations is: ", findMean(rations, Nutrition.CARBOHYDRATES), out);
        outputToFile("The highest carbohydrates of all rations is: ", findHighValue(rations, Nutrition.CARBOHYDRATES), out);
        outputToFile("The ration closest to the average carbohydrates is: ", findMeanRation(rations, Nutrition.CARBOHYDRATES, findMean(rations, Nutrition.CARBOHYDRATES)), out);
        outputToFile("The delivery rations below the average value for carbohydrates are: ", findLowestRations(rations, Nutrition.CARBOHYDRATES, findMean(rations, Nutrition.CARBOHYDRATES)), out);
    }

    /**
     * Reads data from the input file line by line and stores them in an ArrayList
     * @param inputFile
     * @return the ArrayList of the lines of data
     * @throws FileNotFoundException
     */
    public static ArrayList<String> openFile(File inputFile) throws FileNotFoundException {
        Scanner input = new Scanner(inputFile); //create Scanner variable to read from inputFile

        ArrayList<String> lines = new ArrayList<>(); //initialize the array list for the lines of data
        try {
            //loop while there is a next line of data
            while(input.hasNextLine()) {
                String line = input.nextLine(); //store next line

                lines.add(line); //add the line to the array list
            }
        } catch (Exception ex) {
            System.out.println("Incorrect input filename");
        }
        System.out.println("Input file correct");
        return lines;
    }

    public static ArrayList<Ration> createObjects (ArrayList<String> lines) {
        ArrayList<Ration> rations = new ArrayList<>();
        double carbohydrates, protein, fat;
        String[] token;
        String brand;

        for (int i = 0; i < lines.size(); i++) {
            token = lines.get(i).split("\t"); //split lines by tabs and store each element
            brand = token[0];

            //process carb data
            try {
                carbohydrates = Double.parseDouble(token[1]); //convert second token to double
                //if carbs is negative set it to 0.0
                if (carbohydrates < 0) {
                    carbohydrates = 0.0;
                }
            } catch (NumberFormatException ex) {
                carbohydrates = 0.0; //set to 0.0 if a nfe is caught
            }
            //process protein data
            try {
                protein = Double.parseDouble(token[2]); //convert second token to double
                //if protein is negative set it to 0.0
                if (protein < 0) {
                    protein = 0.0;
                }
            } catch (NumberFormatException ex) {
                protein = 0.0; //set to 0.0 if a nfe is caught
            }
            //process fat data
            try {
                fat = Double.parseDouble(token[3]); //convert second token to double
                //if fat is negative set it to 0.0
                if (fat < 0) {
                    fat = 0.0;
                }
            } catch (NumberFormatException ex) {
                fat = 0.0; //set to 0.0 if a nfe is caught
            }

            Ration ration = new Ration(brand, carbohydrates, protein, fat); //create new Ration object with the processed data
            rations.add(ration); //add Ration object to Ration ArrayList
        }

        return rations;
    }

    /**
     * Find the average for the given nutrition attribute within the Ration objects
     * @param rations
     * @param attribute
     * @return mean
     */
    public static double findMean (ArrayList<Ration> rations, Nutrition attribute) {
        double sum = 0;
        double mean;
        //depending on the nutrition attribute, get the correct value from each ration company and add them to sum
        if (attribute == Nutrition.CARBOHYDRATES) {
            for (int i = 0; i < rations.size(); i++) {
                sum += rations.get(i).getCarbohydrates();
            }
        } else if (attribute == Nutrition.PROTEIN) {
            for (int i = 0; i < rations.size(); i++) {
                sum += rations.get(i).getProtein();
            }
        } else if (attribute == Nutrition.FAT) {
            for (int i = 0; i < rations.size(); i++) {
                sum += rations.get(i).getFat();
            }
        }
        mean = sum / rations.size();
        return mean;
    }

    /**
     * Find the highest value for the given nutrition attribute within the Ration objects
     * @param rations
     * @param attribute
     * @return
     */
    public static double findHighValue (ArrayList<Ration> rations, Nutrition attribute) {
        double max = 0;
        //traverse rations for the necessary attribute and find the highest value
        if (attribute == Nutrition.CARBOHYDRATES) {
            for (int i = 0; i < rations.size(); i++) {
                if (rations.get(i).getCarbohydrates() > max) {
                    max = rations.get(i).getCarbohydrates();
                }
            }
        } else if (attribute == Nutrition.PROTEIN) {
            for (int i = 0; i < rations.size(); i++) {
                if (rations.get(i).getProtein() > max) {
                    max = rations.get(i).getProtein();
                }
            }
        } else if (attribute == Nutrition.FAT) {
            for (int i = 0; i < rations.size(); i++) {
                if (rations.get(i).getFat() > max) {
                    max = rations.get(i).getFat();
                }
            }
        }
        return max;
    }

    /**
     * Find the Ration object whose value for the given attribute is closest to the mean value of the data for that given attribute
     * @param rations
     * @param attribute
     * @param meanValue
     * @return closestValue
     */
    public static Ration findMeanRation(ArrayList<Ration> rations, Nutrition attribute, double meanValue){
        Ration closestRation = null;
        double lowestDiff = Double.MAX_VALUE;
        double distance;
        meanValue = findMean(rations, attribute); //invoke the findMean method to find the wanted mean value

        //depending on the attribute, find the closest Ration
        if (attribute == Nutrition.CARBOHYDRATES) {
            for (int i = 0; i < rations.size(); i++) {
                distance = Math.abs(rations.get(i).getCarbohydrates() - meanValue); //finding the abs value of the difference of the value and meanValue

                //if distance is less than the lowest difference then replace the variables
                if (distance < lowestDiff) {
                    lowestDiff = distance;
                    closestRation = rations.get(i);
                }
            }
        }
        //do the same for protein
        else if (attribute == Nutrition.PROTEIN) {
            for (int i = 0; i < rations.size(); i++) {
                distance = Math.abs(rations.get(i).getProtein() - meanValue);

                if (distance < lowestDiff) {
                    lowestDiff = distance;
                    closestRation = rations.get(i);
                }
            }
        }
        //do the same for fat
        else if (attribute == Nutrition.FAT) {
            for (int i = 0; i < rations.size(); i++) {
                distance = Math.abs(rations.get(i).getFat() - meanValue);

                if (distance < lowestDiff) {
                    lowestDiff = distance;
                    closestRation = rations.get(i);
                }
            }
        }

        return closestRation;
    }

    /**
     * Find the Ration objects that are less than the value passed in for the given attribute
     * @param rations
     * @param attribute
     * @param value
     * @return lowestRations
     */
    public static ArrayList<Ration> findLowestRations(ArrayList<Ration> rations, Nutrition attribute, double value){
        ArrayList<Ration> lowestRations = new ArrayList<>(); //initialize the array list that will store the lowest rations

        if (attribute == Nutrition.CARBOHYDRATES) {
            for (int i = 0; i < rations.size(); i++) {
                //if the ration's value is lower than the given value, add the ration to lowestRations
                if (rations.get(i).getCarbohydrates() < value) {
                    lowestRations.add(rations.get(i));
                }
            }
        }
        else if (attribute == Nutrition.PROTEIN) {
            for (int i = 0; i < rations.size(); i++) {
                //if the ration's value is lower than the given value, add the ration to lowestRations
                if (rations.get(i).getProtein() < value) {
                    lowestRations.add(rations.get(i));
                }
            }
        }
        else if (attribute == Nutrition.FAT) {
            for (int i = 0; i < rations.size(); i++) {
                //if the ration's value is lower than the given value, add the ration to lowestRations
                if (rations.get(i).getFat() < value) {
                    lowestRations.add(rations.get(i));
                }
            }
        }

        return lowestRations;
    }

    /**
     * Check the output file name and write the given output message and each value of the rations list to it
     * @param outputMessage
     * @param rations
     * @param out
     */
    public static void outputToFile(String outputMessage, ArrayList<Ration> rations, PrintWriter out) throws FileNotFoundException {
        try {
            out.println(outputMessage);

            //print each ration
            for (int i = 0; i < rations.size(); i++) {
                out.print(rations.get(i).toString() + " ");
            }
            out.close();
        } catch (Exception ex) {
            System.out.println("Incorrect output filename");
        }
        System.out.println("Output file correct");
    }

    /**
     * Check the output file name and write the given output message and Ration object to it
     * @param outputMessage
     * @param ration
     * @param out
     */
    public static void outputToFile(String outputMessage, Ration ration, PrintWriter out) throws FileNotFoundException {
        try {
            //print the given output message and ration
            out.println(outputMessage + ration.toString() + "\n");
            out.close();
        } catch (Exception ex) {
            System.out.println("Incorrect output filename");
        }
        System.out.println("Output file correct");
    }

    /**
     * Check the output file name and write the given output message and value to it
     * @param outputMessage
     * @param value
     * @param out
     */
    public static void outputToFile(String outputMessage, double value, PrintWriter out) throws FileNotFoundException {
        try {
            //print the given output message and value
            out.println(outputMessage +  String.format("%.2f\n", value));
            out.close();
        } catch (Exception ex) {
            System.out.println("Incorrect output filename");
        }
        System.out.println("Output file correct");
    }

}
