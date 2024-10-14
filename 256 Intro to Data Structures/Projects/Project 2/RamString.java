/**
 * This program
 *
 * @modified on 9/13/24 by Katie Lieu
 * CMSC 256 Section 901
 */

package cmsc256;

public class RamString implements WackyStringInterface{

    private String string;

    /**
     * Default constructor of RamString - sets string equal to "CS@VCU!"
     */
    public RamString() {
        string = "CS@VCU!";
    }

    /**
     * Parameterized constructor of RamString - sets string equal to the value of the current string if it is not null
     * @param string
     */
    public RamString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        this.string = string;
    }

    /**
     * Sets the value of the current string.
     *
     * @param string
     *            The value to be set
     */
    @Override
    public void setWackyString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        this.string = string;
    }

    /**
     * Returns the current string
     *
     * @return Current string
     */
    @Override
    public String getWackyString() {
        return string;
    }

    /**
     * Returns a string that consists of all and only the characters
     * in every fourth positions (i.e., fourth, eighth, and so on) in
     * the current string, in the same order and with the same case as
     * in the current string. The first character in the string is
     * considered to be in Position 1.
     *
     * @return String made of characters in every fourth positions in the
     * current string
     */
    @Override
    public String getEveryFourthCharacter() {
        StringBuilder newString = new StringBuilder(); //create a newString variable

        //start the index at 3 (position 4) and increment by 4
        for (int i = 3; i < string.length(); i += 4) {
            newString.append(string.charAt(i)); //append the newString with the characters at every fourth position
        }
        return newString.toString(); //convert the StringBuilder back to a string and return that
    }

    /**
     * Returns a string that consists of all and only the characters
     * in either the odd positions (i.e., first, third, fifth, and so on)
     * or in the even positions (i.e., second, fourth, sixth, and so on)
     * current string, in the same order and with the same case as in
     * the current string. The first character in the string is
     * considered to be in Position 1.
     * @return String made of characters in odd positions in the
     * current string
     * @throws  IllegalArgumentException if parameter is other than "odd" or "even"
     */
    @Override
    public String getEvenOrOddCharacters(String evenOrOdd) {
        StringBuilder newString = new StringBuilder(); //create a newString variable

        //if the input is even
        if(evenOrOdd.equals("even")) {
            //start the index at 1 (position 2) and increment by 2
            for (int i = 1; i < string.length(); i += 2) {
                newString.append(string.charAt(i)); //append the newString with the characters at the even positions
            }
            //if the input is odd
        } else if (evenOrOdd.equals("odd")) {
            //increment i by 2
            for (int i = 0; i < string.length(); i += 2) {
                newString.append(string.charAt(i)); //append the newString with the characters at the odd positions
            }
            //throw an illegal argument exception if the input is neither even nor odd
        } else {
            throw new IllegalArgumentException("Enter \"even\" or \"odd\" as the input.");
        }
        return newString.toString(); //convert the StringBuilder back to a string and return that
    }

    /**
     * Returns the number of characters that are digits in the current string.
     *
     * @return Number of digits in the current string
     */
    @Override
    public int countDigits() {
        int nDigits = 0; //set default number of digits to 0

        //traverse the string
        for (int i = 0; i < string.length(); i++) {
            //check if the characters in the string are in between 0-9
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                nDigits += 1; //add 1 to nDigits if true
            }
        }
        return nDigits;
    }

    /**
     * Returns true if the current string contains on or more characters
     * before an '@' character, followed by "vcu.edu"
     * For example, RodneyTheRam@vcu.edu a valid vcu email address also
     * and RamFan@gmail.com is not.
     *
     * @return true if current string is formated as valid VCU email address
     * 	        Returns false otherwise.
     */
    @Override
    public boolean isValidVCUEmail() {
        //verify that string is not empty, contains an @, and ends with vcu.edu
        if (string != null && string.contains("@") && string.endsWith("vcu.edu")) {
            //store the segment of the string before the @
            String prefix = string.substring(0, string.indexOf("@"));
            //return true if the prefix is not empty
            return !prefix.isEmpty();
        }
        //otherwise return false if not all the conditions are met
        return false;
    }

    /**
     * Extracts a phone number (with area code) from this String and returns it
     * in a standard format with the area code in parenthesis followed by a
     * then a dash separating the third and fourth digits "(000) 000-0000"
     * space if this string does not contain exactly 10 digits, returns the
     * message "This WackyString is not a phone number."
     * Note: any characters that are not digits should not be included
     *   in the returned string.
     *   For example: "Office phone: 804-828-7135" --> "(804) 828-7135"
     *
     =	 * @return			String containing the formatted phone number
     */
    @Override
    public String standardizePhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        int nDigits = countDigits(); //use countDigits method to get the number of digits

        //return a message if the string does not contain 10 digits
        if (nDigits != 10) throw new IllegalArgumentException("This WackyString is not a phone number.");

        //if there are digit characters in the string then store them
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                phoneNumber.append(string.charAt(i));
            }
        }

        //make variables for each phone number segment
        StringBuilder segment1 = new StringBuilder();
        StringBuilder segment2 = new StringBuilder();
        StringBuilder segment3 = new StringBuilder();

        //put the right amount of numbers in the correct segments
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (i < 3) {
                segment1.append(phoneNumber.charAt(i));
            } else if (i < 6) {
                segment2.append(phoneNumber.charAt(i));
            } else if (i < 10) {
                segment3.append(phoneNumber.charAt(i));
            }

        }
        return ("(" + segment1.toString() + ") " + segment2.toString() + "-" + segment3.toString()); //return formatted phone number
    }

    /**
     * Replace all occurrences of a single zero (0) with the string "Go Rams"
     * in the current string,
     * and all occurrences of a double zero (00) with the string "CS@VCU"
     */
    @Override
    public void ramifyString() {
        StringBuilder currentString = new StringBuilder(string);

        for (int i = 0; i < currentString.length(); i++) {
            //check for double '00', but ensure it's not part of a larger group and is not preceded or followed by spaces or other zeros
            if (i < currentString.length() - 1 && currentString.charAt(i) == '0' && currentString.charAt(i + 1) == '0') {
                //ensure it's exactly two zeros (not part of a longer chain like '000') and not surrounded by spaces
                if ((i + 2 >= currentString.length() || currentString.charAt(i + 2) != '0') &&
                        (i == 0 || currentString.charAt(i - 1) != '0')) {
                    currentString.replace(i, i + 2, "CS@VCU");
                    i += "CS@VCU".length() - 1;  //adjust the index after replacement
                }
            }
            //check for a single '0', but ensure it's not part of a larger group and is not surrounded by spaces
            else if (currentString.charAt(i) == '0') {
                if ((i + 1 >= currentString.length() || currentString.charAt(i + 1) != '0') &&
                        (i == 0 || currentString.charAt(i - 1) != '0')) {
                    currentString.replace(i, i + 1, "Go Rams");
                    i += "Go Rams".length() - 1;  //adjust the index after replacement
                }
            }
        }

        //update the instance variable
        string = currentString.toString();
    }

    /**
     * Replace the _individual_ digits in the current string, between
     * startPosition and endPosition (included), with the corresponding
     * Roman numeral symbol(s). The first character in the string is
     * considered to be in Position 1. Digits are converted individually,
     * even if contiguous, and digit "0" is not converted (e.g., 460 is
     * converted to IVVI0). In case you are not familiar with Roman
     * numerals, see https://en.wikipedia.org/wiki/Roman_numerals
     *
     * @param startPosition  Position of the first character to consider
     * @param endPosition    Position of the last character to consider
     * @throws IllegalArgumentException
     *            If "startPosition" > "endPosition" (but both are
     *            within bounds)
     *         IndexOutOfBoundsException
     *         		If either "startPosition" or "endPosition" are out of
     *           	bounds (i.e., either less than 1 or greater than the
     *           	length of the string)
     */
    @Override
    public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition) throws IllegalArgumentException, IndexOutOfBoundsException {
        //check if positions are within the valid range of the string
        if (startPosition < 1 || endPosition > string.length() || startPosition > endPosition) {
            if (startPosition > endPosition) {
                throw new IllegalArgumentException("Start position cannot be greater than end position.");
            } else {
                throw new IndexOutOfBoundsException("Positions are out of the string bounds.");
            }
        }

        //roman numeral list for digits 1 to 9
        String[] romanNumerals = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder currentString = new StringBuilder(string);

        //iterate through the substring range (convert back to normal indices)
        for (int i = startPosition - 1; i < endPosition; i++) {
            char currentChar = currentString.charAt(i);

            //check if the character is a digit
            if (Character.isDigit(currentChar)) {
                int digit = Character.getNumericValue(currentChar);

                //only convert digits 1-9, leave 0 unchanged
                if (digit >= 1 && digit <= 9) {
                    currentString.replace(i, i + 1, romanNumerals[digit]);
                    i += romanNumerals[digit].length() - 1; //adjust index if a replacement changes length
                }
            }
        }

        //update the instance variable
        string = currentString.toString();
    }

}
