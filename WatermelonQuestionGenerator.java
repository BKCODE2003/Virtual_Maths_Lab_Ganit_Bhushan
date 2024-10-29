import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WatermelonQuestionGenerator {

    public static void main(String[] args) {
        generateQuestions(100);  // Generate 100 questions
    }

    // Generate all questions
    public static void generateQuestions(int numberOfQuestions) {
        Random random = new Random(); 

        String[] names = {"Neha", "Soham", "Aboli", "Isha", "Kshitij", "Rahul", "Sneha", "Aarav"}; // Name array

        int questionCount = 0;
        while (questionCount < numberOfQuestions) {
            int[] watermelons = new int[4];

            // Pick 4 unique random names from the list of names
            List<String> selectedNames = selectRandomNames(names, random, 4);

            // Assign random watermelon counts between 30 and 50 for each selected person
            for (int j = 0; j < 4; j++) {
                watermelons[j] = random.nextInt(21) + 30;
            }

            // Generate the correct and wrong pairs
            List<String[]> correctPairs = new ArrayList<>();
            List<String[]> incorrectPairs = new ArrayList<>();

            // Generate possible pairs
            String[][] pairs = {
                {selectedNames.get(0), selectedNames.get(1)}, // Neha - Soham
                {selectedNames.get(0), selectedNames.get(2)}, // Neha - Aboli
                {selectedNames.get(0), selectedNames.get(3)}, // Neha - Isha
                {selectedNames.get(1), selectedNames.get(2)}, // Soham - Aboli
                {selectedNames.get(1), selectedNames.get(3)}, // Soham - Isha
                {selectedNames.get(2), selectedNames.get(3)}  // Aboli - Isha
            };

            int[] differences = new int[6];
            differences[0] = Math.abs(watermelons[0] - watermelons[1]); // Neha - Soham
            differences[1] = Math.abs(watermelons[0] - watermelons[2]); // Neha - Aboli
            differences[2] = Math.abs(watermelons[0] - watermelons[3]); // Neha - Isha
            differences[3] = Math.abs(watermelons[1] - watermelons[2]); // Soham - Aboli
            differences[4] = Math.abs(watermelons[1] - watermelons[3]); // Soham - Isha
            differences[5] = Math.abs(watermelons[2] - watermelons[3]); // Aboli - Isha

            // Find exactly 1 correct pair and 3 wrong pairs
            boolean foundCorrectPair = false;
            for (int k = 0; k < differences.length; k++) {
                for (int l = k + 1; l < differences.length; l++) {
                    if (differences[k] == differences[l]) {
                        if (!foundCorrectPair) {
                            correctPairs.add(pairs[k]);
                            correctPairs.add(pairs[l]);
                            foundCorrectPair = true;
                        }
                    } else {
                        if (incorrectPairs.size() < 6) {
                            incorrectPairs.add(pairs[k]);
                            incorrectPairs.add(pairs[l]);
                        }
                    }
                }
            }

            // Ensure 1 correct and 3 wrong pairs exist before proceeding
            if (foundCorrectPair && correctPairs.size() == 2 && incorrectPairs.size() == 6) {
                // Print the question
                questionCount++;
                System.out.println("Question " + questionCount + ":");
                System.out.println(selectedNames.get(0) + ", " + selectedNames.get(1) + ", " +
                                   selectedNames.get(2) + " and " + selectedNames.get(3) +
                                   " have a total of $" + watermelons[0] + "$, $" + watermelons[1] + 
                                   "$, $" + watermelons[2] + "$ and $" + watermelons[3] + 
                                   "$ watermelons respectively.");
                System.out.println("Which combination will make pairs to form an equation with the subtraction of their watermelons?");
                System.out.println();

                // Print correct pairs with the subtraction equation
                System.out.println("Correct pairs (valid subtractions):");
                for (String[] pair : correctPairs) {
                    int firstIndex = selectedNames.indexOf(pair[0]);
                    int secondIndex = selectedNames.indexOf(pair[1]);
                    int difference = watermelons[firstIndex] - watermelons[secondIndex];
                    System.out.println(pair[0] + " - " + pair[1] + ": " + 
                                       watermelons[firstIndex] + " - " + watermelons[secondIndex] + 
                                       " = " + Math.abs(difference) + " (correct)");
                }

                // Print wrong pairs without subtraction equation
                System.out.println("Incorrect pairs (invalid subtractions):");
                for (int j = 0; j < 3; j++) {
                    String[] pair1 = incorrectPairs.get(j * 2);
                    String[] pair2 = incorrectPairs.get(j * 2 + 1);
                    System.out.println(pair1[0] + " - " + pair1[1] + " and " + pair2[0] + " - " + pair2[1] + " (wrong)");
                }

                System.out.println();
            }
        }
    }

    // Select random names from the list
    public static List<String> selectRandomNames(String[] names, Random random, int count) {
        List<String> selectedNames = new ArrayList<>();
        while (selectedNames.size() < count) {
            String randomName = names[random.nextInt(names.length)];
            if (!selectedNames.contains(randomName)) {
                selectedNames.add(randomName);
            }
        }
        return selectedNames;
    }
}
