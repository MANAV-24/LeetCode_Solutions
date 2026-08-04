class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>(); 
        int j=0;
        for(int i=nums[0]; i <= nums[n-1]; i++){
            if(nums[j] == i){
                j++;
            }else{
                list.add(i);
            }
        }
        return list;
    }
}