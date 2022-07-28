# 47. Permutations II
# Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

# Idea: recurse

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        # Facilitate stopping condition
        n = len(nums)
        res = []
        
        # Make it into a dict to count
        kv = dict()
        for x in nums:
            if x in kv:
                kv[x] += 1
            else:
                kv[x] = 1
        
        def helper(curr, kv):
            if len(curr) == n:
                res.append(curr)
            for key in kv:
                if kv[key] > 0:
                    kv[key] -= 1
                    new_curr = curr[:]
                    new_curr.append(key)
                    helper(new_curr, kv)
                    kv[key] += 1
        
        helper([], kv)
        return res