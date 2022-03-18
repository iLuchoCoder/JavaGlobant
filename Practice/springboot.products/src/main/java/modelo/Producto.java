package modelo;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 60, nullable = false)
    private Integer id;

    @Column(name="nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name="precio", length = 60, nullable = false)
    private float precio;

    public Producto() {
        super();
    }

    public Producto(String nombre, float precio) {
        super();
        this.nombre = nombre;
        this.precio = precio;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
