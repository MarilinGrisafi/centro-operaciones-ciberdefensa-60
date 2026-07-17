package ar.edu.unahur.obj2.operaciones.decorator;

public class AnalisisSandbox extends ModInteligencia{

    public AnalisisSandbox(Alerta alerta) {
        super(alerta);
    }

    @Override
    public Integer getSeveridadBase() {
        return alerta.getSeveridadBase() + 30;
    }
}
