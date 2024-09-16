import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class calculadoraTest {

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
    void determinante(){
        assertFalse(calculadora.determinante(numerosCuadratica1));
        assertTrue(calculadora.determinante(numerosDetNegativo));
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
}