package ar.edu.unahur.obj2.operaciones.template;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.operaciones.decorator.Alerta;
import ar.edu.unahur.obj2.operaciones.decorator.GeolocalizacionIP;
import ar.edu.unahur.obj2.operaciones.strategy.Analista;

public class MotorSIEM {

    private List<Alerta> alertasPendientes= new ArrayList<>();

    public void agregar(Alerta alerta){
        alertasPendientes.add(alerta);
    }

    public List<Alerta> getAlertasPendientes() {
        return alertasPendientes;
    }

    public void asignarAAnalista(Analista analista){
        
        this.buscarLaPRimeraAlerta(analista);
        
        this.agregarModuloGeolocalizacionIP();
        
        this.registrarEnHistorial(alerta);



        
    }

    public void agregarModuloGeolocalizacionIP(Analista analista){
        GeolocalizacionIP geo = new GeolocalizacionIP(alerta);
        geo = geo.getSeveridadBase();
        analista.agregar(geo);
        alertasPendientes.remove(geo);
    }

    public void buscarLaPRimeraAlerta(Analista analista){
        Alerta alerta = alertasPendientes.stream()
            .filter(analista.getCriterio())
            .findFirst()
            .orElse(null);
    }

    public void registrarEnHistorial(Alerta alerta){
        alertasPendientes.remove(alerta);
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
