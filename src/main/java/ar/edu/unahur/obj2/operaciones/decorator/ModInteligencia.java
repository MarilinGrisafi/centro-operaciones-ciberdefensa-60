package ar.edu.unahur.obj2.operaciones.decorator;

public abstract class ModInteligencia implements Alertable{
    protected Alertable alerta;
    
    
    public ModInteligencia(Alertable alerta) {
        this.alerta = alerta;
    }

    @Override
    public String getId() {
       return alerta.getId();
    }

    @Override
    public Integer getSeveridadBase() {
        return alerta.getSeveridadBase();
    }

}
