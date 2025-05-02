class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) return 0;

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (k <= mid) {
            // First half: same as the previous row
            return kthGrammar(n - 1, k);
        } else {
            // Second half: flip the previous result
            return 1 - kthGrammar(n - 1, k - mid);
        }
        
    }
}