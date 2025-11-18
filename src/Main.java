/**
 * Main class for running the Game of Life
 * AP Computer Science A Project
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Conway's Game of Life!");
        
        // Create a new game with a default grid size
        GameOfLife game = new GameOfLife(20, 20);
        
        // Set up an initial pattern (Glider)
        game.setCell(1, 2, true);
        game.setCell(2, 3, true);
        game.setCell(3, 1, true);
        game.setCell(3, 2, true);
        game.setCell(3, 3, true);
        
        // Display initial state
        System.out.println("Initial State:");
        game.display();
        
        // Run a few generations
        System.out.println("\nRunning 5 generations...\n");
        for (int i = 1; i <= 5; i++) {
            game.nextGeneration();
            System.out.println("Generation " + i + ":");
            game.display();
            System.out.println();
        }
    }
}
