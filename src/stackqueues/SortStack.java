package stackqueues;


import java.util.Stack;

public class SortStack {



    public static void sort(Stack<Integer> stack) {


        if(stack.isEmpty() ) {
            return;
        }

        int element = stack.pop();
        sort(stack);
        addElementAtCorrectPositionInStack(stack, element);
    }

    private static void addElementAtCorrectPositionInStack(Stack<Integer> stack, int element) {

        if(stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int tempElement = stack.pop();
        addElementAtCorrectPositionInStack(stack, element);
        stack.push(tempElement);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(9);
        stack.push(8);

        sort(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
