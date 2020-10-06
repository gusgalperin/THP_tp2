import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7 {

    private static Scanner scanner = new Scanner(System.in);
    final static String USUARIO_CORRECTO = "admin";
    final static String CONTRASEÑA_CORRECTA = "1234";

    public static void main(String[] args){
        final int CANTIDAD_INTENTOS = 3;

        int numeroDeIntento = 0;
        boolean datosCorrectos = false;

        do{
            System.out.println(String.format("Intento %s/%s:", numeroDeIntento+1, CANTIDAD_INTENTOS));

            String usuarioIngresado = pedirCadena("Ingrese usuario");
            String contraseñaIngresada = pedirCadena("Ingrese contraseña");

            datosCorrectos = validarDatosCorrectos(usuarioIngresado, contraseñaIngresada);

            if(!datosCorrectos){
                numeroDeIntento++;
                System.out.println("Usuario o contraseña incorrectos");
            }

        } while(!datosCorrectos && numeroDeIntento < CANTIDAD_INTENTOS);

        if(datosCorrectos){
            System.out.println("Acceso concedido");
        }
        else{
            System.out.println("Se ha bloqueado su cuenta");
        }
    }

    private static boolean validarDatosCorrectos(String usuario, String contraseña){
        return usuario.equals(USUARIO_CORRECTO) && contraseña.equals(CONTRASEÑA_CORRECTA);
    }

    private static String pedirCadena(String mensaje){
        String input = "";

        do {

            System.out.println(mensaje);
            input = scanner.nextLine();

        } while (input.equals(""));

        return input;
    }
}
