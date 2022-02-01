package stackqueues;


import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {

        int currentNumber = 0;
        int ans = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index < s.length(); index++) {
            char currentCharacter = s.charAt(index);

            if(Character.isDigit(currentCharacter)) {

               currentNumber = currentCharacter - '0';

               while(index + 1 < s.length() && Character.isDigit(s.charAt(index + 1))) {
                   currentNumber = currentNumber * 10 + s.charAt(index + 1) - '0';
                   index++;
               }
               currentNumber = currentNumber * sign;
               ans = ans + currentNumber;
               currentNumber = 0;
            } else if (s.charAt(index)  == '+') {
                sign = 1;
            } else if (s.charAt(index)  == '-'){
                sign = -1;
            } else if(s.charAt(index) == '(') {
                stack.push(ans);
                ans = 0;
                stack.push(sign);
                sign = 1;
            } else if(s.charAt(index) == ')') {
                int prevSign = stack.pop();
                ans = ans * prevSign;
                int prevAns = stack.pop();
                ans = ans + prevAns;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
