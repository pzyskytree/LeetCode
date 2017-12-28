/*We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.*/

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i < n - 1){
            if (bits[i] == 0)
                i++;
            else
                i += 2;
        }
        //Just test the ending position of index i
        return i == n - 1;
    }
}
