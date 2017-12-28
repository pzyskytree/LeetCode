/*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.*/

class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        int fast = nums[0];//Using two pointer one fast one slow to detect the cycle. 
        int slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while (fast != slow);
        fast = nums[0];
        while (fast != slow){//To detect the entrance of the cycle which is the duplicate elements.
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
