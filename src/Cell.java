/**
 * Represents a single cell in the Game of Life
 * Each cell can be either alive or dead
 */
public class Cell {
    private boolean alive;
    
    /**
     * Creates a new cell with the specified state
     * @param alive true if the cell is alive, false if dead
     */
    public Cell(boolean alive) {
        this.alive = alive;
    }
    
    /**
     * Creates a new dead cell
     */
    public Cell() {
        this(false);
    }
    
    /**
     * Returns whether this cell is alive
     * @return true if the cell is alive, false otherwise
     */
    public boolean isAlive() {
        return alive;
    }
    
    /**
     * Sets the state of this cell
     * @param alive true to make the cell alive, false to make it dead
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    /**
     * Returns a string representation of the cell
     * @return "O" if alive, "." if dead
     */
    @Override
    public String toString() {
        return alive ? "O" : ".";
    }
}
