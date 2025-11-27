
import java.util.Scanner;

class TicTacToeGame{
    char[][] board;

    public TicTacToeGame()
    {
        board = new char[3][3];
        generateBoard();
    }

    void generateBoard()
    {
        for(int row = 0; row<board.length; row++)
        {
            for(int column = 0; column<board[row].length; column++)
            {
                board[row][column] = ' ';
            }
        }
    }

    void displayBoard()
    {
        System.out.println("---------------");
        for(int row = 0; row<board.length; row++)
        {
            System.out.print(" | ");
            for(int column = 0; column<board[row].length; column++)
            {
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }

    boolean placeValue(int row, int col, char player)
    {
         if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid position! Try again.");
            return false;
        }
        if (board[row][col] != ' ') {
            System.out.println("Cell already filled! Choose another.");
            return false;
        }

        board[row][col] = player;
        return true;

        
    }

    boolean checkWin(char player)
    {
        //row check
        for(int row = 0; row < board.length; row++)
        {
            if(board[row][0] == player && board[row][1] == player && board[row][2]== player)
            {
                return true;
            }
        }
        //column check
        for(int col = 0; col < board.length; col++)
        {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player)
            {
                return true;
            }
        }
        //diagonal check
        {
            if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
            {
                return true;
            }
            else if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
            {
                return true;
            }
        }

        return false;
    }

    boolean isBoardfull()
    {
        for(int row = 0; row<3; row++)
            for(int col = 0; col < 3; col++)
                if(board[row][col] == ' ')
                    return false;
        return true;
    }

}
public class TicTacToe {
    public static void main(String[] args) {
        TicTacToeGame tictactoe = new TicTacToeGame();

        Scanner scanner = new Scanner(System.in);

        boolean gameOver = false;
        char player ='X';
        tictactoe.displayBoard();
        while(!gameOver)
        {
            System.out.println("Player " +player+ " Enter the row and Column: ");
            int row =  scanner.nextInt();
            int column = scanner.nextInt();
            
            if(!tictactoe.placeValue(row, column, player))
            {
                continue;
            }
            
            tictactoe.displayBoard();

            if(tictactoe.checkWin(player))
            {
                System.out.println("Player " +player+ " has won");
                gameOver = true;
            }
                
            else if(tictactoe.isBoardfull())
            {
                System.out.println("Match Draw");
                gameOver = true;
            }
                
            
            player = (player == 'O') ? 'X' : 'O';
        }
        
    }
}
