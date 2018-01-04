/*Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        backTrack(result, list, nums, n);
        return result;
    }
    
    public void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int n){
        if (list.size() == n){
            result.add(new ArrayList<Integer>(list));
        }else{
            for (int i = 0; i < n; i++){//All start from 0, but check whether the elements have already been visited.
                if (list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                backTrack(result, list, nums, n);
                list.remove(list.size() - 1);
            }
        }
    } 
}
