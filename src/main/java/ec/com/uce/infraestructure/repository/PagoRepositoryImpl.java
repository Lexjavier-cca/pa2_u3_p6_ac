package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Pago;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PagoRepositoryImpl implements PanacheRepositoryBase<Pago, Integer> {

}
