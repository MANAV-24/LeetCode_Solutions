class Solution {
    public int minimumPushes(String word) {

        int result =0;
        int[] arr = new int[10];
        int assign_key = 2;

        for(char ch: word.toCharArray()){
            if(assign_key > 9){
                assign_key = 2;
            }

            arr[assign_key]++;
            result += arr[assign_key];
            assign_key++;
        }
        return result;
    }
}