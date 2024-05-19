/**
* DisasterRelief.java
*
* This project will figure out how many cargo planes and what kinds of cargo planes VCU needs to distribute their supplies
* Katie Lieu
* 2/3/24
* CMSC 255 Section 4
*/

import java.util.Scanner;

public class DisasterRelief {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// ask the user if they would like a random or manually entered population
		System.out.println("Would you like to randomly generate a population (1) or enter it yourself (2)?");
		int popType = input.nextInt();
		int population = 0;

		//based on their input, either randomly generate a number from 5000 - 8000000 and print it out or take their input and evaluate its validity
		switch (popType) {
		case 1:
			population = (int) (Math.random() * (8000000 - 5000 + 1) + 5000);
			System.out.println(population);

			//calculates the amount of planes needed to deliver all supplies using remainders
			int industrialPlanes = population / (9 * 5 * 3 * 5000);
	        int remainingPopulation = population % (9 * 5 * 3 * 5000);

	        int largePlanes = remainingPopulation / (5 * 3 * 5000);
	        remainingPopulation %= (5 * 3 * 5000);

	        int mediumPlanes = remainingPopulation / (3 * 5000);
	        remainingPopulation %= (3 * 5000);

	        int smallPlanes = remainingPopulation / 5000;
	        
	        //accounts for the remaining amount of supplies that doesn't have enough for a small plane
		    if (remainingPopulation != 0) {
		       	smallPlanes++;
		      	//replaces the planes with the bigger plane if possible
		        if (smallPlanes >= 3) {
		        	smallPlanes -= 3;
		        	mediumPlanes++;
		        }
		        if (mediumPlanes >= 5) {
		        	mediumPlanes -= 5;
		        	largePlanes++;
		        }
		        if (largePlanes >= 9) {
		        	largePlanes -= 9;
		        	industrialPlanes++;
		        }
	        }

	        //prints out all the planes needed to send out the supplies only when the number of planes is not 0
			System.out.println("To supply a population of " + population + " people with supplies you must send out: ");
			if (industrialPlanes > 0) {
				System.out.println(industrialPlanes + " industrial cargo plane(s)");
			}
			if (largePlanes > 0) {
				System.out.println(largePlanes + " large cargo plane(s)");

			}
			if (mediumPlanes > 0) {
				System.out.println(mediumPlanes + " medium cargo plane(s)");

			}
			if (smallPlanes > 0) {
				System.out.println(smallPlanes + " small cargo plane(s)");

			}
			break;
		
		case 2:
			System.out.println("Enter a population between 5000 and 8000000");
			population = input.nextInt();
			if (population <= 5000 || population >= 8000000) {
				System.out.println("Incorrect Input");
			} else {
				//calculates the amount of planes needed to deliver all supplies using remainders
				industrialPlanes = population / (9 * 5 * 3 * 5000);
		        remainingPopulation = population % (9 * 5 * 3 * 5000);

		        largePlanes = remainingPopulation / (5 * 3 * 5000);
		        remainingPopulation %= (5 * 3 * 5000);

		        mediumPlanes = remainingPopulation / (3 * 5000);
		        remainingPopulation %= (3 * 5000);

		        smallPlanes = remainingPopulation / 5000;
		        
		        //accounts for the remaining amount of supplies that doesn't have enough for a small plane
		        if (remainingPopulation != 0) {
		        	smallPlanes++;
		      		//replaces the planes with the bigger plane if possible
		        	if (smallPlanes >= 3) {
		        		smallPlanes -= 3;
		        		mediumPlanes++;
		        	}
		        	if (mediumPlanes >= 5) {
		        		mediumPlanes -= 5;
		        		largePlanes++;
		        	}
		        	if (largePlanes >= 9) {
		        		largePlanes -= 9;
		        		industrialPlanes++;
		        	}
	        	}
		        //prints out all the planes needed to send out the supplies only when the number of planes is not 0
				System.out.println("To supply a population of " + population + " people with supplies you must send out: ");
				if (industrialPlanes > 0) {
					System.out.println(industrialPlanes + " industrial cargo plane(s)");
				}
				if (largePlanes > 0) {
					System.out.println(largePlanes + " large cargo plane(s)");

				}
				if (mediumPlanes > 0) {
					System.out.println(mediumPlanes + " medium cargo plane(s)");

				}
				if (smallPlanes > 0) {
					System.out.println(smallPlanes + " small cargo plane(s)");

				}
		    }
			
			break;
		default:
			System.out.println("Incorrect Input");
			break;

		}
		
	}
}
