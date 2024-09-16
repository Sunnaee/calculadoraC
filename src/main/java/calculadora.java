import java.util.Arrays;

import static java.lang.Math.sqrt;

public class calculadora {
    public static void main(String[] args) {
        double [] numeros = new double[3];
        numeros[0] = 2;
        numeros[1] = 3;
        numeros[2] = 5;
        System.out.println(solucionCuadratica1(numeros));
        System.out.println(solucionCuadratica2(numeros));

    }

    public static double mayorDeNumeros(double[] numeros) {
        return Arrays.stream(numeros).max().getAsDouble();
    }

    public static double menorDeNumeros(double[] numeros) {
        return Arrays.stream(numeros).min().getAsDouble();
    }

    public static boolean numerosIguales(double [] numeros){
        return numeros[0] == numeros[1];
    }

    public static String numeroMayor(double[] numeros){
        if (numerosIguales(numeros)) {
            return "Numeros iguales";
        }else{
            return "El número mayor es: " + mayorDeNumeros(numeros);
        }
    }

    public static String numeroMenor(double[] numeros){
        if (numerosIguales(numeros)) {
            return "Numeros iguales";
        } else {
            return "El número menor es: " + menorDeNumeros(numeros);
        }
    }

    public static void ejecutarNumeroMayor(double[] numeros){
        System.out.println(numeroMayor(numeros));
    }

    public static void ejecutarNumeroMenor(double[] numeros){
        System.out.println(numeroMenor(numeros));
    }

    public static double potenciaNumeros(double [] numeros){
        return Math.pow(numeros[0], numeros[1]);
    }

    public static boolean ceroSobreCero(double[] numeros){
        return numeros[0] == 0 && numeros[1] == 0;
    }

    public static String resultadoPotencia(double[] numeros){
        if(ceroSobreCero(numeros)){
            return "No se puede elevar cero sobre cero";
        }
        return "El resultado es: " + potenciaNumeros(numeros);
    }

    public static double porcentajeNumero(double[] numeros){
        return (numeros[0]/100) * numeros[1]; //numero[0] es el porcentaje que quiero calcular.
    }

    //Este entrega el error NaN, que es not a number cuando la solucion es imaginaria
    public static double solucionCuadratica1(double[] numeros){
        return (-(numeros[1]) + sqrt((numeros[1]*numeros[1])-(4*numeros[0]*numeros[2]))) / (2*numeros[0]);
    }

    //Este entrega el error NaN, que es not a number cuando la solucion es imaginaria
    public static double solucionCuadratica2(double[] numeros){
        return (-(numeros[1]) - sqrt((numeros[1]*numeros[1])-(4*numeros[0]*numeros[2]))) / (2*numeros[0]);
    }

    // Inicio de funciones sección 3

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

    public static double volumenCono (double radiobasal, double altura) {
        return altura*Math.PI*Math.pow(radiobasal,2)/3;
    }

}




