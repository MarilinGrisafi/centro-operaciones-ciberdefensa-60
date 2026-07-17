package ar.edu.unahur.obj2.operaciones.template;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.operaciones.decorator.Alerta;
import ar.edu.unahur.obj2.operaciones.decorator.Alertable;
import ar.edu.unahur.obj2.operaciones.decorator.GeolocalizacionIP;
import ar.edu.unahur.obj2.operaciones.strategy.Analista;

public class MotorSIEM {

    private List<Alertable> alertasPendientes= new ArrayList<>();

    public void agregar(Alerta alerta){
        alertasPendientes.add(alerta);
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
            .filter(analista.getCriterio())
            .findFirst()
            .orElse(null);
    }

    public void registrarEnHistorial(Analista analista, Alertable alerta){
        analista.agregar(alerta);
    }


    /*
    
    Receta recetaAEntregar = recetasDisponibles.stream()
            .filter(r-> cliente.leGustaEstaReceta(r))
            .findFirst()
            .orElse(new Receta ("batido magico", "nutri", 2000, 0));
        //esto es necesario para que no de error en caso de que la lista esté vacía
        ingrediente.agregarAReceta(recetaAEntregar);////le agrega ingredientes extra
        cliente.recibeReceta(recetaAEntregar);
        
        */
    
}
