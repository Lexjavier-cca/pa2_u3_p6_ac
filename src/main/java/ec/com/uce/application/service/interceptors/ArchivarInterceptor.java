package ec.com.uce.application.service.interceptors;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
@Priority(0)
@Interceptor
@Archivar
public class ArchivarInterceptor {
    @AroundInvoke
    public Object archivar(InvocationContext ctx) throws Exception{
        Object resultado = null;
        try (FileWriter writer = new FileWriter("reporte.txt")) {
            
            writer.write("Nombre del metodo: " + ctx.getMethod().getName() + "\n");
            System.out.println();
            writer.write("Fecha de Ejecucion: " + LocalDate.now().toString() + "\n");
            writer.write("Archivo creado desde Java" + "\n");
            resultado = ctx.proceed();
            System.out.println("Archivo creado y escrito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return resultado;

    }

}
