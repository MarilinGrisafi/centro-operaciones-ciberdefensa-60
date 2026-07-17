package ar.edu.unahur.obj2.operaciones.strategy;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.operaciones.decorator.Alertable;

public class Analista {
    private final Integer legajo;
    private ICriterio criterio;
    private List<Alertable> alertasProcesadas = new ArrayList<>();
    
    public Analista(Integer legajo, ICriterio criterio) {
        this.legajo = legajo;
        this.criterio = criterio;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public ICriterio getCriterio() {
        return criterio;
    }

    public void setCriterio(ICriterio criterio) {
        this.criterio = criterio;
    }

    public List<Alertable> getAlertasProcesadas() {
        return alertasProcesadas;
    }

    public void agregar(Alertable alerta){
        alertasProcesadas.add(alerta);
    }

    public Integer severidadTotalDeAlertas(){
        return alertasProcesadas.stream().mapToInt(a->a.getSeveridadBase()).sum();
    }
    

}
