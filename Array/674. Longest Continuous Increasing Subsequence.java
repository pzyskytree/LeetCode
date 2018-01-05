/*Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int result = 1;
        int len = 1;
        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i - 1])
                len++;
            else{
                result = Math.max(result, len);
                len = 1;
            }
        }
        return Math.max(result, len);
    }
}
