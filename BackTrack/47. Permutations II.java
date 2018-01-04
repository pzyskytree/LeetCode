/*Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        boolean[] isVisit = new boolean[n];
        Arrays.sort(nums);//Because have duplicate elements you need sort
        backTrack(result, list, nums, n, isVisit);
        return result;
    }
    
    public void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int n, boolean[] isVisit){
        if (list.size() == n){
            result.add(new ArrayList<Integer>(list));
        }else{
            for (int i = 0; i < n; i++){
                if (isVisit[i] || i > 0 && nums[i - 1] == nums[i] && !isVisit[i - 1])// Check whether the same elements has 
                //already been set to this position before
                    continue;
                list.add(nums[i]);
                isVisit[i] = true;
                backTrack(result, list, nums, n, isVisit);
                isVisit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    } 
}
