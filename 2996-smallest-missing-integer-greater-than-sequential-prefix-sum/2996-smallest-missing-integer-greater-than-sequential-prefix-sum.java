class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();

        for(int num:nums){
            st.add(num);
        }

        int sequential = nums[0];
        for(int j=1; j<n;j++){
            if(nums[j] == nums[j-1]+1){
                sequential += nums[j];
            }else{
                break;
            }
        }
        
        while(st.contains(sequential)){
            sequential++;
        }

        return sequential;
    }
}