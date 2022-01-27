package bactracking;


import java.util.HashSet;

public class Soduko {

    public static boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    String rowData = "row" + i + board[i][j];
                    String colData = "col" + j + board[i][j];

                    String boxData = "box" + ((i / 3) * 3 + (j / 3)) + board[i][j];


                    if (!set.add(rowData)) {
                        return false;
                    }

                    if (!set.add(colData)) {
                        return false;
                    }

                    if (!set.add(boxData)) {
                        return false;
                    }

                }
            }
        }

        return true;

}

    public static void main(String[] args) {

    }
}
