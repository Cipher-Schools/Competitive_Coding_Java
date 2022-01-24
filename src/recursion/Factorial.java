package recursion;


public class Factorial {


    public static int factorial(int n) {

        if(n <= 1) {
            return n;
        }
        //I.H
        int smallAns =
                factorial(n - 1);

        //I.S
        int bigAns = smallAns * n;

        return bigAns;
    }


    public static int factorialUsinTail(int n, int number) {

if(n <= 1) {
    return number;
}
        return  factorialUsinTail(n - 1, number * n);
    }


    public static int fib(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n -2);
    }


    public static int fib(int n, int a , int b) {
        if(n == 0 || n == 1) {
            return b;
        }
        return fib(n - 1, b, a + b);
    }
    public static void main(String[] args) {

        System.out.println(fib(5, 1, 1));

    }
}
