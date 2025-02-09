import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3;
    private final char[][] board;
    private char currentPlayer;
    public TicTacToe() {

        currentPlayer = 'X';
        board = new char[SIZE][SIZE];
        // initialise board
        initialiseBoard();
    }

    public void playGame(Scanner scanner) {
        int moves = 0;
        boolean gameOver = false;
        while (!gameOver && moves < SIZE * SIZE) {
            showBoard();
            takeTurn(scanner);
            gameOver = validateWin();
            if (!gameOver) switchPlayer();
            moves++;
        }

        showBoard();
        if (gameOver)
            System.out.printf("Player %s is the winner!", currentPlayer);
        else System.out.println("It is a Draw!");
    }

    private boolean validateWin() {
        for (int i = 0; i < board.length; i++) {
            // checks all the rows
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            // checks all the columns
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        // checks diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[2][0] == currentPlayer && board[1][1] == currentPlayer && board[0][2] == currentPlayer) return true;

        return false;
    }

    private void initialiseBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
                if (j < 2)
                    sb.append(" | ");
                else
                    sb.append("\n");
            }
            if (i < 2)
                sb.append("---------\n");
        }
        System.out.println("Board: \n" + sb);
    }

    private void takeTurn(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            }
            else
                System.out.printf("Row %s, Column %s is not valid, try another position%n", row, col);
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
