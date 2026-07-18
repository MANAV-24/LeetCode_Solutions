class Solution {
    public int DaysReq(int[] weights, int mid){
        int days = 1; int load = 0;
        for(int i=0; i<weights.length; i++){
            if(weights[i] + load > mid){
                days += 1;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int low = Integer.MIN_VALUE;
        for(int num : weights){
            low = Math.max(low, num);
        }

        int high = 0;
        for (int num : weights) {
            high += num;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int noOfDays = DaysReq(weights, mid);

            if(noOfDays <= days){
                high = mid-1;
            }else{
                low = mid+1; 
            }
        }
        return low;
    }
}