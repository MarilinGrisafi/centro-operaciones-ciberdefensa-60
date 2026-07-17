package ar.edu.unahur.obj2.operaciones.template;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.operaciones.decorator.Alertable;
import ar.edu.unahur.obj2.operaciones.decorator.GeolocalizacionIP;
import ar.edu.unahur.obj2.operaciones.strategy.Analista;

public class MotorSIEM {

    private List<Alertable> alertasPendientes= new ArrayList<>();

    public void agregar(Alertable a1){
        alertasPendientes.add(a1);
    }

    public List<Alertable> getAlertasPendientes() {
        return alertasPendientes;
    }

    public void asignarAAnalista(Analista analista){
        
        Alertable alerta = this.buscarLaPRimeraAlerta(analista);
        
        if (alerta == null){
            return ;
        }
        Alertable alertaEnriquecida = this.agregarModuloGeolocalizacionIP(alerta);
        
        this.registrarEnHistorial(analista, alertaEnriquecida);

        alertasPendientes.remove(alerta);

        
    }

    public Alertable agregarModuloGeolocalizacionIP(Alertable alerta){
        return new GeolocalizacionIP(alerta);
    }

    public Alertable buscarLaPRimeraAlerta(Analista analista){
        return alertasPendientes.stream()
            .filter(a->analista.getCriterio().puedeProcesar(a))
            .findFirst()
            .orElse(null);
    }

    public void registrarEnHistorial(Analista analista, Alertable alerta){
        analista.agregar(alerta);
    }

    
}
