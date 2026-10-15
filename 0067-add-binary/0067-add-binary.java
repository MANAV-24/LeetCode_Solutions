class Solution {
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;

        int carry = 0;
        int sum = 0;

        StringBuilder res = new StringBuilder();

        while(m>=0 || n>=0){
            sum = carry;

            if(m>=0){
                sum += a.charAt(m--) - '0';
            }

            if(n>=0){
                sum += b.charAt(n--) - '0';
            }

            res.append((sum%2 == 0) ? '0' : '1');

            carry = (sum > 1) ? 1 : 0;
        }

        if(carry == 1){
            res.append('1');
        }

        return res.reverse().toString();
    }
}