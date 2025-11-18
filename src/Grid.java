/**
 * Represents the grid/board for the Game of Life
 * Manages the 2D array of cells
 */
public class Grid {
    private Cell[][] cells;
    private int rows;
    private int cols;
    
    /**
     * Creates a new grid with the specified dimensions
     * All cells start as dead
     * @param rows number of rows in the grid
     * @param cols number of columns in the grid
     */
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        
        // Initialize all cells as dead
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    
    /**
     * Returns the number of rows in the grid
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }
    
    /**
     * Returns the number of columns in the grid
     * @return number of columns
     */
    public int getCols() {
        return cols;
    }
    
    /**
     * Gets the cell at the specified position
     * @param row the row index
     * @param col the column index
     * @return the Cell at the specified position
     */
    public Cell getCell(int row, int col) {
        if (isValidPosition(row, col)) {
            return cells[row][col];
        }
        return null;
    }
    
    /**
     * Sets the state of the cell at the specified position
     * @param row the row index
     * @param col the column index
     * @param alive true to make the cell alive, false to make it dead
     */
    public void setCell(int row, int col, boolean alive) {
        if (isValidPosition(row, col)) {
            cells[row][col].setAlive(alive);
        }
    }
    
    /**
     * Checks if a position is valid within the grid
     * @param row the row index
     * @param col the column index
     * @return true if the position is valid, false otherwise
     */
    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    
    /**
     * Counts the number of alive neighbors for a given cell
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the number of alive neighbors (0-8)
     */
    public int countAliveNeighbors(int row, int col) {
        int count = 0;
        
        // Check all 8 neighboring positions
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the cell itself
                if (i == 0 && j == 0) {
                    continue;
                }
                
                int newRow = row + i;
                int newCol = col + j;
                
                if (isValidPosition(newRow, newCol) && cells[newRow][newCol].isAlive()) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    /**
     * Creates a copy of this grid
     * @return a new Grid with the same state as this one
     */
    public Grid copy() {
        Grid newGrid = new Grid(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newGrid.setCell(i, j, this.cells[i][j].isAlive());
            }
        }
        return newGrid;
    }
    
    /**
     * Returns a string representation of the grid
     * @return a multi-line string showing the current state of all cells
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(cells[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
