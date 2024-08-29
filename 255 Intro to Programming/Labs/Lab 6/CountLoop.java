import java.util.Scanner;

public class CountLoop {
	public static void main(String[] args) {
		//get user input
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int sum = 0;

		//for i is less than or equal to n, add i to sum and print it
		for (int i = 0; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(" ");

		//reset counter variables
		sum = 0;
		int i = 0;
		//while i is less than or equal to n, add i to sum and increment i by 1
		while (i <= n) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		System.out.println(" ");

		//reset counter variables
		sum = 0;
		i = 0;
		//add i to sum and increment it by 1 while is less than or equal to n
		do {
			sum += i;
			i++;
		} while (i <= n);
		System.out.println(sum);
		System.out.println(" ");
		
	}
}