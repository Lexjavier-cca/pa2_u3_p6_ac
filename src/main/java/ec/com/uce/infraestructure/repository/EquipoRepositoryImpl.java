package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Equipo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class EquipoRepositoryImpl implements PanacheRepositoryBase<Equipo, Integer>{
    
}
