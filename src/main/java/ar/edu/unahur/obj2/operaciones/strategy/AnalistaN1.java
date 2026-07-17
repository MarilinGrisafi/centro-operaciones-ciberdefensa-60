package ar.edu.unahur.obj2.operaciones.strategy;

import ar.edu.unahur.obj2.operaciones.decorator.Alertable;

public class AnalistaN1 implements ICriterio{

    @Override
    public Boolean puedeProcesar(Alertable alerta) {
        return Boolean.valueOf(alerta.getSeveridadBase()>75);
    }

}
