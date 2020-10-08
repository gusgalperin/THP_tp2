import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        final int CANTIDAD_ALUMNOS = 10;

        String nombrePromedioMasAlto="";
        int promedioMasAlto=-1;

        for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
            String nombreActual = pedirCadena(String.format("Ingrese nombre del alumno %s", i+1));
            int promedioActual = pedirNumero(String.format("Ingrese el promedio de %s", nombreActual));

            if(promedioMasAlto==-1 || promedioActual > promedioMasAlto){
                promedioMasAlto = promedioActual;
                nombrePromedioMasAlto = nombreActual;
            }
        }

        System.out.println(String.format("El mejor promedio es %s con %s", nombrePromedioMasAlto, promedioMasAlto));
    }

    private static double calcularPromedio(int cuanto, int cuantos){
        return (double)cuanto / cuantos;
    }

    private static String pedirCadena(String mensaje){
        String input = "";

        do {

            System.out.println(mensaje);
            input = scanner.nextLine();

        } while (input.equals(""));

        return input;
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
