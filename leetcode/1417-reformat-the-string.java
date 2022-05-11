/**
1417. Reformat The String
Difficulty: Easy

You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.
**/

/**
Solution idea:
Impossibility check:
This can only happen if the number of
digits and the number of letters differ
at most by 1.

Solution:
1. Get the letters and digits in some data structure
2. Compare the size of the data structure
3a. Return "" if size differs by more than one
3b. Build the string by popping the DS alternately
**/

class Solution {
    public String reformat(String s) {
        ArrayList<Character> letters = new ArrayList<>();
        ArrayList<Character> digits = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                digits.add(currChar);
            } else {
                letters.add(currChar);
            }
        }
        
        if (Math.abs(letters.size() - digits.size()) > 1) {
            return "";
        }
        
        Iterator<Character> smallLst = (letters.size() < digits.size() ? letters : digits).iterator();
        Iterator<Character> largeLst = (letters.size() < digits.size() ? digits : letters).iterator();
        String res = "";
        
        while (largeLst.hasNext()) {
            res = res + largeLst.next();
            if (smallLst.hasNext()) {
                res = res + smallLst.next();
            }
        }
        
        return res;
    }
}