class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[50];
        int[] arr2 = new int[50];

        int n1=0; int n2=0;

        arr1[n1] = nums[0]; n1++;
        arr2[n2] = nums[1]; n2++;

        for(int i=2; i<nums.length; i++){
            if(arr1[n1-1] > arr2[n2-1]){
                arr1[n1] = nums[i];
                n1++;
            }else{
                arr2[n2] = nums[i];
                n2++;
            }
        }

        int[] result = new int[nums.length];
        int k = 0;

        for(int i=0; i<n1; i++){
            result[k] = arr1[i];
            k++;
        }
        
        for(int i=0; i<n2; i++){
            result[k] = arr2[i];
            k++;
        }

        return result;
    }
}