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
}