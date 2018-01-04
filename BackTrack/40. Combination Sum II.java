/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int start = 0;
        int n = candidates.length;
        Arrays.sort(candidates);// There are same elements in the candidate, so we need sort to avoid use the same elements multiple times.
        backTrack(result, list, candidates, n, start, target);
        return result;
    }
    
    public void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int n, int start, int target){
        if (target <= 0){
            if (target == 0)
                result.add(new ArrayList<Integer>(list));
        }else{
            for (int i = start; i < n; i++){
                if (i > start && nums[i - 1] == nums[i])
                    continue;
                list.add(nums[i]);
                backTrack(result, list, nums, n, i + 1, target - nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
