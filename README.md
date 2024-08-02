# Tic Tac Toe Game

## Overview

This project is a simple graphical Tic Tac Toe game implemented in Java using Swing. The game features a user interface where two players can take turns to play Tic Tac Toe. The game is designed with a timer and displays messages for game status and results.

## Project Structure

The primary class for the game is `Game.java`, which contains the main logic and user interface components for the Tic Tac Toe game.

### `Game.java`

The `Game` class extends `JFrame` and implements `ActionListener`. It provides the graphical user interface for the game and handles user interactions.

#### Key Components

- **`JLabel heading`**: Displays the title of the game.
- **`JLabel timer`**: Displays the elapsed time.
- **`Font style1`**: Font used for the game title.
- **`Font style2`**: Font used for the buttons.
- **`JPanel board`**: Panel that contains the game buttons.
- **`JButton[] buttons`**: Array of buttons representing the Tic Tac Toe grid.
- **`boolean alice`**: Indicates if it is Alice's turn.
- **`boolean bob`**: Indicates if it is Bob's turn.
- **`int[][] winningpos`**: Array storing the winning positions for the game.
- **`boolean gameplay`**: Indicates if the game is still ongoing.
