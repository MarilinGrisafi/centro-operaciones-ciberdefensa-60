package ar.edu.unahur.obj2.operaciones.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalisisSandboxTest {
    Alertable a1;
    AnalisisSandbox sb;

    @BeforeEach
    void setUp(){
                a1 = new Alerta("a1", 30);
                sb = new AnalisisSandbox(a1);
    }
    @Test
    void dadaUnaAlertaSeDecoraConAnalisisSanboxYAumentaSuSevBaseA60() {
        assertEquals(60, sb.getSeveridadBase());
    }
}
