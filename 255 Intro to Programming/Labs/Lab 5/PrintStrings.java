import java.util.Scanner;

public class PrintStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// ask for user input
		System.out.println("Please enter two words: ");
		String str1 = input.next();
		String str2 = input.next();

		// compare the strings
		System.out.println("In lexicographic order: ");
		boolean str1BeforeStr2 = str1.compareTo(str2) < 0;

		if (str1BeforeStr2) {
			// print the second string first if the first string is bigger than the second
			System.out.println(str1);
			System.out.println(str2);
		} else if (!str1BeforeStr2) {
			// print the first string first if the second string is bigger than the first
			System.out.println(str2);
			System.out.println(str1);
		}
		
	}
}
