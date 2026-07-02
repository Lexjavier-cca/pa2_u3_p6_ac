package ec.com.uce.application.service;

import ec.com.uce.domain.model.Mail;
import jakarta.inject.Inject;

public class MailServiceTarea implements Runnable{
    //@Inject
    private MailService mailService;

    private Mail mail;

    public MailServiceTarea(Mail mail, MailService mailService){
        this.mail = mail;
        this.mailService = mailService;
    }

    @Override
    public void run() {
        System.out.println("Ejecutando el run en paralelo de reporte: " +
            "Nombre del hilo: " + Thread.currentThread().getName()  +
            "Id del hilo: " + Thread.currentThread().threadId()
        );
        System.out.println(this.mailService);
        this.mailService.guardar(this.mail);
    }

}
