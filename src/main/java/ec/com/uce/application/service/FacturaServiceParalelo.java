package ec.com.uce.application.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
public class FacturaServiceParalelo {
    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;
    @Inject 
    private ReporteService reporteService;
    @Inject
    private MailService mailService;
    @MedirTiempo
    public void guardar(Factura factura){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en factura en paralelo: " + nombreHilo);
        System.out.println("Id paralelo: " + Thread.currentThread().threadId());
        this.facturaRepositoryImpl.persist(factura);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Reporte reporte = new Reporte();
        reporte.setAutor("Alan Brito");
        reporte.setTitulo("Reporte de factura");
        reporte.setCuerpo("Entregando la factura ");
        reporte.setCantidadPalabras(3);
        reporte.setObservacion("Ninguna");

        ReporteServiceTarea reporteTarea = new ReporteServiceTarea(reporte, reporteService);
        executorService.submit(reporteTarea);
        
        Mail mail = new Mail();
        mail.setAsunto("Factura");
        mail.setCuerpo("Entregando una factura mediante correo");
        mail.setPrioridad("Urgente");
        mail.setDireccionOrigen("al@gmail.com");
        mail.setDireccionDestino("mateor@gmail.com");
        MailServiceTarea mailTarea = new MailServiceTarea(mail, mailService);
        executorService.submit(mailTarea);
        executorService.shutdown();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
