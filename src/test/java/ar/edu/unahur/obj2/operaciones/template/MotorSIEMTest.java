package ar.edu.unahur.obj2.operaciones.template;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.operaciones.decorator.Alerta;
import ar.edu.unahur.obj2.operaciones.decorator.Alertable;
import ar.edu.unahur.obj2.operaciones.strategy.Analista;
import ar.edu.unahur.obj2.operaciones.strategy.EspecialistaCritico;

public class MotorSIEMTest {

    Alertable a1;
    MotorSIEM ms;
    EspecialistaCritico cr;
    Analista an;
    
    @BeforeEach
    void setUp(){
        a1 = new Alerta("a1", 30);
        ms = new MotorSIEM();
        cr= new EspecialistaCritico();
        an= new Analista(348888, cr);

    }

    @Test
    void testAgregar() {
        ms.agregar(a1);
        assertEquals(1, ms.getAlertasPendientes().size());
    }

    /*@Test
    void testAgregarModuloGeolocalizacionIP() {
        ms.agregarModuloGeolocalizacionIP(a1);
    }*/

    @Test
    void testAsignarAAnalista() {
        ms.agregar(a1);
        ms.asignarAAnalista(an);
        assertEquals(1, an.getAlertasProcesadas().size());
    }

    @Test
    void testBuscarLaPRimeraAlerta() {


    }

    @Test
    void testGetAlertasPendientes() {

    }

    @Test
    void testRegistrarEnHistorial() {

    }
}
