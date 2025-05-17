class Solution {
    public int numMatchingSubseq(String s, String[] words) {
         int count = 0;
        Map<String, Boolean> memo = new HashMap<>();

        for (String word : words) {
            if (memo.containsKey(word)) {
                if (memo.get(word)) count++;
            } else {
                boolean isSub = isSubsequence(word, s);
                memo.put(word, isSub);
                if (isSub) count++;
            }
        }
        return count;
    }
    private static boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;

        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}