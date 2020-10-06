import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int acumulador = 0;
        int cantidadNumeros = 0;

        do{
            int numero = pedirNumero("Ingrese un numero");
            cantidadNumeros++;
            acumulador+= numero;
        }while (calcularPromedio(acumulador, cantidadNumeros) < 20);

        System.out.println(String.format("Se ingresaron %s números", cantidadNumeros));
    }

    private static double calcularPromedio(int cuanto, int cuantos){
        return (double)cuanto / cuantos;
    }

    private static int pedirNumero(String mensaje){
        Integer input = null;

        do {

            try {
                System.out.println(mensaje);
                input = scanner.nextInt();
            }
            catch (InputMismatchException ex) {
                System.out.println("Solo números");
            }
            finally {
                scanner.nextLine();
            }

        } while (input == null);

        return input;
    }
}
