import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizAppWithTimer extends JFrame implements ActionListener {
    private JLabel questionLabel, timerLabel;
    private JRadioButton[] options;
    private ButtonGroup bg;
    private JButton nextButton;
    private Timer timer;
    private int timeLeft = 15;

    private String[] questions = {
        "What is the capital of France?",
        "Who developed Java?",
        "What is 10 + 15?",
        "Which is a valid keyword in Java?"
    };

    private String[][] choices = {
        {"Berlin", "Paris", "Madrid", "Rome"},
        {"Microsoft", "Apple", "Sun Microsystems", "Oracle"},
        {"20", "25", "30", "15"},
        {"integer", "floaty", "static", "define"}
    };

    private char[] answers = {'B', 'C', 'B', 'C'};
    private int current = 0;
    private int score = 0;

    public QuizAppWithTimer() {
        setTitle("Quiz Application with Timer");
        setSize(700, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(questionLabel, BorderLayout.WEST);

        timerLabel = new JLabel("Time left: 15s");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setForeground(Color.RED);
        topPanel.add(timerLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1));
        options = new JRadioButton[4];
        bg = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            bg.add(options[i]);
            centerPanel.add(options[i]);
        }

        add(centerPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);

        loadQuestion(current);
        startTimer();

        setVisible(true);
    }

    private void loadQuestion(int index) {
        questionLabel.setText("Q" + (index + 1) + ": " + questions[index]);
        for (int i = 0; i < 4; i++) {
            options[i].setText((char) ('A' + i) + ". " + choices[index][i]);
        }
        bg.clearSelection();
        timeLeft = 15;
        timerLabel.setText("Time left: 15s");
    }

    private char getSelectedAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                return (char) ('A' + i);
            }
        }
        return ' ';
    }

    private void startTimer() {
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time left: " + timeLeft + "s");
            if (timeLeft == 0) {
                timer.stop();
                handleAnswer(true);
            }
        });
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        handleAnswer(false);
    }

    private void handleAnswer(boolean timeUp) {
        char selected = getSelectedAnswer();

        if (selected == ' ' && !timeUp) {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
            startTimer();
            return;
        }

        char correct = answers[current];
        boolean isCorrect = selected == correct;
        if (isCorrect) score++;

        String selectedText = (selected == ' ') ? "No answer" : selected + "";
        String message = (isCorrect ? "✅ Correct!" : "❌ Wrong!") +
                "\nYour Answer: " + selectedText +
                "\nCorrect Answer: " + correct;

        JOptionPane.showMessageDialog(this, message);

        current++;
        if (current < questions.length) {
            loadQuestion(current);
            startTimer();
        } else {
            JOptionPane.showMessageDialog(this, "🎉 Quiz Over!\nYour score: " + score + "/" + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new QuizAppWithTimer();
    }
}
