import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class calculadoraTest {

    double[][] matrizPuntos = new double[2][2];
    double[][] matrizPuntos2 = new double[2][2];

    @BeforeEach
    void setUp() {
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