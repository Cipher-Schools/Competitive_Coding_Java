package stackqueues;


import java.util.Stack;

public class CelebrityProblem {




    public int findCelebrity(int n) {

        Stack<Integer> stack = new Stack<>();

        //push all in stack
        for(int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int person1 = stack.pop();
            int person2 = stack.pop();

            if(knows(person1, person2)) {
                //eliminate person 1
                stack.push(person2);
            } else {
                stack.push(person1);
            }
        }

        int potentialCandidate = stack.pop();

        for(int i = 0; i < n; i++) {

            if(i != potentialCandidate && (knows(potentialCandidate, i) ||
                    !knows(i, potentialCandidate))) {
                return -1;
            }
         }

        return potentialCandidate;
    }

    private boolean knows(int person1, int person2) {
        return false;
    }

    public static void main(String[] args) {

    }
}
