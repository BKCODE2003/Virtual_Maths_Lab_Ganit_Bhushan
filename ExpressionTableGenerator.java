import java.util.Random;

public class ExpressionTableGenerator {

    public static void main(String[] args) {
        int numberOfTables = 200;
        Random rand = new Random();

        for (int t = 1; t <= numberOfTables; t++) {
            System.out.println("Table " + t + ":");
            System.out.printf("%-5s %-20s %-20s %-5s %-5s%n", "", "LHS Expression", "RHS Expression", "", "Relation");
            System.out.println("------------------------------------------------------------");

            // Generate expressions ensuring one of each relation: =, >, <
            String[] relations = {"=", ">", "<"};
            boolean[] usedRelations = {false, false, false};

            for (int i = 0; i < 3; i++) {
                char row = (char) ('a' + i);
                String[] expressions = generateExpressionPair(rand, relations[i]);
                System.out.printf("%-5s %-20s %-20s %-5s %-5s%n", row, expressions[0], expressions[1], (i + 1), relations[i]);
            }

            System.out.println("\n");
        }
    }

    // Function to generate a random pair of expressions with a specified relationship
    private static String[] generateExpressionPair(Random rand, String relation) {
        int lhsNum1, lhsNum2, rhsNum1, rhsNum2;
        String[] operators = {"+", "-", "x"};
        String lhsOperator, rhsOperator;
        int lhsResult, rhsResult;

        do {
            lhsNum1 = rand.nextInt(20) + 1;
            lhsNum2 = rand.nextInt(20) + 1;
            rhsNum1 = rand.nextInt(20) + 1;
            rhsNum2 = rand.nextInt(20) + 1;

            lhsOperator = operators[rand.nextInt(3)];
            rhsOperator = operators[rand.nextInt(3)];

            lhsResult = calculate(lhsNum1, lhsNum2, lhsOperator);
            rhsResult = calculate(rhsNum1, rhsNum2, rhsOperator);
        } while (!isValidRelation(lhsResult, rhsResult, relation));

        String lhsExpression = lhsNum1 + " " + lhsOperator + " " + lhsNum2;
        String rhsExpression = rhsNum1 + " " + rhsOperator + " " + rhsNum2;

        return new String[]{lhsExpression, rhsExpression};
    }

    // Function to validate if the generated expressions meet the required relation
    private static boolean isValidRelation(int lhs, int rhs, String relation) {
        switch (relation) {
            case "=":
                return lhs == rhs;
            case ">":
                return lhs > rhs;
            case "<":
                return lhs < rhs;
            default:
                return false;
        }
    }

    // Function to calculate the result of an expression
    private static int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "x":
                return num1 * num2;
            default:
                return 0;
        }
    }
}
