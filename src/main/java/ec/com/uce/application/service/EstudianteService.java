package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.AuditorActualizacion;
import ec.com.uce.application.service.interceptors.AuditorCreacion;
import ec.com.uce.application.service.interceptors.AuditorEliminacion;
import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.infraestructure.repository.EstudianteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteService {
    @Inject
    private EstudianteRepositoryImpl estudianteRepositoryImpl;
    @AuditorCreacion
    public void guardar(Estudiante estudiante){
        this.estudianteRepositoryImpl.persist(estudiante);
        
    }
    @AuditorActualizacion
    public void actualizar(Estudiante estudiante){
        this.estudianteRepositoryImpl.getEntityManager().merge(estudiante);
    }
    @AuditorEliminacion
    public void eliminar(Estudiante estudiante){
        this.estudianteRepositoryImpl.getEntityManager().remove(estudiante);
    }

}
