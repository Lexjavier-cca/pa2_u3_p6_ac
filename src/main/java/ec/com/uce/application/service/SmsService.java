package ec.com.uce.application.service;

import ec.com.uce.application.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Sms;
import ec.com.uce.infraestructure.repository.SmsRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class SmsService {
    @Inject
    private SmsRepositoryImpl smsRepositoryImpl;
    @MedirTiempo
    public void guardadr(Sms sms){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en guardar sms " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        this.smsRepositoryImpl.persist(sms);
    }

}
