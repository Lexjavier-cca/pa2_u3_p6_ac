package ec.com.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "mail")
public class Mail {
    @Id
    @SequenceGenerator(name = "seq_mail_generador", sequenceName = "seq_mail", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mail_generador")
    @Column(name = "mail_id")
    private Integer id;
    @Column(name = "mail_direccionOrigen")
    private String direccionOrigen;
    @Column(name = "mail_direccionDestino")
    private String direccionDestino;
    @Column(name = "mail_asunto")
    private String asunto;
    @Column(name = "mail_cuerpo")
    private String cuerpo;
    @Column(name = "mail_prioridad")
    private String prioridad;
    public Mail() {
    }
    
    

    public Mail(Integer id, String direccionOrigen, String direccionDestino, String asunto, String cuerpo,
            String prioridad) {
        this.id = id;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.prioridad = prioridad;
    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDireccionOrigen() {
        return direccionOrigen;
    }
    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }
    public String getDireccionDestino() {
        return direccionDestino;
    }
    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getCuerpo() {
        return cuerpo;
    }
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }



    @Override
    public String toString() {
        return "Mail [id=" + id + ", direccionOrigen=" + direccionOrigen + ", direccionDestino=" + direccionDestino
                + ", asunto=" + asunto + ", cuerpo=" + cuerpo + ", prioridad=" + prioridad + "]";
    }
    


    
    

}
