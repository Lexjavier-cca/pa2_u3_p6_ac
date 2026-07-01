package ec.com.uce.application.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

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
            System.out.println("El tiempo que se tardo el metodo guardar es: " + tiempoTotal + " ms" );
            
        }
    }
}