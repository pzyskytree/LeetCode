/*A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.*/



class Solution {
    public int arrayNesting(int[] nums) {
        if (nums == null)
            return 0;
        int n = nums.length;
        int maxLength = 0, index = 0;
        HashSet<Integer> hasVisited = new HashSet<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n ; i++){
            if (hasVisited.contains(nums[i]))
                continue;
            set = new HashSet<Integer>();//Use hashset to store all the elements
            hasVisited.add(nums[i]);
            set.add(nums[i]);
            index = nums[i];
            while (!set.contains(nums[index])){
                set.add(nums[index]);
                hasVisited.add(nums[index]);
                index = nums[index];
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
