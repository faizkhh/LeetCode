class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); 

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop(); // Remove last '(' or invalid ')'

                if (stack.isEmpty()) {
                    stack.push(i); // Update base index for next valid substring
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}