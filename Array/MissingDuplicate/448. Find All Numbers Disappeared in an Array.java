//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

//Find all the elements of [1, n] inclusive that do not appear in this array.

//Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){//For all the number appearing, change the data under this index to be negative.
            int index= Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }
        for (int i = 0; i < n; i++)
            if(nums[i] > 0)
                result.add(i + 1);
        return result;
    }
}
