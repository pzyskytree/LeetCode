/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.*/



class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = nums[0];//Store the majority elements.
        int count = 1;//Store the majority's number.
        for (int i = 1; i < n; i++){
            if (majority == nums[i])
                count++;
            if (majority != nums[i]){//If meet different elements cancel out the majority one.
                count--;
                if (count == 0){
                    majority = nums[i];
                    count = 1;
                }
            }
        }
        return majority;
    }
}
