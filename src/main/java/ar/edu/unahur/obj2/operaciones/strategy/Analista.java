package ar.edu.unahur.obj2.operaciones.strategy;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.operaciones.decorator.Alerta;

public class Analista {
    private final Integer legajo;
    private ICriterio criterio;
    private List<Alerta> alertasProcesadas = new ArrayList<>();
    
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

    public List<Alerta> getAlertasProcesadas() {
        return alertasProcesadas;
    }

    public void agregar(Alerta alerta){
        alertasProcesadas.add(alerta);
    }

    public Integer severidadTotalDeAlertas(){
        return alertasProcesadas.stream().mapToInt(a->a.getSeveridadBase()).sum();
    }
    

}
