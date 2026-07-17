package ar.edu.unahur.obj2.operaciones.decorator;

import ar.edu.unahur.obj2.operaciones.Alertable;
import ar.edu.unahur.obj2.operaciones.strategy.Alerta;

public abstract class ModInteligencia implements Alertable{
    protected Alerta alerta;
    

    @Override
    public String getId() {
       return alerta.getId();
    }

    @Override
    public Integer getSeveridadBase() {
        return alerta.getSeveridadBase();
    }

}
