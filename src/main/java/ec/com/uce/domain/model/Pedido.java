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
@Table(name = "pedido")
public class Pedido extends PanacheEntityBase{
    @Id
    @SequenceGenerator(name = "seq_pedido_generador", sequenceName = "seq_pedido", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido_generador")
    @Column(name = "ped_id")
    private Integer id;
    @Column(name = "ped_producto")
    private String producto;
    @Column(name = "ped_cantidad")
    private Integer cantidad;
    @Column(name = "ped_valor")
    private Double valor;
    public Pedido() {
    }
    public Pedido(Integer cantidad, Integer id, String producto, Double valor) {
        this.cantidad = cantidad;
        this.id = id;
        this.producto = producto;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Pedido [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", valor=" + valor + "]";
    }
    
    

}
