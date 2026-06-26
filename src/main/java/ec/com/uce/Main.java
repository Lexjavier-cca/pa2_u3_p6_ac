package ec.com.uce;

import java.time.LocalDate;


import ec.com.uce.application.service.MailService;
import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);    
    }
    public static class App implements QuarkusApplication{

        @Inject
        private MailService mailService;
        @Inject
        private ReporteService reporteService;
        @Override
        public int run(String... args) throws Exception {
       
            System.out.println("Prueba del nuevo proyecto");

            System.out.println("Guardando un mail: ");
            Mail mail = new Mail();
            mail.setDireccionOrigen("caiza@gmail.com");
            mail.setDireccionDestino("calispa@gmail.com");
            mail.setAsunto("Tarea 17");
            mail.setCuerpo("Realizar la tarea 17, replicando lo hecho en el taller 26");
            mail.setPrioridad("IMPORTANTE");
            this.mailService.guardar(mail);

            Mail mailPorId = this.mailService.buscarPorId(1);
            System.out.println("Mail con el id: " + mailPorId.getId() + " con el asunto: " + mailPorId.getAsunto());


            System.out.println("Guardando un reporte: ");
            Reporte reporte = new Reporte();
            reporte.setAutor("Alex Caiza");
            reporte.setTitulo("Tarea 17");
            reporte.setCuerpo("Realizada la tarea 17");
            reporte.setCantidadPalabras(3);
            reporte.setObservacion("Ninguna observacion");
            this.reporteService.guardar(reporte);

            Reporte reportePorId = this.reporteService.buscarPorId(1);
            System.out.println("Reporte con el id: " + reportePorId.getId() + " con el siguiente titulo: " + reportePorId.getTitulo());
            return 0;
        }
        
    }
    
}