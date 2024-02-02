import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ExpressionEvaluatorTest {
    @Test
    public void expressionEva1() {
        // Crea una instancia de la calculadora.
        ExpressionEvaluator calculator = new ExpressionEvaluator();
        // Define la expresión
        String expression = "7 2 +";
        // Realiza la evaluación
        int result = calculator.evaluateExpression(expression);
        assertEquals(9, result);
    }

    @Test
    public void expressionEva2() {
        // Crea una instancia de la calculadora.
        ExpressionEvaluator calculator = new ExpressionEvaluator();
        // Define la expresión
        String expression = "2 2 2 + 7 *";
        // Realiza la evaluación
        int result = calculator.evaluateExpression(expression);
        assertEquals(28, result);
    }

    @Test
    public void expressionEva3() {
        // Crea una instancia de la calculadora
        ExpressionEvaluator calculator = new ExpressionEvaluator();
        // Define la expresión
        String expression = "9 3 /";
        // Realiza la evaluación
        int result = calculator.evaluateExpression(expression);
        assertEquals(3, result);
    }
}
