/*Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int start = 0;
        backTrack(result, list, candidates, start, target);
        return result;
    }
    
    public void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start, int target){
        if (target <= 0){
            if (target == 0)
                result.add(new ArrayList<Integer>(list));
        }
        else{
            for (int i = start; i < nums.length; i++){
                list.add(nums[i]);
                backTrack(result, list, nums, i, target - nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }   
}
