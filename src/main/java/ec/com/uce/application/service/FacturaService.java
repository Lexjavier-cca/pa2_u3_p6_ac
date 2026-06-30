package ec.com.uce.application.service;

import org.hibernate.annotations.ListIndexJdbcTypeCode;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infraestructure.repository.FacturaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class FacturaService {
 
    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;
    @Inject
    private ReporteService reporteService;
    @Inject
    private MailService mailService;
    @MedirTiempo
    public void guardar(Factura factura){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en factura: " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        this.facturaRepositoryImpl.persist(factura);
        Reporte reporte = new Reporte();
        reporte.setAutor("Alex Caiza");
        reporte.setTitulo("Reporte de factura");
        reporte.setCuerpo("Entregando la factura ");
        reporte.setCantidadPalabras(3);
        reporte.setObservacion("Ninguna");
        this.reporteService.guardar(reporte);
        
        Mail mail = new Mail();
        mail.setAsunto("Factura");
        mail.setCuerpo("Entregando una factura mediante correo");
        mail.setPrioridad("Urgente");
        mail.setDireccionOrigen("alex@gmail.com");
        mail.setDireccionDestino("javier@gmail.com");
        this.mailService.guardar(mail);
    }
    public Factura buscarPorId(Integer id){
        return this.facturaRepositoryImpl.findById(id);
    }
}
 