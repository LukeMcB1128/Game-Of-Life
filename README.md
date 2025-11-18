# Game-Of-Life

Conway's Game of Life simulation for AP Computer Science A

## Description

This project implements Conway's Game of Life, a cellular automaton simulation that demonstrates the life and death events of a population of bacterial organisms. The simulation runs on a 20x20 grid for 5 generations and provides statistical analysis of the final state.

## Rules

The Game of Life follows these rules:

1. **Neighbors**: A neighbor is any cell touching the current cell (including diagonals, for a total of 8 possible neighbors)
2. **Birth**: An empty cell with exactly 3 living neighbors comes to life in the next generation
3. **Death**:
   - A living cell with 0 or 1 neighbors dies from loneliness
   - A living cell with 4 or more neighbors dies from overcrowding
4. **Survival**: A living cell with 2 or 3 neighbors survives to the next generation
5. All births and deaths occur simultaneously

## How to Run

### Compilation
```bash
javac GameOfLife.java
```

### Execution
```bash
java GameOfLife
```

## Output

The program will:
- Display the initial grid (Generation 0)
- Show the progression through 5 generations
- Provide statistics including:
  - Number of living cells in row 10
  - Number of living cells in column 10
  - Total number of living organisms

## Customization

To modify the initial pattern, edit the `initializeGrid()` method in `GameOfLife.java`. The grid uses:
- `*` to represent living cells
- `-` to represent empty cells

## Assignment Details

For complete assignment details, see [README (3).md](README%20(3).md)
