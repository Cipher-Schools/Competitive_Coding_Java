package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author amgarg
 */
public class GenerateParentheses {


    public static ArrayList<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        printBalanceParenthesis(n, n ,"");
        return  list;

    }
    public static void printBalanceParenthesis(int open, int close, String output) {

        if(close < open) {
            return;
        }
        if(open == 0 && close == 0) {
            System.out.println(output);
           list.add(output);
            return;
        }

        if(open > 0 ) {
            String newString = output + "(";
            printBalanceParenthesis(open - 1, close, newString);
        }


        if(close > 0 ) {
            String newString = output + ")";
            printBalanceParenthesis(open, close - 1, newString);
        }
    }

    public static void main(String[] args) {
        printBalanceParenthesis(1, 1, "");

        for(String str : list) {
            System.out.println(str);
        }



        int a = 14;


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int [] arr = new int[5];


        System.out.println(a);
    }
}
