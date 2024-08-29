package Labs.Lab14;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 *   DaysPerMonth
 *   VCU - Computer Science Department
 *   A program that prompts the user for a month and year (both as integers)
 *   then displays the number of days in that month.
 **/

public class DaysPerMonth {

    public static void main(String[] args){
        //if there are no command line arguments ask the user for the file names
        if (args.length == 0) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter an input file name: ");
            String inputFileName = input.next(); //store the user's input as a string
            System.out.println();
            File inputFile = new File(inputFileName); //then make it a File object

            File outputFile = new File("lab14Output.txt");
            processFile(inputFile,outputFile);
        //if there are command line arguments make File objects from them
        } else {
            File inputFile = new File(args[0]);
            File outputFile = new File(args[1]);
            processFile(inputFile,outputFile);
        }
    }

    /**
     * method that checks the filenames and processes inputFile
     * @param inputFile
     * @param outputFile
     */
    public static void processFile(File inputFile, File outputFile){
        try {
            //create input and output variables
            PrintWriter output = new PrintWriter(outputFile);
            Scanner input = new Scanner(inputFile);
            //while inputFile has data
            while(input.hasNextLine()) {
                String line = input.nextLine();
                String[] split = line.split(","); //split up the data
                try {
                    //convert Strings to ints
                    int month = Integer.parseInt(split[0]);
                    int year = Integer.parseInt(split[1]);
                    //if the month is not between 1 and 12
                    if (month < 1 || month > 12) {
                        output.println("Month must be between 1 and 12");
                    }
                    //if the year is negative
                    else if (year < 0) {
                        output.println("Year cannot be negative");
                    }
                    //if there are no errors, call the getDays method and display the correct info
                    else {
                        int numDays= getDays(month,year);
                        output.println("There are "+ numDays + " days in this month.");
                    }
                }
                //catch data that is not an int
                catch (NumberFormatException ex) {
                    output.println("Not an integer");
                }
            }
            output.close();
            input.close();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("Bad File Name");
        }

    }

    /**
     * method to determine the days for the given month and year
     **/
    private static int getDays(int mon, int yr) {
        int numDays = 0;

        switch(mon) {
            case 2: // February
                numDays = 28;
                if (yr % 4 == 0) {
                    numDays = 29;
                    if (yr % 100 == 0 && yr % 400 != 0) {
                        numDays = 28;
                    }
                }
                break;

            case 4:   //April
            case 6:   // June
            case 9:   // September
            case 11:  // November
                numDays = 30;
                break;

            default: numDays = 31;  // all the rest
        }
        return numDays;
    }

}
