import java.io.IOException;

// Interfaz para la evaluación de expresiones.
interface Evaluator {
    void evaluateFromFile(String filePath) throws IOException;
    int evaluateExpression(String expression);
}

