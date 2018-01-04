/*Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/

class Solution {
    public List<List<Integer>> subsets(int [] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        int start = 0;
        backTrack(result, list, nums, n, start);
        return result;
    }
    
    public void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int n, int start){
        result.add(new ArrayList<Integer>(list));
        for (int i = start; i < n; i++){
            list.add(nums[i]);
            backTrack(result, list, nums, n, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
