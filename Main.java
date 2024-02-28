import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de la Pila:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Simplemente encadenada");
        System.out.println("4. Doblemente encadenada");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                pila = new ArrayListStack<>();
                break;
            case 2:
                pila = new VectorStack<>();
                break;
            case 3:
                pila = new SinglyLinkedList<>();
                break;
            case 4:
                pila = new DoublyLinkedList<>();
                break;
            default:
            System.out.println("Error al crear la stack");
            return;
        }

        scanner.nextLine();
        System.out.println("Ingrese el nombre del archivo que contiene la expresión:");
        String fileName = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String expresion = br.readLine();
            String expresionPosfija = convertirInfijoAPosfijo(expresion);
            int resultado = Calculadora.getInstancia().evaluarExpresionPosfija(expresionPosfija);
            System.out.println("El resultado de la expresión es: " + resultado);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    public static String convertirInfijoAPosfijo(String expresion) {
        Stack<Character> operadores = new VectorStack<>();
        StringBuilder expresionPosfija = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (Character.isDigit(caracter)) {
                expresionPosfija.append(caracter);
            } else if (caracter == '(') {
                operadores.push(caracter);
            } else if (caracter == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    expresionPosfija.append(operadores.pop());
                }
                operadores.pop();
            } else {
                while (!operadores.isEmpty() && precedencia(caracter) <= precedencia(operadores.peek())) {
                    expresionPosfija.append(operadores.pop());
                }
                operadores.push(caracter);
            }
        }

        while (!operadores.isEmpty()) {
            expresionPosfija.append(operadores.pop());
        }

        return expresionPosfija.toString();
    }

    private static int precedencia(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        }
        return 0;
    }

    public static Stack<Integer> pila;

}
