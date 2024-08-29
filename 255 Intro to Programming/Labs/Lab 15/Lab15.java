package Labs.Lab15;

import java.util.ArrayList;

/**
 * Lab15.java
 * Practice recursion
 *_____________________________________________________
 * Katie Lieu
 * 5/1/24
 * CMSC 255 Section 4
 */

public class Lab15 {
    /**
     * Pattern 1 is f(n-1)+2(n-1)-1
     * @param term - the nth term of the sequence
     * @param sequence - An ArrayList that will be populated with all of
     * the previous terms
     * @return the value of the nth term in the sequence
     */
    public static int pattern1(int term, ArrayList<Integer> sequence){
        /**
         * base case where it adds 1 to the beginning and returns the term
         * to continue the recursion
         */
        if(term == 1){
            sequence.add(term);
            return term;
        }
        /**
         * recursion formula for the sequence
         */
        int result = (pattern1((term - 1), sequence) + 2 * (term - 1) - 1);
        /**
         * each result given it adds to the array list
         */
        sequence.add(result);
        return result;
    }

    /**
     * Pattern 2 is
     * if even = 3 * f(n-1)
     * if odd = f(n-1) -2
     * @param term - nth term of sequence
     * @param sequence - Arraylist of all previous term results
     * @return value of nth term in sequence
     */
    public static int pattern2(int term, ArrayList<Integer> sequence){
        /**
         * base cae for when the term becomes one and adds 4 to the beginning of the array
         */
        if(term == 1){
            term = 4;
            sequence.add(term);
            return term;
        }
        /**
         * when the term is even this initiates
         */
        else if(term % 2 == 0){
            /**
             * formula when the term is even
             */
            int result = (3 * pattern2((term - 1), sequence));
            /**
             * adds the result to the array
             */
            sequence.add(result);
            return result;
        }
        /**
         * when term is odd this initiates
         */
        else{
            /**
             * formula for when odd
             */
            int result = (pattern2((term - 1), sequence) - 2);
            /**
             * adds result to the array list
             */
            sequence.add(result);
            return result;
        }
    }

    /**
     * pattern 3 is 2 * f(n-1) - f(n-2) + n + 1
     * @param term - nth term of sequence
     * @param sequence - Arraylist of all previous term results
     * @return value of nth term in sequence
     */
    public static int pattern3(int term, ArrayList<Integer> sequence) {
        int result;
        /**
         * if the term is 1 and if the sequence does not already have it, it will add 1 to the array
         */
        if (term == 1) {
            if (!sequence.contains(1)) {
                sequence.add(1);
            }
            return 1;
        }
        /**
         * when the term is 0 then it will return 0
         */
        else if (term == 0) {
            return 0;
        }
        /**
         * will go into action for every other term
         */
        else {
            /**
             * initiates the recursion of the code
             */
            result = (2 * (pattern3(term - 1, sequence))) - (pattern3(term - 2, sequence)) + term + 1;
            /**
             * if the sequence does not already contain the number given from the recursion, it will be added to the array list
             */
            if(!sequence.contains(result)){
                sequence.add(result);
            }
        }
        /**
         * return the results
         */
        return result;
    }

    /**
     * pattern 4 is
     * if even = 2 * f(n-1)
     * if odd = f(n-1) - 1
     * @param term - nth term of sequence
     * @param sequence - Arraylist of all previous term results
     * @return value of nth term in sequence
     */
    public static int pattern4(int term, ArrayList<Integer> sequence){
        /**
         * base case when the term is 1
         */
        if(term == 1){
            /**
             * turn the term into 3 and add it to the arraylist
             */
            term = 3;
            sequence.add(term);
            return term;
        }
        /**
         * if the term is even this initiates
         */
        else if(term % 2 == 0){
            /**
             * formula for when even
             */
            int result = (2 * pattern4((term - 1), sequence));
            /**
             * add result to the array list
             */
            sequence.add(result);
            return result;
        }
        /**
         * method for when the term is odd
         */
        else{
            /**
             * formula for when term is odd
             */
            int result = (pattern4((term - 1), sequence) - 1);
            /**
             * add the result of the formula to the arraylist
             */
            sequence.add(result);
            return result;
        }
    }

    public static void main(String[] args){
        int pattern1Result = pattern1(10, new ArrayList<Integer>());
        System.out.print(pattern1Result);
        int pattern3Result = pattern3(6, new ArrayList<Integer>());
        System.out.println(pattern3Result);
    }
}
