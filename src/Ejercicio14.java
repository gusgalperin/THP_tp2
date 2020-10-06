import java.util.Scanner;

public class Ejercicio14 {

    private static Scanner scanner = new Scanner(System.in);

    private static final String FIN = "-1";
    private static final int CANT_MIN_VIAJES = -1;
    private static final int CANT_MAX_VIAJES = 1000;

    public static void main(String[] args){

        String nombreEmpresa = "";
        int cantidadEmpresas = 0;
        double totalFacturacion = 0;

        String empresaMayorFactura = "";
        double mayorFactura = 0;

        nombreEmpresa = pedirNombreEmpresa();

        while(!nombreEmpresa.equals(FIN)){
            cantidadEmpresas++;

            int cantidadViajes = pedirNumeroEntre(String.format("Ingrese cantidad de viajes adicionales para la empresa %s", nombreEmpresa), CANT_MIN_VIAJES, CANT_MAX_VIAJES);
            double totalEmpresa = calcularFactura(cantidadViajes);

            if(totalEmpresa > mayorFactura){
                mayorFactura = totalEmpresa;
                empresaMayorFactura = nombreEmpresa;
            }

            totalFacturacion+=totalEmpresa;

            mostrarTotalEmpresa(nombreEmpresa, cantidadViajes, totalEmpresa);

            nombreEmpresa = pedirNombreEmpresa();
        }

        System.out.println("***** FIN DE INGRESO *****");

        if(cantidadEmpresas > 0){
            System.out.println(String.format(
                    "Promedio de facturación: %s", totalFacturacion/cantidadEmpresas));

            System.out.println(String.format(
                    "La mayor factura fue de $%s de la empresa %s", mayorFactura, empresaMayorFactura));
        }
        else{
            System.out.println("SIN DATOS");
        }
        scanner.close();
    }

    private static double calcularFactura(int cantidadViajesAdicionales){
        final double PRECIO_BASICO = 8500;
        final double PRECIO_ADICIONAL = 100;
        final double PORCENTAJE_DESCUENTO = 10;
        final int CANT_VIAJES_PROMO = 30;

        double subtotal = PRECIO_BASICO + PRECIO_ADICIONAL * cantidadViajesAdicionales;

        if(cantidadViajesAdicionales > CANT_VIAJES_PROMO) {
            subtotal = subtotal - (PORCENTAJE_DESCUENTO * subtotal / 100);
        }

        return subtotal;
    }

    private static void mostrarTotalEmpresa(String nombreEmpresa, int cantidadViajes, double totalEmpresa){
        System.out.println(String.format(
                "La empresa “%s”, que necesitó hacer %s viajes adicionales en el mes, deberá pagar una factura de $%s",
                nombreEmpresa,
                cantidadViajes,
                totalEmpresa));
    }

    private static String pedirNombreEmpresa(){
        String input = "";
        String mensaje = String.format("Ingrese nombre de empresa. para salir: %s", FIN);

        System.out.println(mensaje);
        input = scanner.nextLine();

        while(input.equals("")) {
            System.out.println(mensaje);
            input = scanner.nextLine();
        }

        return input;
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
