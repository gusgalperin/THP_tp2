import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio10 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        final String COND_FIN = "0";
        final String MENSAJE_NOMBRE_CORREDOR = String.format("Ingrese nombre de corredor. para salir: '%s'", COND_FIN);

        int totalCorredores = 0;
        String nombreGanador = "";
        int tiempoGanador = 0;
        int sumatoriaTiemposTotal = 0;
        int cantidadCorredoresMenosUnaHora = 0;

        String nombreCorredor = "";
        nombreCorredor = pedirCadena(MENSAJE_NOMBRE_CORREDOR);

        while(!nombreCorredor.equals(COND_FIN)){

            int segundosCorredor = pedirTiemposCorredor(nombreCorredor);

            totalCorredores++;
            sumatoriaTiemposTotal += segundosCorredor;

            if(tiempoGanador == 0 || segundosCorredor < tiempoGanador){
                tiempoGanador = segundosCorredor;
                nombreGanador = nombreCorredor;
            }

            if(segundosCorredor < 3600){
                cantidadCorredoresMenosUnaHora ++;
            }

            nombreCorredor = pedirCadena(MENSAJE_NOMBRE_CORREDOR);
        }

        if(totalCorredores == 0){
            System.out.println("No hubo corredores -");
            return;
        }

        System.out.println("**** RESULTADOS ****");
        System.out.println(String.format("El ganador fué %s con %s segundos", nombreGanador, tiempoGanador));
        System.out.println(String.format("El promedio en segundos fue: %s", (double)sumatoriaTiemposTotal/totalCorredores));
        System.out.println(String.format("El porcentaje de corredores que realizo la carrera en menos de una hora fue: %s ", (double)cantidadCorredoresMenosUnaHora*100/totalCorredores));

    }

    private static int pedirTiemposCorredor(String nombre){
        System.out.println(String.format("***** %s *****", nombre));

        int horas=pedirNumero("Ingrese horas");
        int minutos=pedirNumero("Ingrese minutos");
        int segundos=pedirNumero("Ingrese segundos");

        return devolverSegundos(horas, minutos, segundos);
    }

    private static int devolverSegundos(int horas, int minutos, int segundos){
        return horas*60*60 + minutos*60 + segundos;
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
