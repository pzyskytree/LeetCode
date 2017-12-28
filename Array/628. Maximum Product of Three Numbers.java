/*Given an integer array, find three numbers whose product is maximum and output the maximum product.*/


class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;//Just find the max three numbers and least two numbers, and compare 
        //the product between max1*max2*max3 and min1*min2*max1
        for (int i = 0; i < n; i++){
            if (nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else{
                if (nums[i] > max2){
                    max3 = max2;
                    max2 = nums[i];
                }
                else{
                    if (nums[i] > max3)
                        max3 = nums[i];
                }
            }
            if (nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }else{
                if (nums[i] < min2)
                    min2 = nums[i];
            }
        }
        return Math.max(min1*min2*max1, max1*max2*max3);
    }
}
