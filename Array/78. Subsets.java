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
    public List<List<Integer>> subsets(int[] nums) {
        return getSubset(nums, 0);
    }
    public List<List<Integer>> getSubset(int[] nums, int start){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (start == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            result.add(list);
            return result;
        }else{
            List<List<Integer>> temp = getSubset(nums, start + 1);
            for (List list: temp){
                result.add(list);
                List<Integer> tempList = new ArrayList<Integer>(list);
                tempList.add(nums[start]);
                result.add(tempList);
            }
            return result;
        }
    }
}
//BackTrack recursive call;
 public List<List<Integer>> subsets(int [] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        backTrack(result, list, nums, 0);
        return result;
    }
    public void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start){
        result.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backTrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
