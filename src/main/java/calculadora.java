
import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        calcularEcuacionRecta();
    }

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

    public static double ingresoValor() {
        double valor = 0;
        while (true) {
            System.out.print("Ingrese un valor: ");
            Scanner scanner = crearScanner();
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                break;
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }
        return valor;
    }

    //5.- calcular la ecuación de una recta de la forma: Y = mX + b, dados 2 puntos de la recta (x1,y1) (x2,y2).
    //m = pendiente; b = intersección con el eje y.

    //Función para crear la matriz de los puntos de la recta.
    public static double[][] matrizPuntosRecta(){
        return new double[2][2];
    }

    //Función para ingresar los puntos de la recta a la matriz.
    public static void ingresarPuntosRecta(double[][] matrizPuntos, double x1, double y1, double x2, double y2){
        matrizPuntos[0] = new double[]{x1,y1};
        matrizPuntos[1] = new double[]{x2,y2};
    }

    //Función para calcular la pendiente de la recta según los puntos.
    public static double pendienteRecta(double[][] matrizPuntos){
        double variacionY = matrizPuntos[1][1] - matrizPuntos[0][1];
        double variacionX = matrizPuntos[1][0] - matrizPuntos[0][0];
        return variacionY/variacionX;
    }

    //Función para manejar el error de dividir por cero, en la versión de java trabajada resulta en infinito, por lo que se crea la siguiente función.
    public static boolean rectaParalelaEjeY(double[][] matrizPuntos){
        if ((matrizPuntos[1][0] - matrizPuntos[0][0]) == 0){
            return true;
        }
        return false;
    }

    //Función para calcular la intersección con el eje y de la recta.
    public static double bRecta(double[][] matrizPuntos){
        return (matrizPuntos[0][1] - (matrizPuntos[0][0] * pendienteRecta(matrizPuntos)));
    }

    //Función para devolver en un enunciado la ecuación de la recta.
    public static String resultadoEcuacionRecta(double m, double b){
        return "La ecuación de la recta en forma Y = mX + b es: Y = "+m+"X + ("+b+").";
    }

    //Función para ejecutar los métodos necesarios para el cálculo de la ecuación de la recta e imprimir su resultado.
    public static void calcularEcuacionRecta(){
        double[][] matrizPuntos = matrizPuntosRecta();
        System.out.println("Ingrese los datos en el siguiente orden: x1, y1, x2, y2:");
        ingresarPuntosRecta(matrizPuntos, ingresoValor(), ingresoValor(), ingresoValor(), ingresoValor());
        if (rectaParalelaEjeY(matrizPuntos)){
            System.out.println("La recta es paralela al eje y, por lo tanto, la ecuación de la recta es Y = "+matrizPuntos[0][0]);
        } else {
            System.out.println(resultadoEcuacionRecta(pendienteRecta(matrizPuntos), bRecta(matrizPuntos)));
        }
    }
}