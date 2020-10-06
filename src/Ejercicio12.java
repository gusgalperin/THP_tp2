import java.util.Scanner;

public class Ejercicio12 {

    private static Scanner scanner = new Scanner(System.in);

    private static final String SUMA = "+";
    private static final String RESTA = "-";
    private static final String MULTIPLICACION = "*";
    private static final String DIVISION = "/";
    private static final String RESTO = "%";

    private static final String FIN = "f";

    public static void main(String[] args){
        String operacion = obtenerOperacion();

        while (!operacion.equals(FIN)){

            double num1 = pedirNumero("Ingrese número 1", true);
            double num2 = pedirNumero("Ingrese número 2", !operacion.equals(DIVISION));
            double resultado = calcularResultado(num1, num2, operacion);

            System.out.println(String.format("%s %s %s = %s", num1, operacion, num2, resultado));

            operacion = obtenerOperacion();
        }

    }

    private static String obtenerOperacion(){
        String input = "";

        System.out.println(String.format("Ingrese operación. '%s' para fin", FIN));
        input = scanner.nextLine();

        while(!esOperacionValida(input)) {
            System.out.println("Error: operación inválida");

            System.out.println("Ingrese operación. 'f' para fin");
            input = scanner.nextLine();
        }

        return input;
    }

    private static double calcularResultado(double num1, double num2, String operacion){
        double resultado = 0;

        switch (operacion){
            case SUMA:
                resultado = sumar(num1, num2);
            case RESTA:
                resultado = restar(num1, num2);
            case MULTIPLICACION:
                resultado = multiplicar(num1, num2);
            case DIVISION:
                resultado = dividir(num1, num2);
            case RESTO:
                resultado = resto(num1, num2);
            default:
                System.out.println(String.format("ERROR %s no es operacion valida", operacion));
        }

        return resultado;
    }

    private static boolean esOperacionValida(String op){
        return op.equals(SUMA)
                || op.equals(RESTA)
                || op.equals(MULTIPLICACION)
                || op.equals(DIVISION)
                || op.equals(RESTO)
                || op.equals(FIN);
    }

    private static double sumar(double num1, double num2){
        return num1 + num2;
    }

    private static double restar(double num1, double num2){
        return num1 - num2;
    }

    private static double dividir(double num1, double num2){
        return num1 / num2;
    }

    private static double multiplicar(double num1, double num2){
        return num1 * num2;
    }

    private static double resto(double num1, double num2){
        return num1 % num2;
    }

    private static double pedirNumero(String mensaje, boolean aceptarCero){
        boolean valido = true;
        double aux=0;
        do {
            System.out.println(mensaje);
            aux=Double.parseDouble(scanner.nextLine());

            if(!aceptarCero){
                valido = aux!=0;
            }
        }while(!valido);
        return aux;
    }
}
