package ar.edu.unahur.obj2.operaciones.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeolocalizacionIPTest {

    GeolocalizacionIP geo;
    Alertable a1;

    @BeforeEach
    void setUp(){
        a1 = new Alerta("a1", 30);
        geo = new GeolocalizacionIP(a1);
    }
    @Test
    void dadaUnaAlertaSeDecoraConGeolocalizacionIPYAumentaSuSevBaseA40() {
        assertEquals(40, geo.getSeveridadBase());
    }
}
