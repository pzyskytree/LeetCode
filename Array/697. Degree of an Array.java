/*Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.*/


class Solution {
    public int findShortestSubArray(int[] nums) {
        int n =  nums.length;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int degree = 1, num = 0, result = n;
        for (int i = 0; i < n; i++){//Using hashmap to store the frequency of each elements.
            if (hash.containsKey(nums[i])){
                num = hash.get(nums[i]);
                num ++;
                degree = Math.max(num, degree);
                hash.put(nums[i], num);
            }
            else{
                hash.put(nums[i], 1);
            }
        }
        ArrayList<Integer> degreeElements = new ArrayList<Integer>();
        for (Integer i : hash.keySet() ){//Using arraylist to store all the element with frequency equal to degree.
            if (hash.get(i) == degree)
                degreeElements.add(i);
        }
        for (Integer d : degreeElements){//Scan all the elements in array list to find minimal interval among all these elements.
            int s = 0, e = n - 1;
            while (nums[s] != d)
                s++;
            while (nums[e] != d)
                e--;
            result = Math.min(result, e - s + 1);
        }
        return result;
    }
}
