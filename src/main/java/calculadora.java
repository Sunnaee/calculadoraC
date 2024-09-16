import java.util.InputMismatchException;
import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {}

    //SISTEMAS DE ECUACIONES

    public static void ejecutarEcuaciones(){
        double [][] ecuaciones = new double[2][3];
        mostrarInformacionEcuaciones();
        ingresarValoresEcuaciones(ecuaciones,"A",0,0);
        ingresarValoresEcuaciones(ecuaciones,"B",0,1);
        ingresarValoresEcuaciones(ecuaciones,"C",0,2);
        ingresarValoresEcuaciones(ecuaciones,"D",1,0);
        ingresarValoresEcuaciones(ecuaciones,"E",1,1);
        ingresarValoresEcuaciones(ecuaciones,"F",1,2);
        resultadosEcuaciones(ecuaciones);
    }

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    public static void ingresarValoresEcuaciones(double [][] ecuaciones,String letra, int fila, int columna){
        double numero;
        while (true){
            try{
                System.out.print(letra + ": ");
                numero = scanner().nextDouble();
                break;
            } catch (InputMismatchException e){
                System.out.println("Entrada no valida. Ingrese un numero");
            }
        }
        ecuaciones[fila][columna] = numero;
    }

    public static void mostrarInformacionEcuaciones(){
        System.out.println("Ingresa los valores de las ecuaciones:");
        System.out.println("Forma ecuación:");
        System.out.println("Ax + By = C\nDx + Ey = F");
    }

    public static double determinanteEcuaciones(double[][] ecuaciones){
        double a1 = ecuaciones[0][0];
        double b1 = ecuaciones[0][1];
        double a2 = ecuaciones[1][0];
        double b2 = ecuaciones[1][1];
        return (a1*b2)-(a2*b1);
    }

    public static double determinanteEcuacionesX(double[][] ecuaciones){
        double b1 = ecuaciones[0][1];
        double c1 = ecuaciones[0][2];
        double b2 = ecuaciones[1][1];
        double c2 = ecuaciones[1][2];
        return (c1*b2)-(c2*b1);
    }

    public static double determinanteEcuacionesY(double[][] ecuaciones){
        double a1 = ecuaciones[0][0];
        double c1 = ecuaciones[0][2];
        double a2 = ecuaciones[1][0];
        double c2 = ecuaciones[1][2];
        return (a1*c2)-(a2*c1);
    }

    public static double resultadoX(double[][] ecuaciones){
        return (determinanteEcuacionesX(ecuaciones))/(determinanteEcuaciones(ecuaciones));
    }

    public static double resultadoY(double[][] ecuaciones){
        return (determinanteEcuacionesY(ecuaciones))/(determinanteEcuaciones(ecuaciones));
    }

    public static boolean determinanteEcuacionesDistintoCero(double[][] ecuaciones){
        if (determinanteEcuaciones(ecuaciones) != 0){
            return true;
        } else{
            return false;
        }
    }

    public static void resultadosEcuaciones(double[][] ecuaciones){
        if (determinanteEcuacionesDistintoCero(ecuaciones)){
            System.out.println("Soluciones:");
            System.out.println("x = " + resultadoX(ecuaciones));
            System.out.println("y = " + resultadoY(ecuaciones));
        } else {
            System.out.println("El sistema de ecuaciones tiene soluciones infinitas");
        }

    }

}




