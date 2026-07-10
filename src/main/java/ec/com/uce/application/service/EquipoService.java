package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.application.service.interceptors.AuditorCreacion;
import ec.com.uce.domain.model.Equipo;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infraestructure.repository.EquipoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EquipoService {
    @Inject
    private EquipoRepositoryImpl equipoRepositoryImpl;
    public void guardar(Equipo equipo){
        this.equipoRepositoryImpl.persist(equipo);
    }
    @AuditorCreacion
    public void guardarLista(List<Equipo> equipos){
        for(Equipo equipo : equipos){
            this.guardar(equipo);
        }
    }
}
