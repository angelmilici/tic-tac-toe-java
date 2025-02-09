import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialise board
        TicTacToe ticTacToe = new TicTacToe();

        // play game
        ticTacToe.playGame(scanner);
    }
}
