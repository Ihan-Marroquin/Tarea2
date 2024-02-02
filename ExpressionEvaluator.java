import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExpressionEvaluator {

    public static void evaluateFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int result = evaluateExpression(line);
                System.out.println("Expression: " + line + " = " + result);
            }
        }
    }

    private static int evaluateExpression(String expression) {
        OperandStack operandStack = new OperandStack();

        for (String token : expression.split("\\s")) {
            if (isNumeric(token)) {
                operandStack.push(Integer.parseInt(token));
            } else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                operandStack.push(performOperation(token, operand1, operand2));
            }
        }

        return operandStack.pop();
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    private static int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}
