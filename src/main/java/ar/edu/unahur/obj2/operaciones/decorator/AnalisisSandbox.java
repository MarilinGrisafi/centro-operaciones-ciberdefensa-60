package ar.edu.unahur.obj2.operaciones.decorator;

public class AnalisisSandbox extends ModInteligencia{


    public AnalisisSandbox(Alertable alerta) {
        super(alerta);
    }

    @Override
    public Integer getSeveridadBase() {
        return alerta.getSeveridadBase() + 30;
    }
}
