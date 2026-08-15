class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;

        int resultXOR = 0;
        boolean allZero = true;

        for(int x : nums){
            resultXOR = (resultXOR ^ x);

            if(x != 0){
                allZero = false;
            }
        }

        if(allZero){
            return 0;
        }
        
        return (resultXOR == 0) ? n-1: n;
    }
}