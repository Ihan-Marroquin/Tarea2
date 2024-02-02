import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filePath = "datos.txt";

        try {
            ExpressionEvaluator.evaluateFromFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
