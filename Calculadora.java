import java.util.EmptyStackException;
import java.util.Stack;

public class Calculadora {
    
    private static Calculadora instancia;
    
    private Calculadora() {}
    
    public static Calculadora getInstancia() {
        if (instancia == null) {
            instancia = new Calculadora();
        }
        return instancia;
    }

    public static boolean esOperando(String c) {
        boolean flag = true;
        int num = 0;
        try {
            num = Integer.parseInt(c);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static  boolean esOperador(String c) {
        boolean flag = true;
        if (c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    
    public static int evaluarExpresionPosfija(String expresionPosfija) {
        try {
            for (int i = 0; i < expresionPosfija.length(); i++) {
                char caracter = expresionPosfija.charAt(i);
                if (Character.isDigit(caracter)) {
                    Main.pila.push(Character.getNumericValue(caracter));
                } else {
                    int operando2 = Main.pila.pop();
                    int operando1 = Main.pila.pop();
                    switch (caracter) {
                        case '+':
                            Main.pila.push(operando1 + operando2);
                            break;
                        case '-':
                            Main.pila.push(operando1 - operando2);
                            break;
                        case '*':
                            Main.pila.push(operando1 * operando2);
                            break;
                        case '/':
                            if (operando2 == 0) {
                                throw new ArithmeticException("División por cero");
                            }
                            Main.pila.push(operando1 / operando2);
                            break;
                        default:
                            throw new IllegalArgumentException("Operador inválido: " + caracter);
                    }
                }
            }
            return Main.pila.pop();
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        } catch (EmptyStackException e) {
            System.err.println("Error: No hay suficientes operandos para realizar la operación");
            return 0;
        }
    }

    
}
