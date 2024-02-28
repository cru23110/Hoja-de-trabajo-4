/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @author Juan Marcos Cruz Melara, 23110 
 * @description implementación de lista simplemente encadenada para la stack del sistema
 * @date creación 24/02/2024 última modificación 27/02/2024
 */

public class SinglyLinkedList<T> implements Stack<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    
    /** 
     * @param element
     */
    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    
    /** 
     * @return T
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    
    /** 
     * @return T
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return head.data;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    
    /** 
     * @return int
     */
    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

}
