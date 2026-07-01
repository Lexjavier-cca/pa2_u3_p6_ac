package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "sms")
public class Sms extends PanacheEntityBase{
    @Id
    @SequenceGenerator(name = "seq_msm_generador", sequenceName = "seq_msm", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_msm_generador")
    @Column(name = "sms_id")
    private Integer id;
    @Column(name = "sms_numeroOrigen")
    private String numeroOrigen;
    @Column(name = "sms_numeroDestino")
    private String numeroDestino;
    @Column(name = "sms_asunto")
    private String asunto;
    @Column(name = "sms_cuerpo")
    private String cuerpo;
    public Sms(){

    }
    public Sms(Integer id, String numeroOrigen, String numeroDestino, String asunto, String cuerpo) {
        this.id = id;
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumeroOrigen() {
        return numeroOrigen;
    }
    public void setNumeroOrigen(String numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }
    public String getNumeroDestino() {
        return numeroDestino;
    }
    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
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
    @Override
    public String toString() {
        return "Sms [id=" + id + ", numeroOrigen=" + numeroOrigen + ", numeroDestino=" + numeroDestino + ", asunto="
                + asunto + ", cuerpo=" + cuerpo + "]";
    }
    
    

}
