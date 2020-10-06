import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio9 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        final int CANT_GRUPOS = 5;
        final int CANT_NUMEROS_GRUPO = 3;

        int acum = 0;

        for (int i = 0; i < CANT_GRUPOS; i++) {
            acum = 0;
            for (int j = 0; j < CANT_NUMEROS_GRUPO; j++) {
                acum += pedirNumero(String.format("Grupo %s, numero %s: ", i+1, j+1));
            }
            System.out.println(String.format("El promedio del grupo %s es: %s", i+1, (double)acum/CANT_NUMEROS_GRUPO));
        }
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
