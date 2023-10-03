import java.util.Scanner;

public class TileMazeGame {
    private static char[][] grid;
    private static int playerX, playerY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeGame();

        while (true) {
            displayGrid();

            System.out.print("Enter your move (U/D/L/R): ");
            char move = scanner.next().charAt(0);

            if (isValidMove(move)) {
                movePlayer(move);
                if (hasReachedExit()) {
                    System.out.println("Congratulations! You've reached the exit!");
                    break;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private static void initializeGame() {
        grid = new char[][]{
                {'S', ' ', '#', ' ', ' '},
                {' ', '#', ' ', '#', ' '},
                {'#', ' ', ' ', ' ', '#'},
                {'#', '#', '#', ' ', ' '},
                {' ', ' ', 'E', ' ', ' '}
        };
        playerX = 0;
        playerY = 0;
    }

    private static void displayGrid() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(char move) {
        switch (move) {
            case 'U':
                return playerX > 0 && grid[playerX - 1][playerY] != '#';
            case 'D':
                return playerX < grid.length - 1 && grid[playerX + 1][playerY] != '#';
            case 'L':
                return playerY > 0 && grid[playerX][playerY - 1] != '#';
            case 'R':
                return playerY < grid[0].length - 1 && grid[playerX][playerY + 1] != '#';
            default:
                return false;
        }
    }

    private static void movePlayer(char move) {
        switch (move) {
            case 'U':
                playerX--;
                break;
            case 'D':
                playerX++;
                break;
            case 'L':
                playerY--;
                break;
            case 'R':
                playerY++;
                break;
        }
    }

    private static boolean hasReachedExit() {
        return grid[playerX][playerY] == 'E';
    }
}
