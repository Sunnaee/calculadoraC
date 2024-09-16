import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class calculadoraTest {
    double[][] ecuaciones = new double[2][3];
    double[][] matrizPuntos = new double[2][2];
    double[][] matrizPuntos2 = new double[2][2];


    double [] numerosCuadratica1 = new double[3];
    double [] numerosCuadratica2 = new double[3];
    double [] numerosMayorYMenor1 = new double[2];
    double [] numerosMayorYMenor2 = new double[2];
    double [] numerosIguales = new double[2];
    double [] numerosPorcentaje1 = new double[2];
    double [] numerosPorcentaje2 = new double[2];

    double [] ceros1 = new double[2];
    double [] ceros2 = new double[3];
    double [] numerosCeroSobreNegativo = new double[2];
    double [] numerosDetNegativo = new double[3];
    double [] cerosCuadratica = new double[3];



    @BeforeEach
    void setUp() {
        numerosCuadratica1[0] = 1;
        numerosCuadratica1[1] = 3;
        numerosCuadratica1[2] = -10;

        numerosCuadratica2[0] = 1;
        numerosCuadratica2[1] = -6;
        numerosCuadratica2[2] = -40;

        numerosMayorYMenor1[0] = 1;
        numerosMayorYMenor1[1] = 3;

        numerosMayorYMenor2[0] = -0.5;
        numerosMayorYMenor2[1] = -6;

        numerosIguales[0] = 3;
        numerosIguales[1] = 3;

        numerosPorcentaje1[0] = 70; //a 70 le calculo un 80 porciento
        numerosPorcentaje1[1] = 80;

        numerosPorcentaje2[0] = 50; //a 50 le calculo el 110 porciento
        numerosPorcentaje2[1] = 110;

        ceros1[0] = 0;
        ceros1[1] = 0;

        ceros2[0] = 0;
        ceros2[1] = 0;
        ceros2[2] = 0;

        numerosCeroSobreNegativo[0] = 0;
        numerosCeroSobreNegativo[1] = -10;

        numerosDetNegativo[0] = 2;
        numerosDetNegativo[1] = 1;
        numerosDetNegativo[2] = 3;

        cerosCuadratica[0] = 0;
        cerosCuadratica[1] = 0;
        cerosCuadratica[2] = 0;

        ecuaciones[0] = new double[]{1.2,2.3,0};
        ecuaciones[1] = new double[]{1.2,3.3,1};

        System.out.println("Preparándo matriz recta para una prueba...");
        matrizPuntos[0] = new double[]{-5,-2};
        matrizPuntos[1] = new double[]{5,4};
        matrizPuntos2[0] = new double[]{7,-6};
        matrizPuntos2[1] = new double[]{7,1};

    }
    @AfterEach
    void tearDown() {
        System.out.println("Limpiando matriz recta para una prueba...");
        matrizPuntos[0] = new double[]{0,0};
        matrizPuntos[1] = new double[]{0,0};
        matrizPuntos2[0] = new double[]{0,0};
        matrizPuntos2[1] = new double[]{0,0};
    }

    @Test
    void mayorDeNumeros() {
        assertEquals(3, calculadora.mayorDeNumeros(numerosMayorYMenor1));
        assertEquals(-0.5, calculadora.mayorDeNumeros(numerosMayorYMenor2));
    }

    @Test
    void menorDeNumeros() {
        assertEquals(1,calculadora.menorDeNumeros(numerosMayorYMenor1));
        assertEquals(-6,calculadora.menorDeNumeros(numerosMayorYMenor2));
    }

    @Test
    void numerosIguales() {
        assertTrue(calculadora.numerosIguales(numerosIguales));
        assertFalse(calculadora.numerosIguales(numerosMayorYMenor1));
    }

    @Test
    void potenciaNumeros() {
        assertEquals(27, calculadora.potenciaNumeros(numerosIguales));
        assertEquals(1, calculadora.potenciaNumeros(numerosMayorYMenor1));

    }

    @Test
    void porcentajeNumero() {
        assertEquals(56, calculadora.porcentajeNumero(numerosPorcentaje1));
        assertEquals(55, calculadora.porcentajeNumero(numerosPorcentaje2));

    }

    @Test
    void solucionCuadratica1() {
        assertEquals(2,calculadora.solucionCuadratica1(numerosCuadratica1));
        assertEquals(10,calculadora.solucionCuadratica1(numerosCuadratica2));
    }

    @Test
    void solucionCuadratica2() {
        assertEquals(-5,calculadora.solucionCuadratica2(numerosCuadratica1));
        assertEquals(-4,calculadora.solucionCuadratica2(numerosCuadratica2));
    }

    @Test
    void ceroSobreCero(){
        assertTrue(calculadora.ceroSobreCero(ceros1));
        assertFalse(calculadora.ceroSobreCero(numerosMayorYMenor1));
    }

    @Test
    void ceroSobreNegativo(){
        assertTrue(calculadora.ceroSobreNegativo(numerosCeroSobreNegativo));
        assertFalse(calculadora.ceroSobreNegativo(numerosIguales));
    }

    @Test
    void determinanteCuadratica(){
        assertFalse(calculadora.determinanteCuadratica(numerosCuadratica1));
        assertTrue(calculadora.determinanteCuadratica(numerosDetNegativo));
    }

    @Test
    void ceroSobreCeroCuadratica(){
        assertTrue(calculadora.ceroSobreCeroCuadratica(cerosCuadratica));
        assertFalse(calculadora.ceroSobreCeroCuadratica(numerosCuadratica1));
    }

    @Test
    void divisioSobreCeroCuadratica(){
        assertTrue(calculadora.divisionPorCeroCuadratica(cerosCuadratica));
        assertFalse(calculadora.divisionPorCeroCuadratica(numerosCuadratica1));
    }

    @Test
    void testPerimetros() {
        assertEquals(8, calculadora.perimetroCuadrado(2));
        assertEquals(16, calculadora.perimetroCuadrado(4));
        assertEquals(10, calculadora.perimetroRectangulo(2,3));
        assertEquals(14, calculadora.perimetroRectangulo(2,5));
        assertEquals(2*Math.PI, calculadora.perimetroCirculo(1));
        assertEquals(4*Math.PI, calculadora.perimetroCirculo(2));
    }

    @Test
    void testAreas() {
        assertEquals(1, calculadora.areaCuadrado(1));
        assertEquals(16, calculadora.areaCuadrado(4));
        assertEquals(6, calculadora.areaRectangulo(2,3));
        assertEquals(10, calculadora.areaRectangulo(2,5));
        assertEquals(1*Math.PI, calculadora.areaCirculo(1));
        assertEquals(4*Math.PI, calculadora.areaCirculo(2));
        assertEquals(4*Math.PI,calculadora.areaEsfera(1));
        assertEquals(16*Math.PI,calculadora.areaEsfera(2));
        assertEquals(6,calculadora.areaCubo(1));
        assertEquals(24,calculadora.areaCubo(2));
        assertEquals(2*Math.PI , calculadora.areaCono(1,1));
        assertEquals(8*Math.PI , calculadora.areaCono(2,2));
    }

    @Test
    void testVolumenes() {
        assertEquals(4*Math.PI/3, calculadora.volumenEsfera(1));
        assertEquals(32*Math.PI/3, calculadora.volumenEsfera(2));
        assertEquals(1, calculadora.volumenCubo(1));
        assertEquals(8, calculadora.volumenCubo(2));
        assertEquals(Math.PI/3, calculadora.volumenCono(1,1));
        assertEquals(8*Math.PI/3, calculadora.volumenCono(2,2));
    }

    @Test
    void determinanteEcuaciones(){
        assertEquals(((1.2*3.3)-(1.2*2.3)),calculadora.determinanteEcuaciones(ecuaciones));
        ecuaciones[0][0] = 0;
        assertEquals(-2.76,calculadora.determinanteEcuaciones(ecuaciones));
    }

    @Test
    void determinanteEcuacionesX(){
        assertEquals(-2.3,calculadora.determinanteEcuacionesX(ecuaciones));
        ecuaciones[0][1] = 0;
        assertEquals(0,calculadora.determinanteEcuacionesX(ecuaciones));
    }

    @Test
    void determinanteEcuacionesY(){
        assertEquals(1.2,calculadora.determinanteEcuacionesY(ecuaciones));
        ecuaciones[0][2] = 1;
        assertEquals(0,calculadora.determinanteEcuacionesY(ecuaciones));
    }

    @Test
    void resultadoX(){
        assertEquals((-2.3/((1.2*3.3)-(1.2*2.3))),calculadora.resultadoX(ecuaciones));
        ecuaciones[0][1] = 0;
        assertEquals(0,calculadora.resultadoX(ecuaciones));
    }

    @Test
    void resultadoY(){
        assertEquals((1.2/((1.2*3.3)-(1.2*2.3))),calculadora.resultadoY(ecuaciones));
        ecuaciones[0][2] = 1;
        assertEquals(0,calculadora.resultadoY(ecuaciones));

    }

    @Test
    void determinanteEcuacionesDistintoCero(){
        assertTrue(calculadora.determinanteEcuacionesDistintoCero(ecuaciones));
        ecuaciones[1][1] = 2.3;
        assertFalse(calculadora.determinanteEcuacionesDistintoCero(ecuaciones));
    }

    @Test
    void pendienteRecta() {
        assertEquals(0.6,calculadora.pendienteRecta(matrizPuntos));
    }

    @Test
    void rectaParalelaEjeY() {
        assertFalse(calculadora.rectaParalelaEjeY(matrizPuntos));
        assertTrue(calculadora.rectaParalelaEjeY(matrizPuntos2));
    }

    @Test
    void bRecta() {
        assertEquals(1,calculadora.bRecta(matrizPuntos));
    }

    @Test
    void resultadoEcuacionRecta() {
        assertEquals("La ecuación de la recta en forma Y = mX + b es: Y = 0.6X + (1.0).", calculadora.resultadoEcuacionRecta(0.6,1.0));
    }
}