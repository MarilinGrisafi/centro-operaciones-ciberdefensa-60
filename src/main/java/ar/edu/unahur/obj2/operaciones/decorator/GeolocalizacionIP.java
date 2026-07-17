package ar.edu.unahur.obj2.operaciones.decorator;

public class GeolocalizacionIP extends ModInteligencia{
    @Override
    public Integer getSeveridadBase() {
        return alerta.getSeveridadBase() + 10;
    }
}
