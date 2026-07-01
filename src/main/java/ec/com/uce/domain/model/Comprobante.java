package ec.com.uce.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comprobante")
public class Comprobante extends PanacheEntityBase {
    @Id
    @Column(name = "comp_id")
    private Integer id;
    @Column(name = "comp_numeroComprobante")
    private String numeroComprobante;
    @Column(name = "comp_valor")
    private Double valor;
    @Column(name = "comp_concepto")
    private String concepto;
    @Column(name = "comp_fecha")
    private LocalDate fecha;
    public Comprobante(){

    }
    public Comprobante(Integer id, String numeroComprobante, Double valor, String concepto, LocalDate fecha) {
        this.id = id;
        this.numeroComprobante = numeroComprobante;
        this.valor = valor;
        this.concepto = concepto;
        this.fecha = fecha;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumeroComprobante() {
        return numeroComprobante;
    }
    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "Comprobante [id=" + id + ", numeroComprobante=" + numeroComprobante + ", valor=" + valor + ", concepto="
                + concepto + ", fecha=" + fecha + "]";
    }
    

}
