package ec.com.uce.application.service.interceptors;

import java.time.LocalDateTime;
import java.util.Arrays;

import ec.com.uce.application.service.AuditoriaService;
import ec.com.uce.domain.model.Auditoria;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
@Priority(1)
@Interceptor
@AuditorCreacion
public class AuditarCreacionInterceptor{
    @Inject
    private AuditoriaService auditoriaService;
    @AroundInvoke
    public Object auditar(InvocationContext ctx) throws Exception{
        System.out.println("Iniciando la auditoria del metodo guardar");
        Long tiempoInicio = System.currentTimeMillis();
        LocalDateTime fechaEjecucion = LocalDateTime.now();
        String nombreMetodo = ctx.getMethod().getName();
        String argumentos = Arrays.toString(ctx.getParameters());
        
        
        try{
            Object result = ctx.proceed();
            return result;

        }finally{
            Long tiempoFinal = System.currentTimeMillis();
            Long tiempoTotal = (tiempoFinal - tiempoInicio);
            System.out.println("Tiempo total de ejecucion en ms: " + tiempoTotal);
            System.out.println("Finalizando la auditoria del metodo guardar");
            Auditoria auditoria = new Auditoria();
            auditoria.setTiempoEjecucionMs(tiempoTotal);
            auditoria.setFechaHoraEjecucion(fechaEjecucion);
            auditoria.setNombreMetodo(nombreMetodo);
            auditoria.setArgumento(argumentos);
            System.out.println(auditoria.toString());
            this.auditoriaService.guardar(auditoria);

        }   
    }

}
