package Projects.Project4;
/**
 * NutritionComparison.java
 *
 * Determine the nutritional viability of rations provided by various companies
 *_____________________________________________________
 * Katie Lieu
 * 2/28/23
 * CMSC 255 Section 4
 */

import java.util.Scanner;

public class NutritionComparison {
	public static void main (String[] args) {
		//initialize all arrays
		String[] companies = {"ReadyWise", "My Patriot Supply", "4Patriots", "TWC", "ERCC", "Survival Frog", "Be Prepared", "Smithfield"};
		double[] protein = {30.2, 28.7, 30.1, 30.8, 41.4, 36.2, 38.1, 19.7};
		double[] carbs = {151.3, 167.8, 187.6, 178.5, 206.9, 185.2, 183.1, 161.3};
		double[] fat = {54.7, 30.3, 58.1, 44.4, 44.5, 34.9, 49.2, 26.4};

		//print format each prompt on separate lines
		System.out.printf("The average grams of protein per serving is: %.2fg", calcAvg(protein));
		System.out.println("");
		System.out.printf("The average grams of carbohydrate per serving is: %.2fg", calcAvg(carbs));
		System.out.println("");
		System.out.printf("The highest grams of protein per serving is: %.2fg", findHighValue(protein));
		System.out.println("");
		System.out.printf("The least grams of fat per serving is: %.2fg", findLeastValue(fat));
		System.out.println("");
		//print the two elements of the array methods on separate lines
		System.out.println("The companies with the two highest grams of protein per serving are: \n" + findHighestTwo(companies, protein)[0] + "\n" + findHighestTwo(companies, protein)[1]);
		System.out.println("The companies with the two lowest grams of carbohydrates per serving are: \n" + findLeastTwo(companies, carbs)[0] + "\n" + findLeastTwo(companies, carbs)[1]);

		//ask user to enter a company and test if it's in the array
		System.out.println("Enter a company: ");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine().trim();
		if (findCompany(companies, userInput)) {
			System.out.println(userInput + " is a company in the array.");
		} else {
			System.out.println(userInput + " is not a company in the array.");
		}

	}

	/**
	 * calcAvg() method - returns the average of given array as a double
	 *
	 * @param values, an array of doubles
	 * @return average
	 */
	public static double calcAvg(double[] values) {
		double average = 0;
		for (int i = 0; i < values.length; i++) {
			average += values[i]; //add up all the values
		}
		average /= values.length; //divide it by the number of elements in the list
		return average;
	}

	/**
 	* findHighValue() method - returns the highest value of the given array as a double
	* @param values, an array of doubles
	* @return highest value
	*/
	public static double findHighValue(double[] values) {
		double max = values[0];
		for (int i = 0; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i]; //set the max value to the tested element if it's larger than the previous max
			}
		}
		return max;
	}

	/**
	 * findLeastValue() method - returns the lowest value of the given array as a double
	 *
	 * @param values, an array of doubles
	 * @return lowest value
	 */
	public static double findLeastValue(double[] values) {
		double min = values[0];
		for (int i = 0; i < values.length; i++) {
			if (values[i] < min) {
				min = values[i]; //set the min value to the tested element if it's less than the previous max
			}
		}
		return min;
	}

	/**
	 * findHighestTwo() method - returns the companies with the highest two values as Strings
	 *
	 * @param names, an array of Strings
	 * @param values, an array of doubles
	 * @return the companies with the two highest values
	 */
	public static String[] findHighestTwo(String[] names, double[] values) {
		int index1 = 0;
		int index2 = 0;
		double max1 = 0;
		double max2 = 0;

		for (int i = 0; i < values.length; i++) {
			//move the previous max values to the second max's spot so the new max values can be stored
			if (values[i] > max1) {
				index2 = index1;
				max2 = max1;
				index1 = i;
				max1 = values[i];
			//set the second max values
			} else if (values[i] > max2 && values[i] != max1) {
				index2 = i;
				max2 = values[i];
			}
		}
		//return the two values in a new array
		return new String[]{names[index1], names[index2]};
	}

	/**
	 * findLeastTwo() method - returns  the companies with the lowest two values as Strings
	 *
	 * @param names, an array of Strings
	 * @param values, an array of doubles
	 * @return the companies with the two lowest values
	 */
	public static String[] findLeastTwo(String[] names, double[] values) {
		int index1 = 0;
		int index2 = 0;
		double min1 = 99999; //set large values for these, so they can be accurately measured
		double min2 = 99999;

		for (int i = 0; i < values.length; i++) {
			//move the previous min values to the second min's spot so the new min values can be stored
			if (values[i] < min1) {
				index2 = index1;
				min2 = min1;
				index1 = i;
				min1 = values[i];
			//set the second min values
			} else if (values[i] < min2 && values[i] != min1) {
				index2 = i;
				min2 = values[i];
			}
		}

		//return the two values in a new array
		return new String[]{names[index1], names[index2]};
	}

	/**
	 * findCompany() method - returns if the user-entered value is one of the ration companies in the * array as a boolean
	 *
	 * @param names, an array of Strings
	 * @param input, a String
	 * @return true or false
	 */
	public static boolean findCompany(String[] names, String input) {
		boolean status = false; //default the status to false
		for (int i = 0; i < names.length; i++) {
			if (input.equals(names[i])) {
				status = true;
				break; //stop searching if the company is found in the array
			}
		}
		return status;
	}

}