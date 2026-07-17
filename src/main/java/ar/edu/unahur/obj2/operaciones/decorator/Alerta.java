package ar.edu.unahur.obj2.operaciones.decorator;

import ar.edu.unahur.obj2.operaciones.excepciones.AlertaInvalidaException;

public class Alerta implements Alertable{

    private String id;
    private Integer severidadBase;

    

    public Alerta(String id, Integer severidadBase) {
        if (severidadBase<0)
            {throw new AlertaInvalidaException("No se puede crear una alerta con severidad negativa");
                
            }
        this.id = id;
        this.severidadBase = severidadBase;
    }

    @Override
    public String getId() {
       return id;
    }

    @Override
    public Integer getSeveridadBase() {
        return severidadBase;
    }

}
