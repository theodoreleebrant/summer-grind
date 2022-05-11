/**
942. DI String Match

A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

    s[i] == 'I' if perm[i] < perm[i + 1], and
    s[i] == 'D' if perm[i] > perm[i + 1].

Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
*/

/**
Idea:
Just keep appending the (available) max and min numbers for D and I.
*/

class Solution {
    public int[] diStringMatch(String s) {
        int min = 0;
        int len = s.length();
        int max = len;
        int[] perm = new int[len + 1];
        
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = min;
                min++;
            } else {
                perm[i] = max;
                max--;
            }
        }
        
        perm[len] = min;
        
        return perm;
    }
}