/*The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<Integer> list = new ArrayList<Integer>();
        backTrack(result, list, n);
        return result;
    }
    
    public void backTrack(List<List<String>> result, List<Integer> list, int n){
        if (list.size() == n){
            List<String> positions = new ArrayList<String>();
            for (Integer i : list){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++){
                    if (i == j)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                positions.add(sb.toString());
            }
            result.add(positions);
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
                backTrack(result, list, n);
                list.remove(list.size() - 1);
            }
        }
    }  
}
