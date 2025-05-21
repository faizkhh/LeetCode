class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // last occurrence of each character

        // Step 1: Store the last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();

        // Step 2: Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If character already in stack, skip it
            if (seen.contains(c)) continue;

            // Step 3: Maintain lexicographical order
            while (!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                seen.remove(stack.pop());
            }

            stack.push(c);
            seen.add(c);
        }

        // Step 4: Build final result
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
        }
        
    }