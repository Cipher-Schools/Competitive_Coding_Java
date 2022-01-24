package bactracking;


public class NQueens {


    public static boolean placeQueens(int [][] board, int row) {

        if(row == board.length) {
            //print Board
            printBoard(board);
            System.out.println();
            System.out.println();
            return false;
        }
        for(int currentCellIndex = 0; currentCellIndex < board.length; currentCellIndex++){

            if(isSafeToPlaceQueen(board, row, currentCellIndex)) {

                board[row][currentCellIndex] = 1;

               boolean isQueenPlaced =
                       placeQueens(board, row + 1);

               if(isQueenPlaced) {
                   return true;
               }
               //Backtrack
                board[row][currentCellIndex] = 0;
            }
        }
        return false;
    }

    private static void printBoard(int[][] board) {

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Check if queen is safe to place at currentCellIndex
     * @param board
     * @param currentRow
     * @param currentCellIndex
     * @return - false if not safe
     */
    private static boolean isSafeToPlaceQueen(int[][] board,
                                              int currentRow,
                                              int currentCellIndex) {

        for(int row = 0; row < currentRow; row++) {
            if (board[row][currentCellIndex] == 1) {
                return false;
            }
        }
        int row = currentRow;

        while(row >= 0) {
            if(board[row][currentCellIndex]  == 1) {
                return false;
            }
            row--;
        }

        int x = currentRow;
        int y = currentCellIndex;

        //above left Diagonal
        while(x >= 0 && y >= 0) {
            if(board[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }

         x = currentRow;
         y = currentCellIndex;
        //above Right Diagonal
        while(x >= 0 && y < board.length) {
            if(board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

    public static void main(String[] args) {
int n = 4;
int [][] board = new int[4][4];
placeQueens(board, 0);
    }
}
