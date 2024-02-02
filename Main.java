import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filePath = "datos.txt";

        try {
            // Crea una instancia de la clase que implementa la interfaz y llama al método para evaluar expresiones desde el archivo.
            ExpressionEvaluator evaluator = new ExpressionEvaluator();
            evaluator.evaluateFromFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}