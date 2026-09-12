class Solution {
    class State {
        long score;
        List<Integer> indices;
        State(long score, List<Integer> indices){
            this.score = score;
            this.indices = indices;
        }
    }
    int[][] a;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        a = new int[n][4];
        for(int i=0; i< n; i++){
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }    

        Arrays.sort(a, (x,y) -> {
            if(x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            }
            return Integer.compare(x[3], y[3]);
        });

        State[][] dp = new State[n+1][5];

        for(int k=0; k<=4; k++){
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for(int i=0; i<=n; i++){
            dp[i][0] = new State(0, new ArrayList<>());
        }

        for(int i=n-1; i>=0; i-- ){
            for(int k=1; k<=4; k++){
                State skip = dp[i+1][k];

                int next = findNext(i);
                State takeNext = dp[next][k-1];
                List<Integer> takeIndices = new ArrayList<>(takeNext.indices);

                takeIndices.add(a[i][3]);

                Collections.sort(takeIndices);
                State take = new State(
                    a[i][2] + takeNext.score,
                    takeIndices
                );
                dp[i][k] = better(skip, take);
            }
        }

        List<Integer> answer = dp[0][4].indices;
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }

    int findNext(int i){
        int left = i+1;
        int right = n;
        int end = a[i][1];

        while(left < right){
            int mid = left + (right - left) /2;
            if(a[mid][0] > end){
                right = mid;
            }else{
                left =mid+1;
            }
        }
        return left;
    }

    State better(State a, State b) {
        if(a.score != b.score){
            return a.score > b.score ? a : b;
        }

        if(lexicographicallySmaller(a.indices, b.indices)){
            return a;
        }

        return b;
    }

    boolean lexicographicallySmaller(
        List<Integer> a,
        List<Integer> b){

        for(int i=0; i < Math.min(a.size(), b.size()); i++){
            if(!a.get(i).equals(b.get(i))){
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();

    }
    
}