class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int prod = 1;
            int cpy = n;
            while(cpy != 0){
                int rightMostDigit = cpy%10;
                prod *= rightMostDigit;
                cpy /= 10;
            }
            if(prod%t == 0) return n;
            n++;
        }
    }
}