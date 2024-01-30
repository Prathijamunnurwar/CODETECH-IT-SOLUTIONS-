public package hello;
import java.util.Scanner;
import java.util.Random;

public class prath{
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n---------");
        }
    }

    public static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player ||
                board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        return board[0][0] == player && board[1][1] == player && board[2][2] == player ||
               board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    public static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return 0 <= row && row < 3 && 0 <= col && col < 3 && board[row][col] == ' ';
    }

    public static int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];

        System.out.print("Enter row (0, 1, or 2): ");
        move[0] = scanner.nextInt();
        System.out.print("Enter column (0, 1, or 2): ");
        move[1] = scanner.nextInt();

        return move;
    }

    public static int[] getComputerMove(char[][] board) {
        Random random = new Random();
        int[] move = new int[2];

        do {
            move[0] = random.nextInt(3);
            move[1] = random.nextInt(3);
        } while (!isValidMove(board, move[0], move[1]));

        return move;
    }

    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';

        while (true) {
            printBoard(board);

            int[] move;
            if (currentPlayer == 'X') {
                move = getPlayerMove();
            } else {
                System.out.println("Computer's turn:");
                move = getComputerMove(board);
            }

            int row = move[0];
            int col = move[1];

            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;

                if (checkWinner(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println(currentPlayer + " wins!");
                    break;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}

    

