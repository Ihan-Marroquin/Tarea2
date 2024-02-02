import java.util.EmptyStackException;
import java.util.LinkedList;

// Clase que representa una pila de operandos.
class OperandStack {

    private LinkedList<Integer> stack = new LinkedList<>();

    // Método para agregar un elemento a la pila.
    public void push(int item) {
        stack.push(item);
    }

    // Método para eliminar y devolver el elemento en la parte superior de la pila.
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.pop();
    }

    // Método para verificar si la pila está vacía.
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
