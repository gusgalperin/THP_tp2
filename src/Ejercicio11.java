import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio11 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int numA = pedirNumeroMayorACero("Ingrese numero A");
        int numB = pedirNumeroMayorACero("Ingrese numero B");

        int resultado = 0;

        for (int i = 0; i < numB; i++) {
            resultado += numA;
        }

        System.out.println(String.format("El resultado usando número A es: %s", resultado));

        resultado = 0;

        for (int i = 0; i < numA; i++) {
            resultado += numB;
        }

        System.out.println(String.format("El resultado usando número B es: %s", resultado));
    }

    private static int pedirNumeroMayorACero(String mensaje){
        Integer input = null;

        do {

            try {
                System.out.println(mensaje);
                input = scanner.nextInt();

                if(input <= 0){
                    System.out.println("Error: el número debe ser mayor a 0.");
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            finally {
                scanner.nextLine();
            }

        } while (input == null || input <= 0);

        return input;
    }
}
