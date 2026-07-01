package ec.com.uce.application.service;

import ec.com.uce.application.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Comprobante;
import ec.com.uce.infraestructure.repository.ComprobanteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ComprobanteService {
    @Inject
    private ComprobanteRepositoryImpl comprobanteRepositoryImpl;
    @MedirTiempo
    public void registrar(Comprobante comprobante){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en registrar pago " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        this.comprobanteRepositoryImpl.persist(comprobante);
    }

}
