/*Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.*/

class Solution {
    public int totalNQueens(int n) {
        int result = 0;
        List<Integer> list = new ArrayList<Integer>();
        return backTrack(result, list, n);
    }
    
    public int backTrack(int result, List<Integer> list, int n){
        if (list.size() == n){
            result++;
        }else{
            for (int i = 0; i < n; i++){
                if (list.contains(i))
                    continue;
                int j = list.size() - 1;
                for (; j >= 0; j--){
                    if (list.get(j) == i - j + list.size() || list.get(j) == i - list.size() + j)
                        break;
                }
                if (j >= 0)
                    continue;
                list.add(i);
                result = backTrack(result, list, n);
                list.remove(list.size() - 1);
            }
        }
        return result;
    }  
}



