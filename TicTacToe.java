import java.util.Arrays;

public class TicTacToe {

    int size = 3;
    public char[][] board;
    public TicTacToe() {

        board = new char[3][3];
        initialiseBoard(board);
        // initialise board

    }

    private static void initialiseBoard(char [][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.println(i + "" + j);
                board[i][j] = ' ';
            }
        }
        System.out.println("Board Initialised:" + Arrays.deepToString(board));
        showBoard(board);
    }

    private static void showBoard(char [][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
//                System.out.println(i + "" + j);
//                board[i][j] = ' ';
                sb.append(board[i][j]);
                if (j < 2)
                    sb.append(" | ");
                else
                    sb.append("\n");
            }
            if (i < 2)
                sb.append("----------\n");
        }
        System.out.println("Board: \n" + sb);
    }

}
