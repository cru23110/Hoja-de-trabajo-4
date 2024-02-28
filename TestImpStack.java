import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class TestImpStack {

    @Test
    public void testConvertirInfijoAPosfijo() {
        String expresionInfija = "(3+2)*5";
        String expresionPosfija = Main.convertirInfijoAPosfijo(expresionInfija);
        assertEquals("32+5*", expresionPosfija);
    }

    @Test
    public void testArrayListStack() {
        Stack<Integer> stack = new ArrayListStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(Integer.valueOf(2), stack.peek());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testVectorStack() {
        Stack<Integer> stack = new VectorStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(10);
        stack.push(20);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(Integer.valueOf(20), stack.peek());
        assertEquals(Integer.valueOf(20), stack.pop());
        assertEquals(Integer.valueOf(10), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSinglyLinkedList() {
        Stack<Double> stack = new SinglyLinkedList<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(3.14);
        stack.push(2.71);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(Double.valueOf(2.71), stack.peek());
        assertEquals(Double.valueOf(2.71), stack.pop());
        assertEquals(Double.valueOf(3.14), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testDoublyLinkedList() {
        Stack<Integer> stack = new DoublyLinkedList<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(42);
        stack.push(13);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertEquals(Integer.valueOf(13), stack.peek());
        assertEquals(Integer.valueOf(13), stack.pop());
        assertEquals(Integer.valueOf(42), stack.pop());
        assertTrue(stack.isEmpty());
    }
}
