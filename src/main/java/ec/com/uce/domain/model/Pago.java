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
@Table(name = "pago")
public class Pago extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "seq_pago_generador", sequenceName = "seq_pago", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pago_generador")
    @Column(name = "pag_id")
    private Integer id;
    @Column(name = "pag_identificador")
    private String identificador;
    @Column(name = "pag_detalle")
    private String detalle;
    @Column(name = "pag_valor")
    private Double valor;
    public Pago(){

    }

    public Pago(String detalle, Integer id, String identificador, Double valor) {
        this.detalle = detalle;
        this.id = id;
        this.identificador = identificador;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pago [id=" + id + ", identificador=" + identificador + ", detalle=" + detalle + ", valor=" + valor
                + "]";
    }
    



}
