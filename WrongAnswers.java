

import java.util.Arrays;
import java.util.Random;

public class WrongAnswers {
    public static String[] generateWrongAnswers(String input) {
        if (isInteger(input)) {
            int number = Integer.parseInt(input);
            return generateRandomNumbersNear(number);
        } else if (input.equals("Number of travellers travelling by different vehicles.")) {
            return new String[]{
                    "Number of students travelling by different vehicles.",
                    "Number of teachers travelling by different vehicles.",
                    "Number of principal travelling by different vehicles."
            };
        } else if (input.contains("$1$ unit $=")) {
            return new String[]{
                    "$1$ unit $= 25$ vehicles.<br>#$1$ एकक $= 25$ वाहने <br>",
                    "$1$ unit $= 250$ vehicles.<br>#$1$ एकक $= 250$ वाहने <br>",
                    "$1$ unit $= 150$ vehicles.<br>#$1$ एकक $= 150$ वाहने <br>"
            };
        }
        else if (input.equals("Bus")) {
            return new String[]{
                    "Car",
                    "Motorcycle",
                    "Bicycle"
            };
        } else if (input.equals("Truck")) {
            return new String[]{
                    "Car",
                    "Motorcycle",
                    "Bicycle"
            };
        } else if (input.equals("Motorcycle")) {
            return new String[]{
                    "Car",
                    "Bus",
                    "Scooter"
            };
        } else if (input.equals("Bicycle")) {
            return new String[]{
                    "Car",
                    "Bus",
                    "Scooter"
            };
        } else if (input.equals("Scooter")) {
            return new String[]{
                    "Car",
                    "Bus",
                    "Truck"
            };
        }
        else if (input.equals("Car")) {
            return new String[]{
                    "Bus",
                    "Scooter",
                    "Truck"
            };
        }
        else {
            return new String[]{
                    "Car, Bus, Truck, Motorcycle",
                    "Car, Bus, Truck, Scooter",
                    "Bicycle, Bus, Truck, Motorcycle"
            };
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String[] generateRandomNumbersNear(int number) {
        Random random = new Random();
        String[] result = new String[3];

        for (int i = 0; i < 3; i++) {
            int randomOffset;
            int generatedNumber;

            do {
                randomOffset = random.nextInt(5) - 2;
                generatedNumber = number + randomOffset;
            } while (generatedNumber == number || contains(result, String.valueOf(generatedNumber)));

            result[i] = String.valueOf(generatedNumber);
        }

        return result;
    }



    private static boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element != null && element.equals(value)) {
                return true;
            }
        }
        return false;
    }



//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(generateWrongAnswers("This bar graph represents the number of travelers by different means.")));
//        System.out.println(Arrays.toString(generateWrongAnswers("10")));
//        System.out.println(Arrays.toString(generateWrongAnswers("Car")));
//
//
//    }
}
