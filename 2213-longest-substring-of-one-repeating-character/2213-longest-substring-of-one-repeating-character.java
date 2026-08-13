class Solution {
    class Node{
        char leftChar;
        char rightChar;
        int prefix;
        int suffix;
        int max;
        int length;

        Node(char ch){
            leftChar = ch;
            rightChar = ch;
            prefix = 1;
            suffix = 1;
            max = 1;
            length =1;
        }
    }

    Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();

        tree = new Node[4*n];

        build(1, 0, n-1, s);

        int k = queryIndices.length;
        int[] ans = new int[k];   

        for(int i = 0; i < k;i++){
            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n-1, index, ch);

            ans[i] = tree[1].max;
        }      
        return ans;
    }

    void build(int node, int start, int end, String s){
        
        if(start == end){
            tree[node] = new Node(s.charAt(start));
            return;
        }

        int mid = start + (end-start) / 2;

        build(node * 2, start, mid, s);
        build(node * 2 +1, mid+1, end, s);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int start, int end, int index, char ch){

        if(start == end){
            tree[node] = new Node(ch);
            return;
        }

        int mid = start + (end - start) / 2;

        if(index <= mid){
            update(node * 2, start, mid, index, ch);
        }else{
            update(node * 2 + 1, mid + 1, end, index, ch);
        }

        tree[node] = merge(tree[node*2], tree[node*2+1]);
    }

    Node merge(Node left, Node right){
        Node result = new Node(left.leftChar);

        result.leftChar = left.leftChar;
        result.rightChar = right.rightChar;

        result.length = left.length + right.length;

        result.prefix = left.prefix;

        if(left.prefix == left.length && left.rightChar == right.leftChar){
            result.prefix = left.length + right.prefix;
        }

        result.suffix = right.suffix;

        if(right.suffix == right.length && left.rightChar == right.leftChar){
            result.suffix = right.length + left.suffix;
        }

        result.max = Math.max(left.max, right.max);

        if(left.rightChar == right.leftChar){
            result.max = Math.max(result.max, left.suffix + right.prefix);
        }

        return result;
    }
}