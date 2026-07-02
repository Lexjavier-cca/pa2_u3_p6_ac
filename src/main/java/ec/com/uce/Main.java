package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.FacturaService;
import ec.com.uce.application.service.FacturaServiceParalelo;
import ec.com.uce.application.service.MailService;
import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Factura;
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
        private FacturaServiceParalelo facturaServiceParalelo;

        @Inject
        private FacturaService facturaService;

        @Override
        public int run(String... args) throws Exception {
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("Nombre del hilo en main: " + nombreHilo);
            System.out.println("Prueba del nuevo proyecto");
            System.out.println("Id: " + Thread.currentThread().threadId());

            System.out.println("Prueba del nuevo proyecto");
            //Factura factura = new Factura();
            //factura.setFecha(LocalDate.of(2026, 6, 24));
            //factura.setNumero("f-010");
            //factura.setRuc("1722619580-001");
            //this.facturaService.guardar(factura);

            Factura factura1 = new Factura();
            factura1.setFecha(LocalDate.of(2026, 6, 24));
            factura1.setNumero("f-011");
            factura1.setRuc("1722619580-001");
            this.facturaServiceParalelo.guardar(factura1);

            return 0;
        }
        
    }
    
}