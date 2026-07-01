package ec.com.uce.application.service;

import java.time.LocalDate;

import ec.com.uce.application.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Comprobante;
import ec.com.uce.domain.model.Pago;
import ec.com.uce.domain.model.Pedido;
import ec.com.uce.domain.model.Sms;
import ec.com.uce.infraestructure.repository.PedidoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PedidoService {
    @Inject
    private PedidoRepositoryImpl pedidoRepositoryImpl;
    @Inject
    private PagoService pagoService;
    @Inject 
    private SmsService smsService;
    @Inject 
    private ComprobanteService comprobanteService;
    public void enviar(Pedido pedido){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en enviar pedido " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        System.out.println("Enviando el pedido: " + pedido);
    }
    @MedirTiempo
    public void registrar(Pedido pedido){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo en registrar Pedido: " + nombreHilo);
        System.out.println("Id: " + Thread.currentThread().threadId());
        this.pedidoRepositoryImpl.persist(pedido);

        Pago pago = new Pago();
        pago.setIdentificador("pag-001");
        pago.setValor(pedido.getValor());
        pago.setDetalle("pago por pedido de: " + pedido.getProducto());
        this.pagoService.registrar(pago);

        Sms sms = new Sms();
        sms.setNumeroDestino("2202312");
        sms.setNumeroOrigen("2230969");
        sms.setAsunto("Pedido");
        sms.setCuerpo("Se ha generado su pedido con exito");
        this.smsService.guardadr(sms);

        Comprobante comprobante = new Comprobante();
        comprobante.setNumeroComprobante("comp-001");
        comprobante.setConcepto("Pago por pedido de: " + pedido.getProducto());
        comprobante.setFecha(LocalDate.of(2026, 6, 30));
        comprobante.setValor(pedido.getValor());



        
    }

    
}
