/*Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.*/

class Solution {
    public int countArrangement(int N) {
        List<Integer> list = new ArrayList<Integer>();
        return backTrack( 0 , list, N);
    }
    public int backTrack (int result, List<Integer> list, int n){
        if (list.size() == n){
            result++;
        }else{
            for (int i = 1; i <= n; i++){
                if (list.contains(i))
                    continue;
                if (i % (list.size() + 1) == 0 || (list.size() + 1) % i == 0){
                    list.add(i);
                    result = backTrack(result, list, n);
                    list.remove(list.size() - 1);
                }
            }
        }
        return result;
    }
}
