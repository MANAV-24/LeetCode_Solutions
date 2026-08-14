class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[128];
        int maxLength = 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            char currentChar = s.charAt(right);
            freq[currentChar]++;

            while(freq[currentChar] > 1){
                freq[s.charAt(left)]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
        
    }
}