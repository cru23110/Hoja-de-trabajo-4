/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @author Juan Marcos Cruz Melara, 23110 
 * @description implementación de la clase vector para la stack del sistema
 * @date creación 24/02/2024 última modificación 27/02/2024
 */
import java.util.Vector;

public class VectorStack<T> implements Stack<T> {
    private Vector<T> stack;

    public VectorStack() {
        this.stack = new Vector<>();
    }

    
    /** 
     * @param element
     */
    @Override
    public void push(T element) {
        stack.add(element);
    }

    
    /** 
     * @return T
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    
    /** 
     * @return T
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    
    /** 
     * @return int
     */
    @Override
    public int size() {
        return stack.size();
    }

    
}
