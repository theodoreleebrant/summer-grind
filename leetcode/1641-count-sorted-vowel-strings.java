/**
1641. Count Sorted Vowel Strings
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
*/

/**
Idea:
Without restriction, we have aeiou

If the prior letter is a, it is unrestricted
If the prior letter is e, we only have 3 options.
...

1 -> []aeiou
2 -> [a]aeiou, [e]eiou, ...
  sorted by last letter: 1a, 2e, 3i, 4o, 5u
3 -> 1a, 3e, 6i, 10o, 15u
Note that the 1a in (3) comes from the 1a in (2)
The 3e in (3) comes from the 1a+2e in (2)
The 6i in (3) comes from 1a+2e+6i in (2)
*/

class Solution {
    public int countVowelStrings(int n) {
        int[] prev = new int[]{1, 1, 1, 1, 1};
        int[] curr = new int[]{1, 1, 1, 1, 1};
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                curr[j] = 0;
                for (int k = 0; k <= j; k++) {
                    curr[j] += prev[k];
                }
            }
            
            for (int j = 0; j < 5; j++) {
                prev[j] = curr[j];
            }
        }
        
        int res = 0;
        
        for (int i = 0; i < 5; i++) {
            res += curr[i];
        }
        
        return res;
    }
}