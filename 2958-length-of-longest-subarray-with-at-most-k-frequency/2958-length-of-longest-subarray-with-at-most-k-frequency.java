class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int result = 0;
        int culprit = 0; 
        
        while(j < n){
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            if(mp.get(nums[j]) == k+1){
                culprit++;
            }
            if(culprit > 0){
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if(mp.get(nums[i]) == k){
                    culprit--;
                }
                i++;
            }

            if(culprit == 0){
                result = Math.max(result, j-i+1);
            }
            j++;
        }
        return result;
    }
}