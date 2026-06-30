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
@Table(name = "reporte")
public class Reporte extends PanacheEntityBase{
    @Id
    @SequenceGenerator(name = "seq_reporte_generador", sequenceName = "seq_reporte", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reporte_generador")
    @Column(name = "rep_id")
    private Integer id;
    @Column(name = "rep_titulo")
    private String titulo;
    @Column(name = "rep_autor")
    private String autor;
    @Column(name = "rep_cantidadPalabras")
    private Integer cantidadPalabras;
    @Column(name = "rep_cuerpo")
    private String cuerpo;
    @Column(name = "rep_observacion")
    private String observacion;
    public Reporte() {
    }
    
    public Reporte(Integer id, String titulo, String autor, Integer cantidadPalabras, String cuerpo,
            String observacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPalabras = cantidadPalabras;
        this.cuerpo = cuerpo;
        this.observacion = observacion;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Integer getCantidadPalabras() {
        return cantidadPalabras;
    }
    public void setCantidadPalabras(Integer cantidadPalabras) {
        this.cantidadPalabras = cantidadPalabras;
    }
    public String getCuerpo() {
        return cuerpo;
    }
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "Reporte [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", cantidadPalabras="
                + cantidadPalabras + ", cuerpo=" + cuerpo + ", observacion=" + observacion + "]";
    }
    
    
 

    

}
