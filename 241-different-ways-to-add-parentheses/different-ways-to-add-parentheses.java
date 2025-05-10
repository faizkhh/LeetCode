class Solution {
    
    private static Map<String, List<Integer>> memo = new HashMap<>();

    public static List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) return memo.get(expression);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If current char is an operator, divide the expression
            if (ch == '+' || ch == '-' || ch == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                // Combine all left and right results using the operator
                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (ch == '+') result.add(l + r);
                        else if (ch == '-') result.add(l - r);
                        else if (ch == '*') result.add(l * r);
                    }
                }
            }
        }

        // Base case: no operator, just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }
}