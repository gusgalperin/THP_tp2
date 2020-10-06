import java.util.Scanner;

public class Ejercicio15 {

    private static Scanner scanner = new Scanner(System.in);

    private static final int FIN = 0;
    private static final String ABONO_A = "a";
    private static final String ABONO_B = "b";
    private static final String ABONO_C = "c";
    private static final int CODIGO_CLIENTE_MIN = 10001;
    private static final int CODIGO_CLIENTE_MAX = 99999;

    public static void main(String[] args){

        int numeroCliente = 0;
        double costoLlamada = 0;

        int cantLlamadas = 0;

        double acumA = 0;
        double acumB = 0;
        double acumC = 0;

        int duracionLlamadasMasLarga = 0;
        int cantLlamadasMenos6minutos = 0;

        numeroCliente = pedirNumeroCliente();

        while(numeroCliente != FIN){

            String tipoAbono = pedirTipoAbono();

            int duracionLlamada = pedirDuracionLlamada();

            while (duracionLlamada > 0){
                cantLlamadas++;

                if(duracionLlamada > duracionLlamadasMasLarga){
                    duracionLlamadasMasLarga = duracionLlamada;
                }

                if(duracionLlamada < 6){
                    cantLlamadasMenos6minutos++;
                }

                switch (tipoAbono){
                    case ABONO_A:
                        costoLlamada = calcularCostoAbonoA(duracionLlamada);
                        acumA += costoLlamada;
                        break;
                    case ABONO_B:
                        costoLlamada = calcularCostoAbonoB(duracionLlamada);
                        acumB += costoLlamada;
                        break;
                    case ABONO_C:
                        costoLlamada = calcularCostoAbonoC(duracionLlamada);
                        acumC += costoLlamada;
                        break;
                }

                duracionLlamada = pedirDuracionLlamada();
            }

            numeroCliente = pedirNumeroCliente();
        }

        mostrarResumen(acumA, acumB, acumC, duracionLlamadasMasLarga, cantLlamadasMenos6minutos, cantLlamadas);

        scanner.close();
    }

    private static void mostrarResumen(double acumAbonoA, double acumAbonoB, double acumAbonoC, int durLlamadaMasLarga, int cantLlamadasMenos6Minutos, int cantTotalLLamadas){
        if(cantTotalLLamadas > 0) {
            System.out.println(String.format("Acumulado Abono A: %s", acumAbonoA));
            System.out.println(String.format("Acumulado Abono B: %s", acumAbonoB));
            System.out.println(String.format("Acumulado Abono C: %s", acumAbonoC));
            System.out.println(String.format("Cantidad minutos llamada mas larga: %s", durLlamadaMasLarga));
            System.out.println(String.format("Cantidad llamadas menos de 6 minutos: %s", cantLlamadasMenos6Minutos));
            System.out.println(String.format("Precio promedio por llamada: %s", (acumAbonoA + acumAbonoB + acumAbonoC) / cantTotalLLamadas));
        }
        else{
            System.out.println("No hubo llamadas");
        }
    }

    private static double calcularCostoAbonoA(int duracion){
        final double COSTO_MINUTO = 2;

        return COSTO_MINUTO * duracion;
    }

    private static double calcularCostoAbonoB(int duracion){
        final double COSTO_MINUTO_INIC = 2;
        final double COSTO_MINUTO_FINAL = 1.5;
        final double MIN_DIVISOR = 5;

        if(duracion <= MIN_DIVISOR){
            return COSTO_MINUTO_INIC * duracion;
        }
        else{
            return (COSTO_MINUTO_INIC * MIN_DIVISOR) + (COSTO_MINUTO_FINAL * (duracion - MIN_DIVISOR));
        }
    }

    private static double calcularCostoAbonoC(int duracion){
        final double COSTO_MINUTO = 1;
        final double MIN_MAX = 10;

        if(duracion <= MIN_MAX){
            return duracion * COSTO_MINUTO;
        }
        else{
            return MIN_MAX * COSTO_MINUTO;
        }
    }

    private static String pedirTipoAbono(){
        String input = "";
        String mensaje = String.format("Ingrese tipo de abono: (%s/%s/%s)", ABONO_A, ABONO_B, ABONO_C);

        System.out.println(mensaje);
        input = scanner.nextLine();

        while(!input.equals(ABONO_A) && !input.equals(ABONO_B) && !input.equals(ABONO_C)) {
            System.out.println("Error. " + mensaje);
            input = scanner.nextLine();
        }

        return input;
    }

    private static int pedirNumeroCliente(){
        int aux=0;

        aux = pedirNumero("Ingrese número de cliente");

        while (aux != FIN && (aux < CODIGO_CLIENTE_MIN && aux > CODIGO_CLIENTE_MAX)){
            System.out.println(String.format("Error: el numero de cliente debe estar entre %s y %s", CODIGO_CLIENTE_MIN, CODIGO_CLIENTE_MAX));
            aux = pedirNumero("Ingrese número de cliente");
        }

        return aux;
    }

    private static int pedirDuracionLlamada(){
        return pedirNumero("Ingrese duración de la llamada. 0 para fin");
    }

    private static int pedirNumero(String mensaje){
        System.out.println(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    private static int pedirNumeroEntre(String mensaje, int min, int max){
        int aux=0;

        do {
            System.out.println(mensaje);
            aux=Integer.parseInt(scanner.nextLine());
        }while(aux <= min || aux >= max);

        return aux;
    }
}
