package ec.com.uce.application.service;

import ec.com.uce.domain.model.Reporte;
import jakarta.inject.Inject;

public class ReporteServiceTarea implements Runnable{
    //@Inject
    private ReporteService reporteService;

    private Reporte reporte;

    public ReporteServiceTarea(Reporte reporte, ReporteService reporteService){
        this.reporte = reporte;
        this.reporteService = reporteService;
    }

    @Override
    public void run() {
        System.out.println("Ejecutando el run en paralelo de reporte: " +
            "Nombre del hilo: " + Thread.currentThread().getName()  +
            "Id del hilo: " + Thread.currentThread().threadId()
        );
        System.out.println(this.reporteService);
        this.reporteService.guardar(this.reporte);

       
    }

}
