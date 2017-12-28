/*On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum 
cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;
        int n = cost.length;
        int[] minCost = new int [n+1];//DP
        minCost[0] = 0;
        minCost[1] = cost[0];
        for (int i = 2; i < n + 1; i++){
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 1]);
        }
        return Math.min(minCost[n], minCost[n - 1]);//Should compare the last two elements.
    }
}
