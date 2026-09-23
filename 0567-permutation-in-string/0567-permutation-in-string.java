class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m){
            return false;
        }
        
        int[] s1_freq = new int[26];
        int[] s2_freq = new int[26];

        for(char ch : s1.toCharArray()){
            s1_freq[ch - 'a']++;
        }

        int i = 0;
        int j = 0;

        while(j < m){
            s2_freq[s2.charAt(j) - 'a']++;

            if(j-i+1 > n){
                s2_freq[s2.charAt(i) - 'a']--;
                i++;
            }

            if(Arrays.equals(s1_freq, s2_freq)){
                return true;
            }
            j++;
        }

        return false;
    }
}