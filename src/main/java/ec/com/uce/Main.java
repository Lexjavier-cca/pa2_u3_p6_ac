package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.AuditoriaService;
import ec.com.uce.application.service.EstudianteService;
import ec.com.uce.application.service.FacturaServiceCompleteFuture;
import ec.com.uce.application.service.FacturaServiceParalelo;
import ec.com.uce.domain.model.Auditoria;
import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.domain.model.Factura;

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
        private EstudianteService estudianteService;
        @Inject
        private AuditoriaService auditoriaService;




        @Override
        public int run(String... args) throws Exception {
            System.out.println("Iniciando las auditorias");
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Alex Caiza");
            estudiante.setSemestre(6);
            this.estudianteService.guardar(estudiante);

            estudiante.setSemestre(7);
            this.estudianteService.actualizar(estudiante);

            this.estudianteService.eliminar(estudiante);

            


            return 0;
        }
        
    }
    
}