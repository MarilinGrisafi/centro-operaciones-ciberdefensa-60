package ar.edu.unahur.obj2.operaciones.decorator;

public class GeolocalizacionIP extends ModInteligencia{
    
    
    public GeolocalizacionIP(Alerta alerta) {
        super(alerta);
    }

    @Override
    public Integer getSeveridadBase() {
        return alerta.getSeveridadBase() + 10;
    }
}
