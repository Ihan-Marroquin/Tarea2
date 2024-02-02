import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Clase que implementa la interfaz Evaluator para evaluar expresiones en notación postfija.
class ExpressionEvaluator implements Evaluator {

    // Implementación del método de la interfaz para evaluar expresiones desde un archivo.
    @Override
    public void evaluateFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int result = evaluateExpression(line);
                System.out.println("Expresión: " + line + " = " + result);
            }
        }
    }

    // Implementación del método de la interfaz para evaluar una expresión en notación postfija.
    @Override
    public int evaluateExpression(String expression) {
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

    // Método auxiliar para verificar si una cadena es un número entero.
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    // Método auxiliar para realizar operaciones aritméticas.
    private int performOperation(String operator, int operand1, int operand2) {
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
                throw new IllegalArgumentException("Operador no soportado: " + operator);
        }
    }
}