import java.util.Scanner;

public class Ejercicio13 {

    private static Scanner scanner = new Scanner(System.in);

    private static final String TALLER = "taller";
    private static final String FUNDAMENTOS = "fundamentos";
    private static final String MATEMATICA = "matematica";

    public static void main(String[] args){
        int contadorTaller = 0;
        int contadorFundamentos = 0;
        int contadorMatematica = 0;

        int cantAlumnos = pedirCantidadAlumnos();

        for (int i = 0; i < cantAlumnos; i++) {
            String curso = pedirCurso(i+1);
            String materia = pedirMateria(i+1);

            switch (materia){
                case TALLER:
                    contadorTaller++;
                    break;
                case FUNDAMENTOS:
                    contadorFundamentos++;
                    break;
                case MATEMATICA:
                    contadorMatematica++;
                    break;
            }
        }

        mostrarResultado(contadorFundamentos, contadorMatematica, contadorTaller);

        scanner.close();
    }

    private static int pedirCantidadAlumnos(){
        return pedirNumeroMayorACero("Ingrese cantidad de alumnos");
    }

    private static String pedirCurso(int numeroDeAlumno){
        String input = "";
        String mensaje = String.format("Ingrese curso para alumno %s. (a/b/c/d)", numeroDeAlumno);

        System.out.println(mensaje);
        input = scanner.nextLine().toLowerCase();

        while(!esCursoValido(input)) {
            System.out.println("Error: curso inválido");

            System.out.println(mensaje);
            input = scanner.nextLine();
        }

        return input;
    }

    private static boolean esCursoValido(String curso){
        return curso.equals("a")
                || curso.equals("b")
                || curso.equals("c")
                || curso.equals("d");
    }

    private static String pedirMateria(int numeroDeAlumno){
        String input = "";
        String mensaje = String.format("Ingrese materia para alumno %s. (%s/%s/%s)", numeroDeAlumno, TALLER, MATEMATICA, FUNDAMENTOS);

        System.out.println(mensaje);
        input = scanner.nextLine();

        while(!esMateriaValida(input)) {
            System.out.println("Error: materia inválida");

            System.out.println(mensaje);
            input = scanner.nextLine();
        }

        return input;
    }

    private static boolean esMateriaValida(String materia){
        return materia.equals(TALLER)
                || materia.equals(MATEMATICA)
                || materia.equals(FUNDAMENTOS);
    }

    private static void mostrarResultado(int contadorFundamentos, int contadorMatematica, int contadorTaller){
        int total = contadorFundamentos+contadorMatematica+contadorTaller;

        if(sonTodosIguales(contadorFundamentos, contadorMatematica, contadorTaller)){
            mostrarIguales(contadorFundamentos);
        }
        else if (contadorFundamentos > contadorMatematica && contadorFundamentos > contadorTaller) {
            mostrarMayor(FUNDAMENTOS, contadorFundamentos, total);
        }
        else if (contadorMatematica > contadorFundamentos && contadorMatematica > contadorTaller){
            mostrarMayor(MATEMATICA, contadorMatematica, total);
        }
        else if (contadorTaller > contadorFundamentos && contadorTaller > contadorMatematica){
            mostrarMayor(TALLER, contadorTaller, total);
        }
        else{
            obtenerEmpate(contadorFundamentos, contadorMatematica, contadorTaller, total);
        }
    }

    private static boolean sonTodosIguales(int contadorFundamentos, int contadorMatematica, int contadorTaller){
        return contadorFundamentos==contadorMatematica && contadorMatematica==contadorTaller;
    }

    private static void mostrarMayor(String materia, int cant, int total){
        System.out.println(String.format("La materia que mas necesita clase de apoyo es %s con %s votos de %s", materia, cant, total));
    }

    private static void mostrarIguales(int cant){
        System.out.println(String.format("Las materias recibieron la misma cantidad de votos: %s", cant));
    }

    private static void obtenerEmpate(int contadorFundamentos, int contadorMatematica, int contadorTaller, int total){
        if(contadorFundamentos == contadorMatematica){
            mostrarEmpate(FUNDAMENTOS, MATEMATICA, contadorFundamentos, total);
        }
        else if(contadorFundamentos == contadorTaller){
            mostrarEmpate(FUNDAMENTOS, TALLER, contadorFundamentos, total);
        }
        else if(contadorTaller == contadorMatematica){
            mostrarEmpate(MATEMATICA, TALLER, contadorTaller, total);
        }
    }

    private static void mostrarEmpate(String materia1, String materia2, int cant, int total){
        System.out.println(String.format("%s y %s empataron con %s votos de %s", materia1, materia2, cant, total));
    }

    private static int pedirNumeroMayorACero(String mensaje){
        int aux=0;

        do {
            System.out.println(mensaje);
            aux=Integer.parseInt(scanner.nextLine());
        }while(aux <= 0);

        return aux;
    }
}
