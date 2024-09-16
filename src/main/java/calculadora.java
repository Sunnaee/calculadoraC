import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.sqrt;
import java.util.InputMismatchException;


public class calculadora {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        while (true){
            mostrarOpcionesMenu();
            int opcion = leerOpcionMenu();
            if (opcion == 6){
                break;
            } else {
                ejecutarOpcionMenu(opcion);
            }
        }
        System.out.println("Cerrrando programa...");
    }

    public static void ejecutarOpcionMenu(int opcion){
        if (opcion == 1){
            menuAritmetica();
        } else if (opcion == 2){
            ejecutarCuadratica();
        } else if (opcion == 3){
            ejecutarMenuPAV();
        } else if (opcion == 4){
            ejecutarEcuaciones();
        } else if (opcion == 5){
            calcularEcuacionRecta();
        }
    }

    public static int leerOpcionMenu(){
        int opcion;
        while(true){
            try{
                System.out.print("Seleccione una opción: ");
                opcion = scanner().nextInt();
                if(opcion >= 1 && opcion <= 6){
                    break;
                } else {
                    System.out.println("Ingrese un número valido.");
                }
            } catch (InputMismatchException e ){
                System.out.println("Ingrese una entrada valida. Intente de nuevo.");
            }
        }
        return opcion;
    }

    public static void mostrarOpcionesMenu(){
        System.out.println("Calculadora cientifica: ");
        System.out.println("1. Operaciones artiméticas.");
        System.out.println("2. Ecuación cuadrática.");
        System.out.println("3. Figuras geométricas.");
        System.out.println("4. Sistema de ecuaciones lineales.");
        System.out.println("5. Ecuación de la recta.");
        System.out.println("6. Salir.");
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

    // Inicio de funciones sección 3

    public static double escogerNumero(){
        double option;
        while (true) {
            try {
                option = crearScanner().nextDouble();
                if (option > 0){
                    break;
                } else {
                    System.out.print("Opción sale del rango. Inténtelo nuevamente (valores > 0): ");
                }
            } catch (Exception InputMismatchException) {
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return option;
    }

    public static double perimetroCuadrado(double lado){
        return 4*lado;
    }

    public static double areaCuadrado(double lado){
        return lado*lado;
    }

    public static double perimetroRectangulo (double lado1, double lado2){
        return 2*lado1+2*lado2;
    }

    public static double areaRectangulo (double lado1, double lado2){
        return lado1*lado2;
    }

    public static double perimetroCirculo (double radio) {
        return 2*Math.PI*radio;
    }

    public static double areaCirculo (double radio) {
        return Math.PI*Math.pow(radio, 2);
    }

    public static double areaEsfera (double radio) {
        return 4*Math.PI*Math.pow(radio, 2);
    }

    public static double volumenEsfera (double radio) {
        return ((4*Math.PI*Math.pow(radio, 3))/3);
    }

    public static double areaCubo (double lado) {
        return 6*Math.pow(lado, 2);
    }

    public static double volumenCubo (double lado) {
        return Math.pow(lado,3);
    }

    public static double areaCono (double radioBasal, double generatriz) {
        return areaCirculo(radioBasal) + Math.PI*radioBasal*generatriz;
    }

    public static double volumenCono (double radioBasal, double altura) {
        return altura*Math.PI*Math.pow(radioBasal,2)/3;
    }

    public static void ejecutarMenuPAV(){
        int opcion;
        while (true) {
            mostrarMenuPAV();
            opcion = leerOpcionPAV();
            if (opcion == 7) {
                System.out.println("Cerrando menú...");
                break;
            } else {
                ejecutarOpcionPAV(opcion);
            }
        }
    }

    public static void mostrarMenuPAV() {
        System.out.println("\nOpciones de figuras: ");
        System.out.println("1. Cuadrado (perímetro y área).");
        System.out.println("2. Rectángulo (perímetro y área).");
        System.out.println("3. Círculo (perímetro y área).");
        System.out.println("4. Esféra (área y volumen).");
        System.out.println("5. Cubo (área y volumen).");
        System.out.println("6. Cono (área y volumen).");
        System.out.println("7. Volver.");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcionPAV() {
        int opcion;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 7) {
                    break;
                } else {
                    System.out.print("Opción inválida. Intente nuevamente: ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }
        return opcion;
    }

    public static void ejecutarOpcionPAV(int opcion){
        if (opcion == 1) {
            System.out.print("Lados del cuadrado: ");
            double lado = escogerNumero();
            System.out.println("El perímetro del cuadrado es: "+perimetroCuadrado(lado)+" y el área del cuadrado es: "+areaCuadrado(lado));
        } else if (opcion == 2) {
            System.out.print("Lado a del rectángulo: ");
            double lado1 = escogerNumero();
            System.out.print("Lado b del rectángulo: ");
            double lado2 = escogerNumero();
            System.out.println("El perímetro del rectángulo es: "+perimetroRectangulo(lado1, lado2)+" y el área del rectángulo es: "+areaRectangulo(lado1, lado2));
        } else if (opcion == 3) {
            System.out.print("Radio del círculo: ");
            double radio = escogerNumero();
            System.out.println("El perímetro del círculo es: "+perimetroCirculo(radio)+" y el área del círculo es:"+areaCirculo(radio));
        } else if (opcion == 4) {
            System.out.print("Radio de la esféra: ");
            double radio = escogerNumero();
            System.out.println("El área de la esféra es: "+areaEsfera(radio)+" yl volumen de la esféra es: "+volumenEsfera(radio));
        } else if (opcion == 5) {
            System.out.print("Lados del cubo: ");
            double lado = escogerNumero();
            System.out.println("El área del cubo es: "+areaCubo(lado)+" y el volumen del cubo es: "+volumenCubo(lado));
        } else if (opcion == 6) {
            System.out.print("Radio basal del cono: ");
            double radioBasal = escogerNumero();
            System.out.print("Generatriz del cono: ");
            double generatriz = escogerNumero();
            System.out.print("Altura del cono: ");
            double altura = escogerNumero();
            System.out.println("El área del cono es: "+areaCono(radioBasal, generatriz)+" y el volumen del cono es: "+volumenCono(radioBasal, altura));
        }
    }

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