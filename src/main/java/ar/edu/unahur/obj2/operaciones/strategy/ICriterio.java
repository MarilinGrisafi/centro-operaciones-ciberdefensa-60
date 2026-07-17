package ar.edu.unahur.obj2.operaciones.strategy;

import ar.edu.unahur.obj2.operaciones.decorator.Alertable;

public interface ICriterio {

    Boolean puedeProcesar(Alertable alerta);
}
