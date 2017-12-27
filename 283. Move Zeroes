/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/


class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;//First pointer points to the first 0
        for (; i < n && nums[i] != 0; i++);
        int j = i + 1;//Second pointer scans all the integer behind i
        for (; j < n; j++){
            if (nums[j] != 0){
                nums[i++] = nums[j];
                nums[j] = 0;
            }
        }    
    }
}
