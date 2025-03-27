class Solution {
    static class ParenthesisState {
        String str;
        int open, close;
        
        ParenthesisState(String str, int open, int close) {
            this.str = str;
            this.open = open;
            this.close = close;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<ParenthesisState> stack = new Stack<>();
        stack.push(new ParenthesisState("", 0, 0));

        while (!stack.isEmpty()) {
            ParenthesisState state = stack.pop();

            if (state.str.length() == 2 * n) {
                result.add(state.str);
                continue;
            }

            if (state.open < n) {
                stack.push(new ParenthesisState(state.str + "(", state.open + 1, state.close));
            }

            if (state.close < state.open) {
                stack.push(new ParenthesisState(state.str + ")", state.open, state.close + 1));
            }
        }

        return result;
        
    }
}