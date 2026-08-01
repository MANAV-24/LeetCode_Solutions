class Solution {

    public int solve(int i, int j, int[] nums){
        if(i > j){
            return 0;
        }
        if(i == j){
            return nums[i];
        }

        int take_i = nums[i] - solve(i+1, j, nums);
        int take_j = nums[j] - solve(i, j-1, nums);

        return Math.max(take_i, take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        return solve(0, n-1, nums) >= 0;
        
        
    }
}