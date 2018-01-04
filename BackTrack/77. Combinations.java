class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        backTrack(result, list, n, 1, k);
        return result;
    }
    public void backTrack (List<List<Integer>> result, List<Integer> list, int n, int start, int k){
        if (list.size() == k){
            result.add(new ArrayList<Integer>(list));
        }else{
            for (int i = start; i <= n; i++){
                list.add(i);
                backTrack(result, list, n, i + 1, k);
                list.remove(list.size() - 1);
            }
        }
    }
}
