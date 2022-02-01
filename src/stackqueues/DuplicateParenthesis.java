package stackqueues;


import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean containsDuplicate(String str) {

        Stack<Character> stack = new Stack<>();

        for(int index = 0; index < str.length(); index++) {
            char currentCharacter = str.charAt(index);

            if(currentCharacter != ')') {
                stack.push(currentCharacter);
            } else {

                int numberOfElements = 0;
                Character top = stack.pop();
                while(top != '(') {
                    top = stack.pop();
                    numberOfElements++;
                }

                if(numberOfElements < 1) {
                    return true;
                }

            }
        }
        return false;

    }

    public static void main(String[] args) {

        String str = "((1+2))";

        System.out.println(containsDuplicate(str));
    }
}
