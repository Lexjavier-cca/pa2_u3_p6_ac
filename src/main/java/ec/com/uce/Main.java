package ec.com.uce;

import java.time.LocalDate;


import ec.com.uce.application.service.MailService;
import ec.com.uce.application.service.PagoService;
import ec.com.uce.application.service.PedidoService;
import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Pedido;
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
        private  PedidoService pedidoService;;
        @Override
        public int run(String... args) throws Exception {
            
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("Nombre del hilo en main: " + nombreHilo);
            System.out.println("Id: " + Thread.currentThread().threadId());
            System.out.println("Prueba del nuevo proyecto");
            System.out.println("Generando un pedido: ");
            Pedido pedido = new Pedido();
            pedido.setCantidad(20);
            pedido.setProducto("Jarabes");
            pedido.setValor(50.00);
            this.pedidoService.registrar(pedido);
            return 0;
        }
        
    }
    
}