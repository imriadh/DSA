package Lab;

import java.util.Stack;
import java.util.Scanner;
import java.util.HashMap;

public class Parenthesis {

    public static boolean areParenthesesBalanced(String str) {
        Stack<Character> s = new Stack<>();
        HashMap<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(', ')');
        parenthesesMap.put('{', '}');
        parenthesesMap.put('[', ']');

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (s.isEmpty()) {
                    return false;
                }
                char top = s.pop();
                if (parenthesesMap.get(top) != ch) {
                    return false;
                }
            }
        }

        return s.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of parentheses: ");
        String input = scanner.nextLine();

        if (areParenthesesBalanced(input)) {
            System.out.println("Balanced!");
        } else {
            System.out.println("Not Balanced!");
        }
    }
}
