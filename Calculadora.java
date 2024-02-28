/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @author Juan Marcos Cruz Melara, 23110 
 * @description calculladora de expresiones postfix
 * aqui se encuentra el metodo getInstancia para utilizar Singleton
 * @date creación 24/02/2024 última modificación 27/02/2024
 */

import java.util.EmptyStackException;

public class Calculadora {
    
    private static Calculadora instancia;
    
    private Calculadora() {}
    
    
    /** 
     * @return Calculadora
     */
    public static Calculadora getInstancia() {
        if (instancia == null) {
            instancia = new Calculadora();
        }
        return instancia;
    }

    
    /** 
     * @param c
     * @return boolean
     */
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

    
    /** 
     * @param c
     * @return boolean
     */
    public static  boolean esOperador(String c) {
        boolean flag = true;
        if (c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    
    
    /** 
     * @param expresionPosfija
     * @return int
     */
    public static int evaluarExpresionPosfija(String expresionPosfija) {
        try {
            for (int i = 0; i < expresionPosfija.length(); i++) {
                char caracter = expresionPosfija.charAt(i);
                //verificamos si viene un operando u operador para meterlo en la stack
                //o para operarlo
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
                            //manejar exception por division entre cero
                            if (operando2 == 0) {
                                throw new ArithmeticException("División por cero");
                            }
                            Main.pila.push(operando1 / operando2);
                            break;
                        default:
                            //verificar si ingresa algo que no sea operador esperado
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
