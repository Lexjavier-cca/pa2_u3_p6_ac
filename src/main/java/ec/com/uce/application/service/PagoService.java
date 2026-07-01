package ec.com.uce.application.service;

import ec.com.uce.application.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Pago;
import ec.com.uce.infraestructure.repository.PagoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional

public class PagoService {
    @Inject
    private PagoRepositoryImpl pagoRepositoryImpl;
    @MedirTiempo
    public void registrar(Pago pago){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en registrar pago " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        this.pagoRepositoryImpl.persist(pago);
        
    }
}
