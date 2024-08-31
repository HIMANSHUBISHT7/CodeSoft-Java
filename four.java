import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

// Class representing a quiz question
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

// Main class to run the quiz
public class four {
    private static final int TIME_LIMIT = 10; // time limit in seconds for each question
    private List<Question> questions;
    private int score;
    private List<String> results;

    public four() {
        questions = new ArrayList<>();
        results = new ArrayList<>();
        score = 0;

        // Adding sample questions to the quiz
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. London", "3. Paris", "4. Rome"}, 3));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 2));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain", "4. Jane Austen"}, 2));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println("\n" + question.getQuestionText());
            String[] options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up!");
                    results.add(question.getQuestionText() + " - Incorrect (Time ran out)");
                    askNextQuestion();
                }
            };
            timer.schedule(task, TIME_LIMIT * 1000);

            System.out.print("Your answer (enter the option number): ");
            int answer = scanner.nextInt();
            timer.cancel();

            if (answer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
                results.add(question.getQuestionText() + " - Correct");
            } else {
                System.out.println("Incorrect.");
                results.add(question.getQuestionText() + " - Incorrect");
            }
        }

        displayResults();
        scanner.close();
    }

    private void askNextQuestion() {
        // This method is used to simulate moving to the next question if time runs out.
    }

    private void displayResults() {
        System.out.println("\n--- Quiz Results ---");
        System.out.println("Final Score: " + score + "/" + questions.size());
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        four quizGame = new four();
        quizGame.startQuiz();
    }
}

