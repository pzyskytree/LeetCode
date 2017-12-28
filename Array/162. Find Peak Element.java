/*A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.*/

class Solution {
    //Binary search
    public int findPeakElement (int[] nums){
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <  end){
            int mid = (start + end)/2;
            if (nums[mid] < nums[mid + 1])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
    //Linar Search
    public int findPeakElement(int[] nums) {
       if (nums == null ||  nums.length == 0)
           return -1;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++){
            if (nums[i] > nums[i + 1])
                return i;
        }
        return n - 1;
    }
}
