import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numero1 = GetNumero("Ingrese un numero");
        int numero2 = GetNumeroMayorOIgualQue(String.format("Ingrese un numero mayor o igual a %s", numero1), numero1);

        MostrarSecuenciaInclusiva(numero1, numero2);
    }

    private static int GetNumero(String mensaje){
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

    private static int GetNumeroMayorOIgualQue(String mensaje, int mayorQue){
        int input = 0;

        do {
            input = GetNumero(mensaje);
        } while (input < mayorQue);

        return input;
    }

    private static void MostrarSecuenciaInclusiva(int desde, int hasta){
        String secuencia = "[ " + desde;

        for (int i = desde+1; i <= hasta; i++) {
            secuencia = secuencia + " - " + i;
        }

        secuencia = secuencia + " ]";

        System.out.println(String.format("Mostrando secuencia inclusiva desde %s hasta %s", desde, hasta));
        System.out.println(secuencia);
    }
}
