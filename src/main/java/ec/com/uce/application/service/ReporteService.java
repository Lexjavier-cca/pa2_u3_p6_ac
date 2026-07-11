package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.application.service.interceptors.AuditorCreacion;
import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ReporteService {
    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;
    //@MedirTiempo
    public void guardar(Reporte reporte){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en guardar reporte: " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        /*try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        this.reporteRepositoryImpl.persist(reporte);
    }
    @AuditorCreacion
    public void guardarListaReportes(List<Reporte> lista){
        for(Reporte reporte : lista){
            this.guardar(reporte);
        }
    }
    @AuditorCreacion
    public void guardarListaReportesParalelo(List<Reporte> lista){
        lista.parallelStream().forEach(reporte -> {
            //Se programa la lógica que quiero que se aplique a cada item de la lista
            this.guardar(reporte);
        });
    }
    public Reporte buscarPorId(Integer id){
        return this.reporteRepositoryImpl.findById(id);
    }
    


}
