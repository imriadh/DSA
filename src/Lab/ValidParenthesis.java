package Lab;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        // Create an array to act as our "box" (stack)
        char[] stack = new char[s.length()]; // The box can hold up to the length of the string
        int top = -1; // This keeps track of the top of the stack (initially empty)

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i); // Get the current character

            // If it's an opening bracket, add it to the box
            if (current == '(' || current == '{' || current == '[') {
                stack[++top] = current; // Add to the box and increase the top
            } 
            // If it's a closing bracket, check if it matches the last thing in the box
            else if (current == ')' || current == '}' || current == ']') {
                // If the box is empty, it's invalid (no matching opening bracket)
                if (top == -1) {
                    return false;
                }

                // Check if the current closing bracket matches the last opening bracket
                char last = stack[top]; // Get the last thing in the box
                if ((current == ')' && last == '(') || 
                    (current == '}' && last == '{') || 
                    (current == ']' && last == '[')) {
                    top--; // Remove the last thing from the box
                } else {
                    return false; // If it doesn't match, the string is invalid
                }
            }
        }

        // If the box is empty at the end, the string is valid
        return top == -1;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValid("()")); // Output: true
        System.out.println(isValid("()[]{}")); // Output: true
        System.out.println(isValid("(]")); // Output: false
        System.out.println(isValid("([])")); // Output: true
        System.out.println(isValid("([)]")); // Output: false
    }
}