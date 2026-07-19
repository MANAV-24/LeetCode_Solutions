class Solution {
    public int countSubarrays(int[] nums, long maxSum) {
        int subarrays = 1;
        long currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum + nums[i] <= maxSum) {
                currentSum += nums[i];
            } else {
                subarrays++;
                currentSum = nums[i];
            }
        }
        return subarrays;
    }

    public int splitArray(int[] nums, int k) {

        long low = 0;
        long high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;
            int subarrays = countSubarrays(nums, mid);
            if (subarrays > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) low;
    }
}