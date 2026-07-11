package ec.com.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.com.uce.application.service.AuditoriaService;
import ec.com.uce.application.service.EstudianteService;
import ec.com.uce.application.service.FacturaServiceCompleteFuture;
import ec.com.uce.application.service.FacturaServiceParalelo;
import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Auditoria;
import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.domain.model.Factura;
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
        private ReporteService reporteService;




        @Override
        public int run(String... args) throws Exception {
            System.out.println("Iniciando las auditorias");
            List<Reporte> lista = new ArrayList<>();
            
            for(int i=0; i <= 100000; i++){
                Reporte r1 = new Reporte();
                r1.setAutor("Lucia11");
                r1.setCuerpo("Mensaje de Lucia11 N " + i);
                lista.add(r1);
            }

            this.reporteService.guardarListaReportes(lista);
            //this.reporteService.guardarListaReportesParalelo(lista);
            

            


            return 0;
        }
        
    }
    
}