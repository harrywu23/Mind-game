# Mind Game (Guess Colours)

A colour-based psychological guessing game where a human competes against an AI (HAL-9000). Built as part of the SOFTENG 281 course at the University of Auckland.

## 🎮 Game Description

Each round, both the human player and the AI:
- Choose a colour to play
- Guess what colour the opponent chose

### Scoring
- **+1 point** for each correct guess  
- **+2 bonus points** if:
  - The guess is correct **and**
  - The correct colour is the **Power Colour** (assigned every 3rd round)

The player with the highest score at the end of a predefined number of rounds wins.

## 🧠 AI Difficulty Levels

The AI adapts its behavior based on the selected difficulty level:

- **EASY**: Fully random selection and guessing
- **MEDIUM**: Starts random, then adopts a strategy from Round 2
- **HARD**: Starts random, then adapts based on past round results

## 🧱 Technologies Used

- Java
- JUnit (for unit testing)
- Maven Wrapper (for build consistency)
- Command Line Interface (CLI)

## 🧩 OOP Design and Patterns

This project emphasizes Object-Oriented Programming and applies key design patterns such as Factory and Strategy
