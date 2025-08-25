# Quiz App with Timer in Java

## Project Description
The **Quiz App with Timer** is a Java-based desktop application that allows users to take a multiple-choice quiz with a time limit for each question. This interactive application helps users test their knowledge on various topics while improving time management skills. The app is built using **Java Swing** for the graphical user interface and demonstrates concepts of **object-oriented programming, event handling, and timer-based logic**.

---

## Features
- **Multiple Choice Questions (MCQs):** Each question has four options (A-D) for the user to select.
- **Timer Functionality:** A 15-second countdown timer is set for each question. If time runs out, the app automatically moves to the next question.
- **Score Tracking:** Calculates and displays the user's score at the end of the quiz.
- **Interactive GUI:** Implemented using Java Swing for a simple and user-friendly interface.
- **Immediate Feedback:** Shows whether the selected answer is correct or wrong along with the correct answer.
- **Modular Design:** Easy to add or modify questions and answers.

---

## Technologies Used
- **Programming Language:** Java
- **GUI Library:** Swing
- **Concepts:** Object-Oriented Programming (OOP), Event Handling, Timer, Layout Management

---

## How to Run
1. Make sure you have **Java Development Kit (JDK)** installed.
2. Clone or download this repository.
3. Open the project in any Java IDE (e.g., **Eclipse**, **IntelliJ IDEA**, or **VS Code with Java Extension**).
4. Compile and run the `QuizAppWithTimer.java` file.
5. The quiz window will open, displaying questions and a countdown timer.

---

## Code Overview
- `QuizAppWithTimer` class extends `JFrame` and implements `ActionListener`.
- **Questions, options, and answers** are stored in arrays.
- **Timer:** Uses `javax.swing.Timer` to count down 15 seconds for each question.
- **User Interaction:** `JRadioButton` for selecting answers, and `JButton` to move to the next question.
- Displays feedback using `JOptionPane` dialogs after each question and shows the final score at the end.

---

## Future Enhancements
- Add multiple categories and difficulty levels.
- Store questions in a file or database for easy updates.
- Include a leaderboard to track high scores.
- Add sound effects and animations for better user experience.

---

## Author
- **Rudra Chandna**
