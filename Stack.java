/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @author Juan Marcos Cruz Melara, 23110 
 * @description iterfaz para la stack del programa
 * @date creación 24/02/2024 última modificación 27/02/2024
 */

 public interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
