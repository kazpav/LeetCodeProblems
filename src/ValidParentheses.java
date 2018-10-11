package ConcurrencyWork;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {


        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            // If we have current char in keys, add it to the stack
            if (map.keySet().contains(curr)) {
                stack.push(curr);
                // if we have current char in values
            } else if (map.values().contains(curr)) {
                // If stack isn't empty and stack top == current char
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    //delete top char from stack
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
