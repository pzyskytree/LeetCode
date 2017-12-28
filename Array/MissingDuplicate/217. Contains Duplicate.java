/*Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();//Using hashmap or set to test whether we have already meet some 
        //element.
        for (int i = 0; i < n; i++){
            if (hash.containsKey(nums[i]))
                return true;
            else
                hash.put(nums[i], 1);
        }
        return false;
    }
}

