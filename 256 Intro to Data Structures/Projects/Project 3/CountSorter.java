/**
 * CountSorter.java
 * This program sorts integers in ascending order using counter variables
 *
 * @modified on 9/27/24 by Katie Lieu
 * CMSC 256 Section 901
 */

package cmsc256;

import java.util.Arrays;

public class CountSorter {
    /**
     * returns true if all elements in the parameter array are positive
     *
     * @param anArray the array
     * @return true if all elements are positive, false otherwise
     * @throws IllegalArgumentException if anArray is empty
     */

    public static boolean hasAllPositiveElements(final int[] anArray) {
        if (anArray == null) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            for (int value : anArray) {
                if (value < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * returns the maximum value in the parameter array
     * @param array the array
     * @return max the largest value in the array
     */

    public static int findMax(final int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be empty");
        } else {
            int max = array[0];
            for (int value : array) {
                if (value > max) {
                    max = value;
                }
            }
            return max;
        }
    }

    /**
     * // returns an array containing the count for each value in the parameter array
     * @param anArray the array
     * @return countArray the array that stores each value's occurence in that value's index slot
     */

    public static int[] getCounters(final int[] anArray) {
        if (anArray == null) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else if (!hasAllPositiveElements(anArray)){
            throw new IllegalArgumentException("Array cannot contain any negative values");
        } else {
            //create an array for the counters that is the size of the max value + 1 to include the last element
            int[] countArray = new int[findMax(anArray) + 1];

            //traverse each value in anArray and increment the element at value's index whenever value is encountered. every other element will remain 0
            for (int value : anArray) {
                countArray[value]++;
            }
            return countArray;
        }
    }

    /**
     * // returns a sorted array based on the values of the parameter counter array
     * @param countArray the array that stores each value's occurence in that value's index slot
     * @return sortedArray the array of the sorted values
     */

    public static int[] convertCountersToSortedArray(final int[] countArray) {
        //calculate the number of elements to use for the sorted array so that 0s are excluded
        int nElements = 0;
        for (int value : countArray) {
            nElements += value; //instead of incrementing by 1, use addition so that 0s are not added to nElements
        }

        //create the sorted array using nElements, the proper size
        int[] sortedArray = new int[nElements];
        int index = 0; //create an index variable since the for loops won't use it to traverse sortedArray

        //use a nested for loop to store the amount of a value's occurence from countArray in the variable count
        for (int value = 0; value < countArray.length; value++) {
            int count = countArray[value];

            //then add value in the sortedArray that many times (count times)
            for (int i = 0; i < count; i++) {
                sortedArray[index] = value;
                index++;
            }
        }
        return sortedArray;
    }

    /**
     * // calls the other methods to sort the parameter array
     * @param anArray the array
     * @return sortedArray the sorted array
     */

    public static int[] countingSort(final int[] anArray) {

        if (anArray.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else if (!hasAllPositiveElements(anArray)){
            throw new IllegalArgumentException("Array cannot contain any negative values");
        }

        int[] countArray = getCounters(anArray);
        int[] sortedArray = convertCountersToSortedArray(countArray);

        return sortedArray;
    }

}
