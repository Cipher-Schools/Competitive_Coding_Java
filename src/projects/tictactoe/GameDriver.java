package projects.tictactoe;

/**
 * @author amgarg
 */
public class GameDriver {

    public static void main(String[] args) {
        System.out.println("Game Starts...\n\n");

       Board board = new Board();
       boolean humanTurn = true;
       while(!board.isGameOver()) {
           board.displayBoard();
           if(humanTurn) {
               board.takeHumanInput();
           } else {
               board.computerMove();
           }
           humanTurn = !humanTurn;
       }

        board.displayBoard();
        System.out.println(board.hasXWon() ? "Computer Won" : "Draw");


        System.out.println("\n\nGame Ends.....");
    }
}
