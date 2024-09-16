
public class calculadora {
    public static void main(String[] args) {
        double [][] ecuaciones = new double[2][3];
        ecuaciones[0] = new double[]{1,1,1};
        ecuaciones[1] = new double[]{1,1,2};
        resultados(ecuaciones);

    }

    //SISTEMAS DE ECUACIONES

    public static double determinante(double[][] ecuaciones){
        double a1 = ecuaciones[0][0];
        double b1 = ecuaciones[0][1];
        double a2 = ecuaciones[1][0];
        double b2 = ecuaciones[1][1];
        return (a1*b2)-(a2*b1);
    }

    public static double determinanteX(double[][] ecuaciones){
        double b1 = ecuaciones[0][1];
        double c1 = ecuaciones[0][2];
        double b2 = ecuaciones[1][1];
        double c2 = ecuaciones[1][2];
        return (c1*b2)-(c2*b1);
    }

    public static double determinanteY(double[][] ecuaciones){
        double a1 = ecuaciones[0][0];
        double c1 = ecuaciones[0][2];
        double a2 = ecuaciones[1][0];
        double c2 = ecuaciones[1][2];
        return (a1*c2)-(a2*c1);
    }

    public static double resultadoX(double[][] ecuaciones){
        return (determinanteX(ecuaciones))/(determinante(ecuaciones));
    }

    public static double resultadoY(double[][] ecuaciones){
        return (determinanteY(ecuaciones))/(determinante(ecuaciones));
    }

    public static boolean determinanteDistintoCero(double[][] ecuaciones){
        if (determinante(ecuaciones) != 0){
            return true;
        } else{
            return false;
        }
    }

    public static void resultados(double[][] ecuaciones){
        if (determinanteDistintoCero(ecuaciones)){
            System.out.println("Soluciones:");
            System.out.println("x = " + resultadoX(ecuaciones));
            System.out.println("y = " + resultadoY(ecuaciones));
        } else {
            System.out.println("El sistema de ecuaciones tiene soluciones infinitas");
        }

    }

}




