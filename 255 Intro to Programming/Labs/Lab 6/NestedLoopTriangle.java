public class NestedLoopTriangle {
	public static void main(String[] args) {
		//initialize rows variable to determine the number of rows
		int rows = 10;

		//outer loop for rows - test if i is less than or equal to rows 
		//before running the body. then increment i by 1 
		for (int i = 1; i <= rows; i++) {
			//test if j is less than i times 2. print double the 
			//asterisks in each row then increment j by 1
			for (int j = 1; j < (i * 2); j++) {
				System.out.print("*");
			}
			//move to the next line after each row
			System.out.println();
		}

		    //outer loop for rows - test if i is less than or equal to rows
			//before running the body. then increment i by 1
        for (int i = 1; i <= rows; i++) {
            //middle loop for spaces - as the rows increase, the spaces decrease,
            //which is why we test if j is less than or equal to rows minus i
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            //inner loop for printing asterisks - double the asterisks printed
            //with i * 2
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            //move to the next line
            System.out.println();
        }
	}
}