//Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

//Find all the elements that appear twice in this array.

//Could you do it without extra space and in O(n) runtime?

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){//For all the indexs that we find are negative, they appear twice  
            int index= Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                result.add(index + 1);
            else
                nums[index] = -nums[index];
        } 
        return result;
    }
}
