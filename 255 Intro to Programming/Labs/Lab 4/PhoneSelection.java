/*
* Katie Lieu
* CMSC 255 Section 4
*/

import java.util.Scanner;

public class PhoneSelection {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a single letter, and I will tell you what the corresponding digit is on the telephone: ");
		
		//take the user's input and make sure it is capitalized
		char letter = input.next().charAt(0);
		letter = Character.toUpperCase(letter);
		//initialize the digit variable to be used in the switch statement
		int digit;

		switch (letter) {
			//for letters ABC, assign 2 to the digit variable and print out a corresponding msg
			case ('A') :
			case ('B') :
			case ('C') :
				digit = 2;
				System.out.println("The digit " + digit + " corresponds to the letter " + letter + " on the telephone.");
				break;
			//for letters DEF, assign 3 to the digit variable and print out a corresponding msg
			case ('D') :
			case ('E') :
			case ('F') :
				digit = 3;
				System.out.println("The digit " + digit + " corresponds to the letter " + letter + " on the telephone.");
				break;
			//for letters GHI, assign 4 to the digit variable and print out a corresponding msg
			case ('G') :
			case ('H') :
			case ('I') :
				digit = 4;
				System.out.println("The digit " + digit + " corresponds to the letter " + letter + " on the telephone.");
				break;
			//for letters JKL, assign 5 to the digit variable and print out a corresponding msg
			case ('J') :
			case ('K') :
			case ('L') :
				digit = 5;
				System.out.println("The digit " + digit + " corresponds to the letter " + letter + " on the telephone.");
				break;
			//for letters MNO, assign 6 to the digit variable and print out a corresponding msg
			case ('M') :
			case ('N') :
			case ('O') :
				digit = 6;
				System.out.println("The digit " + digit + " corresponds to the letter " + letter + " on the telephone.");
				break;
			//for letters PQRS, assign 7 to the digit variable and print out a corresponding msg
			case ('P') :
			case ('Q') :
			case ('R') :
			case ('S') :	
				digit = 7;
				System.out.println("The digit " + digit + " corresponds to the letter " + letter + " on the telephone.");
				break;
			//for letters TUV, assign 8 to the digit variable and print out a corresponding msg
			case ('T') :
			case ('U') :
			case ('V') :
				digit = 8;
				System.out.println("The digit " + digit + " corresponds to the letter " + letter + " on the telephone.");
				break;
			//for letters WXYZ, assign 9 to the digit variable and print out a corresponding msg
			case ('W') :
			case ('X') :
			case ('Y') :
			case ('Z') :
				digit = 9;
				System.out.println("The digit " + digit + " corresponds to the letter " + letter + " on the telephone.");
				break;
			//for non letter characters, print out an error msg
			default : 
				System.out.println("There is no matching digit on the telephone.");
		}

	}
}