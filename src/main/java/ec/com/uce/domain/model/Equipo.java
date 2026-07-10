package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "seq_equipo_generador", sequenceName = "seq_equipo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipo_generador")
    @Column(name = "equi_id")
    private Integer id;
    @Column(name = "equi_nombre")
    private String nombre;
    @Column(name = "equi_pais")
    private String pais;
    @Column(name = "equi_titulos")
    private Integer titulos;
    @Column(name = "equi_confederacion")
    private String confederacion;
    public Equipo(){

    }
    
    public Equipo(Integer id, String nombre, String pais, Integer titulos, String confederacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.titulos = titulos;
        this.confederacion = confederacion;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public Integer getTitulos() {
        return titulos;
    }
    public void setTitulos(Integer titulos) {
        this.titulos = titulos;
    }
    public String getConfederacion() {
        return confederacion;
    }
    public void setConfederacion(String confederacion) {
        this.confederacion = confederacion;
    }
    @Override
    public String toString() {
        return "Equipo [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", titulos=" + titulos
                + ", confederacion=" + confederacion + "]";
    }
        


}
