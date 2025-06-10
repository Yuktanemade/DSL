import java.util.Scanner;

public class NQueens {
    final int N;

    public NQueens(int N) {
        this.N = N;
    }

    // Check if placing a queen at (row, col) is safe
    boolean isSafe(int[][] board, int row, int col) {
        // Check row on left
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        // Check lower-left diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1) return false;

        return true;
    }

    // Solve N-Queens using backtracking
    boolean solveNQueens(int[][] board, int col) {
        if (col >= N) return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQueens(board, col + 1))
                    return true;

                board[i][col] = 0; // Backtrack
            }
        }
        return false;
    }

    // Print the board (0s and 1s)
    void printBoard(int[][] board) {
        System.out.println("Solution (1 = Queen, 0 = Empty):");
        for (int[] row : board) {
            for (int cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
    }

    // Run solver
    public void run() {
        int[][] board = new int[N][N];
        if (solveNQueens(board, 0))
            printBoard(board);
        else
            System.out.println("No solution exists for N = " + N);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int N = sc.nextInt();

        new NQueens(N).run();
    }
}
