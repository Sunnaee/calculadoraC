import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class calculadoraTest {

    double[][] ecuaciones = new double[2][3];

    @BeforeEach
    void setUp() {
        ecuaciones[0] = new double[]{1.2,2.3,0};
        ecuaciones[1] = new double[]{1.2,3.3,1};
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

}