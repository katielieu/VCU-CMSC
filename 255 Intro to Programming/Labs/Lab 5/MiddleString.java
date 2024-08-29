/*
* Katie Lieu
* Lab 5 - MiddleString.java
* This program will compare three user-entered strings lexicographically and print the middle-valued string
*
* 2/14/24
* CMSC 255 Section 4
*/

import java.util.Scanner;

public class MiddleString {
    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);
        
        // ask for user input  
        System.out.println("Enter three strings:");
        String str1 = scnr.next();
        String str2 = scnr.next();
        String str3 = scnr.next();


        // all test case variables (comparing all the first letters)
        boolean str1BeforeStr2 = str1.compareTo(str2) < 0;
        boolean str1BeforeStr3 = str1.compareTo(str3) < 0;
        boolean str2BeforeStr3 = str2.compareTo(str3) < 0;
        boolean str2BeforeStr1 = str2.compareTo(str1) < 0;
        boolean str3BeforeStr1 = str3.compareTo(str1) < 0;
        boolean str3BeforeStr2 = str3.compareTo(str2) < 0;

        String middle = "Something went wrong";

        // evaluate all test cases and print the middle valued string
        if ((str1BeforeStr2 && str2BeforeStr3) || (str2BeforeStr1 && str1BeforeStr2)) {
            middle = str2;
        } else if ((str3BeforeStr2 && str1BeforeStr3) || (str2BeforeStr3 && str3BeforeStr1)) {
            middle = str3;
        } else {
            middle = str1;
        }

        System.out.println(middle);

    }
}