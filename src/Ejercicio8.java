import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args){
        System.out.println(String.format("(5, 3): %s", esMultiplo(5, 3)));
        System.out.println(String.format("(15, 3): %s", esMultiplo(15, 3)));
    }

    private static boolean esMultiplo(int num1, int num2){
        if (num1%num2 == 0)
            return true;
        else
            return false;
    }
}
