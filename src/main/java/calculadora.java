import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class calculadora {
    public static void main(String[] args) {
    }

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

    //Crea la lista de valores para el primer item
    public static double[] listaDosNumeros() {
        double[] numeros = new double[2];
        numeros[0] = ingresoValor();
        numeros[1] = ingresoValor();
        return numeros;
    }

    public static double[] listaTresNumeros() {
        double[] numeros = new double[3];
        System.out.println("La ecuacion cuadratica tiene la forma (Ax² + Bx + C = 0), digame los valores de A,B,C en el orden mostrado");
        numeros[0] = ingresoValor();
        numeros[1] = ingresoValor();
        numeros[2] = ingresoValor();
        return numeros;
    }

    //Con esta funcion nos aseguramos de que lo que ingresa el usuario sea un valor numerico
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


    //Entrega el numero mayor del array
    public static double mayorDeNumeros(double[] numeros) {
        return Arrays.stream(numeros).max().getAsDouble();
    }

    //Entrega el numero menor del array
    public static double menorDeNumeros(double[] numeros) {
        return Arrays.stream(numeros).min().getAsDouble();
    }

    //Entrega true si los numeros en el array son iguales
    public static boolean numerosIguales(double[] numeros) {
        return numeros[0] == numeros[1];
    }

    //Permite ejecutar las funciones de numero mayor, primero verificando si los numeros del array son iguales,
    //finalmente imprime el resultado mayot
    public static void ejecutarNumeroMayor() {
        double[] lista = listaDosNumeros();
        if (numerosIguales(lista)) {
            System.out.println("Los numeros son iguales.");
        } else System.out.println("El numero mayor es " + mayorDeNumeros(lista));
    }

    //Permite ejecutar las funciones de numero menor, primero verificando si los numeros del array son iguales,
    //finalmente imprime el resultado
    public static void ejecutarNumeroMenor() {
        double[] lista = listaDosNumeros();
        if (numerosIguales(lista)) {
            System.out.println("Los numeros son iguales.");
        } else System.out.println("El numero menor es " + menorDeNumeros(lista));
    }

    //Entrega el primer numero, elevado al segundo
    public static double potenciaNumeros(double[] numeros) {
        return Math.pow(numeros[0], numeros[1]);
    }

    //Devuelve true si ambos numeros en el array son cero.
    public static boolean ceroSobreCero(double[] numeros) {
        return numeros[0] == 0 && numeros[1] == 0;
    }

    //Devuelve true si cero esta elevado a un negativo
    public static boolean ceroSobreNegativo(double[] numeros) {
        return numeros[0] == 0 && (numeros[1] < 0);
    }

    //Ejecuta la funcion de potencia, verificando si es que es cero sobre cero, o cero sobre un numero negativo.
    //lo hago asi ya que el try en esta version no funciona ya que lanza los valores de los limites.
    public static void ejecutarPotencia() {
        double[] lista = listaDosNumeros();
        if (ceroSobreCero(lista)) {
            System.out.println("Error: Cero sobre cero.");
        } else if (ceroSobreNegativo(lista)) {
            System.out.println("Error: Cero sobre negativo.");
        } else {
            System.out.println("El numero mayor es " + mayorDeNumeros(lista));
        }
    }

    //Devuelve el valor de numeros[0] elevado a numeros[1]
    public static double porcentajeNumero(double[] numeros) {
        return (numeros[0] / 100) * numeros[1]; //numero[0] es el porcentaje que quiero calcular.
    }

    //Este entrega el error NaN, que es not a number cuando la solucion es imaginaria
    public static double solucionCuadratica1(double[] numeros) {
        return (-(numeros[1]) + sqrt((numeros[1] * numeros[1]) - (4 * numeros[0] * numeros[2]))) / (2 * numeros[0]);
    }

    //Este entrega el error NaN, que es not a number cuando la solucion es imaginaria
    public static double solucionCuadratica2(double[] numeros) {
        return (-(numeros[1]) - sqrt((numeros[1] * numeros[1]) - (4 * numeros[0] * numeros[2]))) / (2 * numeros[0]);
    }

    //Devuelve true si el determinante es negativo
    public static boolean determinanteCuadratica(double[] numeros) {
        return ((numeros[1] * numeros[1]) - (4 * numeros[0] * numeros[2])) < 0;
    }

    //Devuelve true si los tres valores ingresados son cero.
    public static boolean ceroSobreCeroCuadratica(double[] numeros) {
        return numeros[0] == 0 && numeros[1] == 0 && numeros[2] == 0;
    }

    //Si el a es cero, es division por cero, devuelve true si es division por cero.
    public static boolean divisionPorCeroCuadratica(double[] numeros) {
        return numeros[0] == 0;
    }

    public static void ejecutarCuadratica() {
        double[] lista = listaTresNumeros();
        if (determinanteCuadratica(lista)) {
            System.out.println("Error: Raiz imaginaria.");
        } else if (ceroSobreCeroCuadratica(lista)) {
            System.out.println("Error: Cero sobre cero.");
        } else if (divisionPorCeroCuadratica(lista)) {
            System.out.println("Error: Division por cero.");
        } else System.out.println("x1: " + solucionCuadratica1(lista) + "  /  x2: " + solucionCuadratica2(lista));
    }

    public static void ejecutarPorcentaje() {
        System.out.println("Dime a que numero le quieres calcular que porcentaje:");
        double[] lista = listaDosNumeros();
        System.out.println("El " + lista[1] + "% de " + lista[0] + " es " + porcentajeNumero(lista));
    }


    public static int leerOpcionMenuAritmetica() {
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if(opcion <= 4 && opcion >= 1) {
                    break;
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }
        return opcion;
    }

    public static void mostrarOpcionesMenuAritmetica() {
        System.out.println("\nMenú Aritmetica:");
        System.out.println("1) El mayor de dos numeros.");
        System.out.println("2) El menor de dos numeros.");
        System.out.println("3) Potencia.");
        System.out.println("4) Porcentaje de un numero.");
        System.out.print("Ingrese el número de la opción que desea seleccionar: ");
    }

    public static void ejecutarOpcionAritmetica(int opcion) {
        if (opcion == 1) {
            ejecutarNumeroMayor();
        } else if (opcion == 2) {
            ejecutarNumeroMenor();
        } else if (opcion == 3) {
            ejecutarPotencia();
        } else if (opcion == 4) {
            ejecutarPorcentaje();
        }


    }

    public static void menuAritmetica() {
        mostrarOpcionesMenuAritmetica();
        int opcion = leerOpcionMenuAritmetica();
        ejecutarOpcionAritmetica(opcion);
    }

}




