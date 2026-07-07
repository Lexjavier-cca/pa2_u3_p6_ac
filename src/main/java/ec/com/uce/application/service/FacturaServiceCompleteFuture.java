package ec.com.uce.application.service;

import java.util.concurrent.CompletableFuture;

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
public class FacturaServiceCompleteFuture {
    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;
    @Inject
    private ReporteService reporteService;
    @Inject
    private MailService mailService;
    @MedirTiempo
    public void guardar(Factura factura){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo secuencial en factura: " + nombreHilo);
        System.out.println("Id secuencial: " + Thread.currentThread().threadId());
        this.facturaRepositoryImpl.persist(factura);
        Reporte reporte = new Reporte();
        reporte.setAutor("Alex Caiza");
        reporte.setTitulo("Reporte de factura");
        reporte.setCuerpo("Entregando la factura ");
        reporte.setCantidadPalabras(3);
        reporte.setObservacion("Ninguna");
        CompletableFuture<Void> completableReporte = CompletableFuture.runAsync(() -> this.reporteService.guardar(reporte));
        
        
        Mail mail = new Mail();
        mail.setAsunto("Factura");
        mail.setCuerpo("Entregando una factura mediante correo");
        mail.setPrioridad("Urgente");
        mail.setDireccionOrigen("alex@gmail.com");
        mail.setDireccionDestino("javier@gmail.com");
        CompletableFuture<Void> completableMail = CompletableFuture.runAsync(() -> this.mailService.guardar(mail));
        //espera hasta que las dos tareas\hilos se terminen
        CompletableFuture.allOf(completableReporte, completableMail).join();
    }

}
