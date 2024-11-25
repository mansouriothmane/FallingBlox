# Tetris Game (FallingBlox)

This project is a Java-based implementation of a simplified Tetris-like game. Developed as part of an object-oriented programming course, it follows the classic game mechanics with a focus on modularity, usability, and adherence to the Model-View-Controller (MVC) architectural pattern.

## Features
- **Basic Gameplay**:
  - Two types of pieces: "O" and "I".
  - Pieces fall under gravity and can be moved left, right, or rotated by the player.
  - Rows are cleared when completely filled, awarding points.
  - Game ends when the stack reaches the top.

- **MVC Architecture**:
  - **Model**: Encapsulates game logic (e.g., piece movements, collision detection).
  - **View**: Graphical interface created with Swing, displaying the game grid and falling pieces.
  - **Controller**: Handles user input (mouse or keyboard) to manipulate pieces.

- **Random Piece Generation**: Pieces are generated in sequence, randomly, or cyclically, depending on the selected mode.
  
- **Custom Graphics**: Pieces and the grid are rendered with scalable dimensions using Swing.

## What I Learned 

- **Object-Oriented Programming**:
  - Designed and implemented modular components using Java classes, interfaces, and enumerations.
  - Practiced code refactoring to improve maintainability and reusability.
 
- **Swing for GUI**:
  - Learned to create interactive graphical interfaces with Swing, including custom rendering and event handling.
 
- **MVC Architecture**:
  - Learned to separate concerns between data (Model), UI (View), and input handling (Controller).

- **Testing with JUnit**:
  - Created unit tests for game components to ensure correctness and reliability.
 
## Getting Started

### Prerequisites

- **Java**: Version 11 or later.
- **JUnit 5**: For running test cases.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/mansouriothmane/FallingBlox.git
   cd FallingBlox
   ```
2. Open the project in your preferred IDE (e.g., Eclipse, IntelliJ).
3. Compile and run the application.

### Controll

- **Left/Right Arrow Keys**: Move the piece horizontally.
- **Up Arrow Key**: Rotate the piece.
- **Down Arrow Key**: Accelerate the piece's fall.

## Possible Enhancements
- Add support for all seven Tetris pieces.
- Introduce increasing difficulty by speeding up piece fall over time.
- Implement a scoring system with high-score persistence.
- Enhance the graphical user interface with animations and better visual cues.
