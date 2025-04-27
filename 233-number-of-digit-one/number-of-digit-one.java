public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long place = 1; // 1, 10, 100, etc.

        while (n / place > 0) {
            long current = (n / place) % 10;
            long higher = n / (place * 10);
            long lower = n % place;

            if (current == 0) {
                count += higher * place;
            } else if (current == 1) {
                count += higher * place + lower + 1;
            } else {
                count += (higher + 1) * place;
            }

            place *= 10;
        }
        return count;
    }
}
