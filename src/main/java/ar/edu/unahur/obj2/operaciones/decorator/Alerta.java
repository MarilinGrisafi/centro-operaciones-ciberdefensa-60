package ar.edu.unahur.obj2.operaciones.decorator;

public class Alerta implements Alertable{

    private String id;
    private Integer severidadBase;

    @Override
    public String getId() {
       return id;
    }

    @Override
    public Integer getSeveridadBase() {
        return severidadBase;
    }

}
