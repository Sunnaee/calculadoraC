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
    void determinante(){
        assertEquals(((1.2*3.3)-(1.2*2.3)),calculadora.determinante(ecuaciones));
        ecuaciones[0][0] = 0;
        assertEquals(-2.76,calculadora.determinante(ecuaciones));
    }

    @Test
    void determinanteX(){
        assertEquals(-2.3,calculadora.determinanteX(ecuaciones));
        ecuaciones[0][1] = 0;
        assertEquals(0,calculadora.determinanteX(ecuaciones));
    }

    @Test
    void determinanteY(){
        assertEquals(1.2,calculadora.determinanteY(ecuaciones));
        ecuaciones[0][2] = 1;
        assertEquals(0,calculadora.determinanteY(ecuaciones));
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
    void determinanteDistintoCero(){
        assertTrue(calculadora.determinanteDistintoCero(ecuaciones));
        ecuaciones[1][1] = 2.3;
        assertFalse(calculadora.determinanteDistintoCero(ecuaciones));
    }

}