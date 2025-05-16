/*
 * 13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. 
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. 
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

 */

 class Solution {
    public int romanToInt(String s) {

        // the string is not null assumed by the exercise, so I don't do any control
        // I used the hint to start the loop at the end, I didn't use a map though

        int convertedNumber = 0; // we will return this number for the solution
        int tempNumber = 0; // we will use this variable for the partial sum
        int previousNumber = 0; // this keep track of the previous number to solve cases like IV or VI. But we track the number on the right since we start from the ending! 

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) { // probably this approach is not the best
                case 'I':
                    tempNumber = 1;
                    break; // we translate the number position per position
                case 'V':
                    tempNumber = 5;
                    break;
                case 'X':
                    tempNumber = 10;
                    break;
                case 'L':
                    tempNumber = 50;
                    break;
                case 'C':
                    tempNumber = 100;
                    break;
                case 'D':
                    tempNumber = 500;
                    break;
                case 'M':
                    tempNumber = 1000;
                    break;
            }
            // if current value is less than what we added before, subtract it
            if (tempNumber < previousNumber) {
                convertedNumber -= tempNumber;
            } else {
                convertedNumber += tempNumber;
            }
            // update previous number for next iteration
            previousNumber = tempNumber;
        }

        return convertedNumber;
    }
}