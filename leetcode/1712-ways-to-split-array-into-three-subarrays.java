/**
1712. Ways to Split Array Into Three Subarrays

A split of an integer array is good if:

    The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
    The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements in mid is less than or equal to the sum of the elements in right.

Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large, return it modulo 10^9 + 7.
*/

/**
Idea:
The most important information we need to know is the sum
between the i-th and j-th entries, where i < j and both
are in range. 

A prefix sum would suffice (+1 subtraction op if needed)

Since we need only 3 subarrays,
fix the first pivot, and try to find available second pivots

condition for second pivot to be valid is
first array < second array < third array

This is equivalent to
prefix sum at pivot 1 
    < prefix sum at pivot 2 - prefix sum at pivot 1
    < total sum - prefix sum at pivot 2

Considering the inequalities separately
lower bound: secondSum > 2 * firstSum
upper bound: 2 * secondSum < totalSum + firstSum

*/

class Solution {
    public int waysToSplit(int[] nums) {
        int res = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        int totalSum = prefixSum[nums.length - 1];
        // vary the first pivot
        for (int pivot1 = 0; pivot1 < nums.length - 2; pivot1++) {
            int firstSum = prefixSum[pivot1];
            
            // Find minimum second pivot
            int left = pivot1 + 1;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (prefixSum[mid] < firstSum * 2) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int minPivot2 = left;
            
            // Find maximum second pivot
            left = pivot1 + 1;
            right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (2 * prefixSum[mid] > firstSum + totalSum) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int maxPivot2 = left;
            
            if (minPivot2 < maxPivot2) {
                res = res + maxPivot2 - minPivot2;
                res = res % 1000000007;
            }
        }
        return res;
    }
}
