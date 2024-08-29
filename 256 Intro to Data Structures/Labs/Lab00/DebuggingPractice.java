package cmsc256;
/*
 * This program is used to show how to find errors in your program
 * Programmer 1: Katie Lieu
 * Programmer 2: Rafiq Afrifa
 * CMSC 256 Section: 901
 * Lines with syntax errors: 25, 28
 * Runtime errors: Line 26 tried to convert a double into an int, but they're incompatible types, so that caused an error. Line 27 is trying to divide by 0 but that is not possible. Line 30 tried to print an element that is out of bounds. Line 64 tried to define a variable that was already defined in the method.
 */
import java.util.*;

public class DebuggingPractice {
    private static int evenPerfectSquareNumbers = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare variables
        int number;
        double average, value;
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};
        int[] nums = {23, 3, 14, -5, 44, 78, 6, 98, 25};
        String myName = "Katie";
        value = 3.75; //added a semi colon
        number = (int) value; //typecasted the double to an int
        //average = (3 + 5 + 8) / 0;
        System.out.println(" *** I am " + myName + " *** "); //added closed bracket and semicolon
                System.out.println("The first day of the week is: "+ daysOfTheWeek[1]);
        System.out.println("The last day of the week is: "+ daysOfTheWeek[6]); //since 7 is an out-of-bounds index, I changed it to 6, which is 7 - 1
        average = (3 + 5 + 8) / 3.0; //added parentheses around the addition to prioritize
        System.out.println("expected average is 5.33, actual average is: " + average);
        System.out.println("expected max is 98, actual max is: " + max(nums));
        System.out.println("expected type of number is double: " + number);
        System.out.println("calling countPerfectSquares(100)");
        countPerfectSquares(100); //adjust the argument to match the print statement above
        int[] arr = {-12, 35, 2, 17};
        System.out.println(inRange( arr, 10, 40));
        System.out.println(inRange( arr, -100, 400));
    }

    // Returns the maximum value in the array parameter
    public static int max(int[] a) {
        int result = a[0];
        for(int i = 0; i < a.length; i++){
            if(a[i] > result) { //switched the sign
                result = a[i];
            }
        }
        return result;
    }

    // Returns true if all values in the parameter array fall with the
    // range define by parameters low and high
    public static boolean inRange (int[] array , int low , int high ) {
        for (int i = 0 ; i < array.length ; i++) {
            if (array[i] < low || array[i] > high) { //I switched the conditional up so that instead of looking for whether the array value is in the range, it's looking for whether it's outside the range
                return false;
            }
        }
        return true;
    }

    // Displays the counts the total perfect squares and
    // //even perfect squares for a given number
    public static void countPerfectSquares(int num) {
        num = 100; //remove int, as num was already defined
        System.out.println("Total Perfect Squares: " + calculateCount(num));
        System.out.println("Even Perfect Squares : " + getEvenPerfectSquareNumbers()); //use the getter method to get evenPerfectSquareNumbers
    }

    public static int calculateCount(int i) {
        int perfectSquaresCount = 0;
        for (int number = 1; number <= i; number++) {
            if (isPerfectSquare(number)) {
                perfectSquaresCount++;
                if (number % 2 == 0) {
                    evenPerfectSquareNumbers++;
                }
            }
        }
        return perfectSquaresCount;
    }

    private static boolean isPerfectSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt - Math.floor(sqrt) == 0;
    }

    //getter method for EvenPerfectSquareNumbers
    public static int getEvenPerfectSquareNumbers() {
        return evenPerfectSquareNumbers;
    }
}
