package ar.edu.unahur.obj2.operaciones.decorator;

public class AnalisisSandbox extends ModInteligencia{

    @Override
    public Integer getSeveridadBase() {
        return alerta.getSeveridadBase() + 30;
    }
}
