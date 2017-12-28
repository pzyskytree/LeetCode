/*Find all possible combinations of k numbers that add up to a number n, given that only numbers from 
1 to 9 can be used and each combination should be a unique set of numbers.*/

class Solution {
    //Backtracking
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        sum(result, list, k, n, 1);
        return result;
    }
    public void sum(List<List<Integer>> result, List<Integer> list, int k, int n, int start){
        if (list.size() == k || n < 0 ){
            if (n == 0){
                List<Integer> li = new ArrayList<Integer>(list);
                result.add(li);
            }
        }else{
            for (int i = start; i <= 9; i++){
                list.add(i);
                sum(result, list, k, n - i, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    //Recursive call get solution of subproblem.
    public List<List<Integer>> combinationSum3(int k, int n) {
        return sum(k, 1, n);
    }
    public List<List<Integer>> sum(int k, int start, int n){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 0 || n < 0 || start > 9){
            if (n == 0 && k == 0){
                ArrayList<Integer> list = new ArrayList<Integer>();
                result.add(list);
                return result;
            }
            return null;
        }
        else{
            for (int i = start; i < 10; i++){
                List<List<Integer>> temp = sum(k - 1, i + 1, n - i);
                if (temp != null){
                    for (List<Integer> list: temp){
                        list.add(i);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
