/**
 * This program is created to modify the given methods so that they are generic.
 *
 * Modified on 9/4/23 by Katie Lieu
 * Lab Partner: Haley Roe
 * CMSC 256 Section 901
 */

package cmsc256;

public class GenericPractice {

    // Method 1d

    // If the array is non-empty, then this function returns an element // from near the middle of the array; otherwise, it returns null
    public static <T> T middle(T[] data) { //make method generic using T as the data type

        T result = null;

        int numElements = data.length;

        if(numElements > 0) {

            // return an element near the center of the array

            result = data[numElements/2];

        }

        return result;

    }



// Method 2

// counts the number of occurrences of the target in the given array

    public static <T> int countTarget(T[] data, T target) { //make method generic by changing the data type

        int numOccurences = 0;

        for(int i = 0; i < data.length; i++){

            if(data[i] == target)

                numOccurences++;

        }

        return numOccurences;

    }



// Method 3

// returns the smallest element in the array

    public static <T extends Comparable<T>> T findSmallest(T[] values) { //use Comparable so that any data type could be compared

        T smallest = values[0];

        for(int i = 1; i < values.length; i++){

            if(values[i].compareTo(smallest) < 0)

                smallest = values[i];

        }

        return smallest;

    }
}
