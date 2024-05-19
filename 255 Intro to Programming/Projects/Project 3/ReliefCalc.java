/**
 * ReliefCalc.java
 *
 * Calculates the cost of relief efforts based on numerous factors
 *
 * Katie Lieu
 * 2/15/24
 * CMSC 255 Section 4
 */

import java.util.Scanner;

public class ReliefCalc {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String loopControl = "yes";

		// run the program while the loopControl variable is "yes"
		while (loopControl.equals("yes")) {
			// collect all user inputs needed and store them
			System.out.println("Enter the number of people needing relief: ");
			double population = input.nextDouble();
			System.out.println("Enter the distance from headquarters: ");
			double distance = input.nextDouble();
			System.out.println("Is air transportation required?: ");
			String airTransit = input.next();
			airTransit = airTransit.toLowerCase(); // make the string lowercase

			double supplyCost = 1./5 * population;
			double laborCost = 1./5 * population;
			double landTransit = distance * Math.sqrt(population);
			double totalCost = (double)50000 + supplyCost + laborCost + landTransit;

			// increase the total cost by one third if air transit is required
			if (airTransit.equals("yes")) {
				totalCost += (totalCost * 1/3);
			} 

			// print out the total cost rounded to two decimal places
			System.out.printf("Your relief effort will cost $%,.2f\n", totalCost); 

			// ask the user if they would like to run the program again
			System.out.println("Would you like to create another disaster relief cost estimate? Enter yes to continue ");
			loopControl = input.next().trim();
			 
		}
	}
}

