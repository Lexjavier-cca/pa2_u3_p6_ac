package ec.com.uce.application.service;

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
    @MedirTiempo
    public void guardar(Reporte reporte){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en main: " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        this.reporteRepositoryImpl.persist(reporte);
    }
    public Reporte buscarPorId(Integer id){
        return this.reporteRepositoryImpl.findById(id);
    }
    


}
