# 1417. Reformat The String
# Difficulty: Easy

# You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

# You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

# Return the reformatted string or return an empty string if it is impossible to reformat the string.


# Solution idea:
# Impossibility check:
# This can only happen if the number of
# digits and the number of letters differ
# at most by 1.

# Solution:
# 1. Get the letters and digits in some data structure
# 2. Compare the size of the data structure
# 3a. Return "" if size differs by more than one
# 3b. Build the string by popping the DS alternately

class Solution:
    def reformat(self, s: str) -> str:
        res = ""
        
        digits = [x for x in s if x.isdigit()]
        letters = [x for x in s if not x.isdigit()]
        
        if abs(len(digits) - len(letters)) > 1:
            return res
        
        longer_list = digits if len(digits) > len(letters) else letters
        shorter_list = letters if len(digits) > len(letters) else digits
        
        
        for i in range(len(longer_list)):
            res += longer_list[i]
            if i < len(shorter_list):
                res += shorter_list[i]
                
        return res


# Faster solution, but uglier
class Solution:
    def reformat(self, s: str) -> str:
        res = ""
        
        digits, letters = [], []
        
        for x in s:
            digits.append(x) if x.isdigit() else letters.append(x)
        
        length_difference = len(digits) - len(letters)
        
        if abs(length_difference) > 1:
            return res
        
        longer_list = digits if length_difference > 0 else letters
        shorter_list = letters if length_difference > 0 else digits
        
        
        for i in range(len(longer_list)):
            res += longer_list[i]
            if i < len(shorter_list):
                res += shorter_list[i]
                
        return res