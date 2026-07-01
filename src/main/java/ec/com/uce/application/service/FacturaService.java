package ec.com.uce.application.service;

import ec.com.uce.domain.model.Factura;
import ec.com.uce.infraestructure.repository.FacturaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class FacturaService {
 
    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;
    public void guardar(Factura factura){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en guardar factura " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        this.facturaRepositoryImpl.persist(factura);
    }
    public Factura buscarPorId(Integer id){
        return this.facturaRepositoryImpl.findById(id);
    }
    
}
 