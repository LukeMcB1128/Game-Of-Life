/**
 * Main game logic for Conway's Game of Life
 * Implements the rules:
 * 1. Any live cell with 2 or 3 live neighbors survives
 * 2. Any dead cell with exactly 3 live neighbors becomes alive
 * 3. All other cells die or stay dead
 */
public class GameOfLife {
    private Grid grid;
    private int generation;
    
    /**
     * Creates a new Game of Life with the specified grid dimensions
     * @param rows number of rows in the grid
     * @param cols number of columns in the grid
     */
    public GameOfLife(int rows, int cols) {
        this.grid = new Grid(rows, cols);
        this.generation = 0;
    }
    
    /**
     * Returns the current grid
     * @return the Grid object
     */
    public Grid getGrid() {
        return grid;
    }
    
    /**
     * Returns the current generation number
     * @return the generation count
     */
    public int getGeneration() {
        return generation;
    }
    
    /**
     * Sets the state of a cell in the grid
     * @param row the row index
     * @param col the column index
     * @param alive true to make the cell alive, false to make it dead
     */
    public void setCell(int row, int col, boolean alive) {
        grid.setCell(row, col, alive);
    }
    
    /**
     * Advances the game to the next generation
     * Applies Conway's Game of Life rules to all cells
     */
    public void nextGeneration() {
        Grid newGrid = grid.copy();
        
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                int aliveNeighbors = grid.countAliveNeighbors(i, j);
                boolean currentlyAlive = grid.getCell(i, j).isAlive();
                
                // Apply Game of Life rules
                if (currentlyAlive) {
                    // Live cell with 2 or 3 neighbors survives
                    if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                        newGrid.setCell(i, j, true);
                    } else {
                        // Dies from underpopulation or overpopulation
                        newGrid.setCell(i, j, false);
                    }
                } else {
                    // Dead cell with exactly 3 neighbors becomes alive
                    if (aliveNeighbors == 3) {
                        newGrid.setCell(i, j, true);
                    }
                }
            }
        }
        
        grid = newGrid;
        generation++;
    }
    
    /**
     * Displays the current state of the grid
     */
    public void display() {
        System.out.println(grid.toString());
    }
    
    /**
     * Resets the grid to all dead cells
     */
    public void reset() {
        grid = new Grid(grid.getRows(), grid.getCols());
        generation = 0;
    }
}
