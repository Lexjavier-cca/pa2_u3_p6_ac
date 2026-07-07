package ec.com.uce.application.service.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
@Priority(0)
@Interceptor
@MedirTiempo
public class MedirTiempoInterceptor {
    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {

        long inicio = System.nanoTime();

        try {
            return context.proceed();
        } finally {
            long fin = System.nanoTime();
            double tiempoTotal;
            tiempoTotal = (fin - inicio) / 1_000_000.0;
            System.out.println("El tiempo que se tardo el metodo guardar es: " + tiempoTotal + " ms en : " + context.getMethod() );
            
        }
    }
}
