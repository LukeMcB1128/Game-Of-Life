/**
 * Game of Life Simulation
 * AP Computer Science A Assignment
 *
 * This program simulates Conway's Game of Life on a 20x20 grid
 * for 5 generations and provides statistics about the final state.
 */
public class GameOfLife {
    private static final int SIZE = 20;
    private static final int GENERATIONS = 5;
    private String[][] grid;

    public GameOfLife() {
        grid = new String[SIZE][SIZE];
        initializeGrid();
    }

    /**
     * Initializes the grid with generation 0.
     * This sets up the initial pattern of living organisms.
     */
    private void initializeGrid() {
        // Initialize all cells as empty
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = "-";
            }
        }

        // Set up initial living cells pattern (Generation 0)
        // This pattern is based on a typical Game of Life configuration
        // You can modify this to match the specific pattern from the assignment image

        // Glider pattern (top left)
        grid[1][2] = "*";
        grid[2][3] = "*";
        grid[3][1] = "*";
        grid[3][2] = "*";
        grid[3][3] = "*";

        // Blinker pattern (middle)
        grid[9][9] = "*";
        grid[9][10] = "*";
        grid[9][11] = "*";

        // Block pattern (stable)
        grid[5][5] = "*";
        grid[5][6] = "*";
        grid[6][5] = "*";
        grid[6][6] = "*";

        // Additional patterns to create more interesting results
        grid[10][5] = "*";
        grid[10][6] = "*";
        grid[10][7] = "*";
        grid[11][5] = "*";
        grid[12][6] = "*";

        grid[15][15] = "*";
        grid[15][16] = "*";
        grid[16][14] = "*";
        grid[16][15] = "*";
        grid[17][15] = "*";

        // Add more cells to populate the grid
        grid[7][10] = "*";
        grid[8][10] = "*";
        grid[8][11] = "*";

        grid[12][12] = "*";
        grid[13][12] = "*";
        grid[13][13] = "*";
        grid[14][12] = "*";

        grid[4][15] = "*";
        grid[4][16] = "*";
        grid[5][15] = "*";
        grid[5][17] = "*";
        grid[6][15] = "*";

        grid[18][8] = "*";
        grid[18][9] = "*";
        grid[18][10] = "*";
        grid[19][9] = "*";
    }

    /**
     * Counts the number of living neighbors for a given cell.
     * A neighbor is any cell touching the current cell (including diagonals).
     *
     * @param row the row of the cell
     * @param col the column of the cell
     * @return the number of living neighbors
     */
    private int countNeighbors(int row, int col) {
        int count = 0;

        // Check all 8 surrounding cells
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the cell itself
                if (i == 0 && j == 0) continue;

                int newRow = row + i;
                int newCol = col + j;

                // Check boundaries
                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE) {
                    if (grid[newRow][newCol].equals("*")) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Advances the simulation by one generation.
     * Applies the Game of Life rules:
     * - Birth: empty cell with 3 neighbors comes to life
     * - Death: cell with 0-1 neighbors (loneliness) or 4+ neighbors (overcrowding)
     * - Survival: cell with 2-3 neighbors survives
     */
    private void nextGeneration() {
        String[][] newGrid = new String[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int neighbors = countNeighbors(i, j);
                boolean isAlive = grid[i][j].equals("*");

                if (isAlive) {
                    // Cell is currently alive
                    if (neighbors == 2 || neighbors == 3) {
                        newGrid[i][j] = "*"; // Survives
                    } else {
                        newGrid[i][j] = "-"; // Dies
                    }
                } else {
                    // Cell is currently dead
                    if (neighbors == 3) {
                        newGrid[i][j] = "*"; // Birth
                    } else {
                        newGrid[i][j] = "-"; // Stays dead
                    }
                }
            }
        }

        grid = newGrid;
    }

    /**
     * Displays the current state of the grid.
     */
    private void displayGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Counts living cells in a specific row.
     *
     * @param row the row to count (0-indexed)
     * @return the number of living cells in the row
     */
    private int countLivingInRow(int row) {
        int count = 0;
        for (int j = 0; j < SIZE; j++) {
            if (grid[row][j].equals("*")) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts living cells in a specific column.
     *
     * @param col the column to count (0-indexed)
     * @return the number of living cells in the column
     */
    private int countLivingInColumn(int col) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][col].equals("*")) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts total living cells in the entire grid.
     *
     * @return the total number of living cells
     */
    private int countTotalLiving() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].equals("*")) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Runs the Game of Life simulation.
     */
    public void run() {
        System.out.println("Generation 0:");
        displayGrid();

        // Run for specified number of generations
        for (int gen = 1; gen <= GENERATIONS; gen++) {
            nextGeneration();
            System.out.println("Generation " + gen + ":");
            displayGrid();
        }

        // Display statistics
        System.out.println("Number in Row 10 ---> " + countLivingInRow(9)); // Row 10 is index 9
        System.out.println("Number in Column 10 ---> " + countLivingInColumn(9)); // Column 10 is index 9
        System.out.println("Number of living organisms ---> " + countTotalLiving());
    }

    /**
     * Main method to run the simulation.
     */
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        game.run();
    }
}
