Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null)
            return null;
        int n = nums.length;
        int[] result = new int[n];
        int product = 1;
        //Use two loop to calculate the prefix and suffix product;
        for (int i = 0; i < n; i++){
            result[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = n-1; i >= 0; i--){
            result[i] = result[i]*product;
            product *= nums[i]; 
        }
        return result;
    }
}
