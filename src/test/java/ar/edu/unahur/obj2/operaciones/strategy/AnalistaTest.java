package ar.edu.unahur.obj2.operaciones.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.operaciones.decorator.Alerta;
import ar.edu.unahur.obj2.operaciones.decorator.Alertable;
import ar.edu.unahur.obj2.operaciones.template.MotorSIEM;

public class AnalistaTest {

    Alertable a1 = new Alerta("a1", 30);

    MotorSIEM ms = new MotorSIEM();
    AnalistaN1 cr2= new AnalistaN1();
    EspecialistaCritico cr= new EspecialistaCritico();
    Analista an= new Analista(348888, cr);
    
    @Test
    void testAgregar() {
        an.agregar(a1);
        assertEquals(1, an.getAlertasProcesadas().size());
    }

    

    @Test
    void testGetCriterio() {
        assertEquals(cr, an.getCriterio());
    }

    @Test
    void testGetLegajo() {
        assertEquals(348888, an.getLegajo());
    }

    @Test
    void testSetCriterio() {
        an.setCriterio(cr2);
        assertEquals(cr2, an.getCriterio());
    }

    @Test
    void testSeveridadTotalDeAlertas() {
        an.agregar(a1);
        an.agregar(a1);
        assertEquals(60, an.severidadTotalDeAlertas());
    }
}
