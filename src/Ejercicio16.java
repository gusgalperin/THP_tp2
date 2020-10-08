import java.util.Scanner;

public class Ejercicio16 {

    private static Scanner scanner = new Scanner(System.in);

    private static final String NOMBRE_CLASICO = "clasico";
    private static final String NOMBRE_CELIACO = "celiaco";
    private static final String NOMBRE_KOSHER = "kosher";
    private static final String NOMBRE_LIGHT = "light";
    private static final String FIN = "fin";

    public static void main(String[] args){

        int cantInvitados = 0;
        int cantIngresados = 0;
        int cantClasico = 0;
        int cantCeliaco = 0;
        int cantKosher = 0;
        int cantLight = 0;

        String tipoMenu = "";
        int cantParaTipo = 0;

        boolean ingresarDatos = pedirIngresarDatos();

        while(ingresarDatos){
            cantIngresados = 0;
            cantClasico = 0;
            cantCeliaco = 0;
            cantKosher = 0;
            cantLight = 0;

            cantInvitados = pedirCantidadInvitados();

            while(cantIngresados != cantInvitados){
                tipoMenu = pedirTipoMenu();

                if(tipoMenu.equals(FIN)){
                    System.out.println(String.format("Warning: se ingresaron menos invitados (%s) que los ingresados originalmente (%s)", cantIngresados, cantInvitados));
                    cantInvitados = cantIngresados;
                }
                else{
                    cantParaTipo = pedirCantidadParaTipo(tipoMenu, cantInvitados - cantIngresados);

                    cantIngresados+=cantParaTipo;

                    switch (tipoMenu){
                        case NOMBRE_CLASICO:
                            cantClasico+=cantParaTipo;
                            break;
                        case NOMBRE_CELIACO:
                            cantCeliaco+=cantParaTipo;
                            break;
                        case NOMBRE_KOSHER:
                            cantKosher+=cantParaTipo;
                            break;
                        case NOMBRE_LIGHT:
                            cantLight+=cantParaTipo;
                            break;
                    }
                }
            }

            mostrarCostoCatering(cantInvitados, cantClasico, cantCeliaco, cantKosher, cantLight);

            ingresarDatos = pedirIngresarDatos();
        }

        scanner.close();
    }

    private static void mostrarCostoCatering(int cantInvitados, int cantClasico, int cantCeliaco, int cantKosher, int cantLight){
        final double PRECIO_CLASICO = 300;
        final double PRECIO_CELIACO = 310;
        final double PRECIO_KOSHER = 430;
        final double PRECIO_LIGHT = 290;
        final double PRECIO_BEBIDA = 30;

        if(cantInvitados > 0){
            double totalClasico = cantClasico*PRECIO_CLASICO;
            double totalCeliaco = cantCeliaco*PRECIO_CELIACO;
            double totalKosher = cantKosher*PRECIO_KOSHER;
            double totalLight = cantLight*PRECIO_LIGHT;
            double totalComida = totalCeliaco+totalClasico+totalKosher+totalLight;
            double totalBebida = cantInvitados*PRECIO_BEBIDA;

            System.out.println(String.format("Usted ha invitado %s personas.", cantInvitados));
            if(totalClasico>0)
                System.out.println(String.format("Menu %s: %s ----- $%s", NOMBRE_CLASICO, cantClasico, totalClasico));
            if(totalCeliaco>0)
                System.out.println(String.format("Menu %s: %s ----- $%s", NOMBRE_CELIACO, cantCeliaco, totalCeliaco));
            if(totalKosher>0)
                System.out.println(String.format("Menu %s: %s ----- $%s", NOMBRE_KOSHER, cantKosher, totalKosher));
            if(totalLight>0)
                System.out.println(String.format("Menu %s: %s ----- $%s", NOMBRE_LIGHT, cantLight, totalLight));
            System.out.println(String.format("Total comida: $%s", totalComida));
            System.out.println(String.format("Total bebido: $%s", totalBebida));
            System.out.println(String.format("El costo total es: $%s", totalComida + totalBebida));
        }
        else{
            System.out.println("No hubo invitados");
        }
    }

    private static int pedirCantidadInvitados(){
        int cant = pedirNumero("Ingrese cantidad total de invitados");

        while(cant <= 0){
            System.out.println("Error.");
            cant = pedirNumero("Ingrese cantidad total de invitados");
        }

        return cant;
    }

    private static String pedirTipoMenu(){
        String mensaje = String.format(
            "Ingrese tipo de menu: (%s/%s/%s/%s/%s)",
            NOMBRE_CLASICO, NOMBRE_CELIACO, NOMBRE_KOSHER, NOMBRE_LIGHT, FIN);

        String input = pedirCadena(mensaje);

        while(!input.equals(NOMBRE_CLASICO) && !input.equals(NOMBRE_CELIACO) && !input.equals(NOMBRE_KOSHER) && !input.equals(NOMBRE_LIGHT) && !input.equals(FIN)) {
            input = pedirCadena("Error. " + mensaje);
        }

        return input;
    }

    private static int pedirCantidadParaTipo(String tipoMenu, int invitadosRestantes){
        String mensaje = String.format(
            "Ingrese la cantidad de invitados que eligieron %s. Restan ingresar %s invitados", tipoMenu, invitadosRestantes);

        int cant = pedirNumero(mensaje);

        while(cant < 0 || cant > invitadosRestantes){
            System.out.println(String.format("Error. Restan ingresar %s invitados", invitadosRestantes));
            cant = pedirNumero(mensaje);
        }

        return cant;
    }

    private static boolean pedirIngresarDatos(){
        String mensaje = "¿Desea calcular el precio total del catering para su fiesta?: (s/n)";

        String input = pedirCadena(mensaje);

        while(!input.equals("s") && !input.equals("n")) {
            input = pedirCadena("Error. " + mensaje);
        }

        return input.equals("s");
    }

    private static int pedirNumero(String mensaje){
        System.out.println(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    private static String pedirCadena(String mensaje){
        System.out.println(mensaje);
        return scanner.nextLine();
    }
}
