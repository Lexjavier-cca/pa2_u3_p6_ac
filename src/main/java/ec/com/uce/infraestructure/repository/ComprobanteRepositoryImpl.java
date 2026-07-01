package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Comprobante;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ComprobanteRepositoryImpl implements PanacheRepositoryBase<Comprobante,Integer>{

}
