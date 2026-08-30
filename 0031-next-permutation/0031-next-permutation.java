class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length; 
        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            int left =0;
            int right = n-1;

            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
            return;
        }

        for(int i = n-1; i > ind; i--){
            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        int l = ind+1;
        int r = n-1;

        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return ;

    }
}