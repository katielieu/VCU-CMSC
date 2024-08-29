package Labs.Lab8;

public class Array {
    public static void main (String[] args) {
        //create the tokens array for the program arguments
        String[] tokens = args[0].split(",");
        String[] customerNames = new String[8];

        //for loop to copy each element in the tokens array
        //into the customerNames array
        for (int i = 0; i < tokens.length; i++) {
            customerNames[i] = tokens[i];
        }

        //call the displayNames method by passing customerNames
        displayNames(customerNames);

        //move the elements from index 4 and 5 to 6 and 7
        customerNames[6] = "Summer";
        customerNames[7] = "Morty";

        //add the Strings "Rick" and "Jessica" into index 4 and 5
        customerNames[4] = "Rick";
        customerNames[5] = "Jessica";

        //call the displayNames method by passing customerNames
        displayNames(customerNames);

        //call the displayNames method to output the array that
        //was returned by the reverseNames method
        displayNames(reverseNames(customerNames));

        /**
         * Are all instances of “Rick” removed correctly from the array? Yes
         * Why or why not? Can you explain what you observe in your code?
         * Why do you still have one “Rick” or how did you adjust your algorithm to not have a remaining “Rick”?
         * Before I added the decrement value for i, there was a remaining "Rick", but the point of the decrement
         * value is to recheck the current index because it got replaced. It is important bc without it, it would
         * skip the "Rick" string that occurs right after the previous "Rick"
         */
        //remove "Rick" and move the
        //remaining elements up
        for (int i = 0; i < customerNames.length; i++) {
            if (customerNames[i] != null && customerNames[i].equals("Rick")) {
                for (int j = i; j < (customerNames.length - 1); j++) {
                    customerNames[j] = customerNames[j + 1]; //shift the elements up
                }
                customerNames[customerNames.length - 1] = null; //replace the last element with null
                i--;
            }
        }

        displayNames(customerNames);
    }

    /**
     * What is displayed for the last two array elements? null is displayed
     * Why is it that value? There were no elements assigned to those positions
     */
    public static void displayNames(String[] names) {
        //for each name in names, print name
        for (String name: names) {
            System.out.println(name);
        }
        System.out.println("");
    }

    //create a method to reverse the elements in the array,
    //returning a new array

    /**
     * Is there a way to simplify this method so that you do not need to return an array?
     * Yes, the method's data type can be changed to a String and instead return each
     * element in the array using a for loop.
     */
    public static String[] reverseNames(String[] names) {
        for (int i = 0; i < (names.length - 1) / 2; i++) {
            String temp = names[i];
            names[i] = names[names.length - 1 - i];
            names[names.length - 1 - i] = temp;
        }
        return names;
    }

    //create another reverse method without returning
    //a new array
    public static void reverseNames2(String[] names) {
        for (int i = 0; i < (names.length - 1) / 2; i++) {
            String temp = names[i];
            names[i] = names[names.length - 1 - i];
            names[names.length - 1 - i] = temp;
        }
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
