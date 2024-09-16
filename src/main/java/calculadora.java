import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class calculadora {
    public static void main(String[] args) {
        ejecutarMenuPAV();
    }

    // Inicio de funciones sección 3

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

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

}




