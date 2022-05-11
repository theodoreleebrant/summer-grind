# 1641. Count Sorted Vowel Strings
# Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

# A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

# Iterative idea in the java solution.
# Math solution: this is (n+4) choose 4 (multiset problem)
# Let's say for 5 letters, we have chosen 2,1,0,0,2.
# This can only correspond to aaeuu, due to the lexicographic ordering restriction
# Therefore we have n stars and 4 bars => n+4 choose 4.

class Solution:
    def countVowelStrings(self, n: int) -> int:
        return math.comb(n+4, 4)