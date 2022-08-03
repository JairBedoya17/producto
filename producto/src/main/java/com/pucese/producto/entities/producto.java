package com.pucese.entities;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "producto")
@NamedQueries({
        @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
})


public class producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name = "Id")
       private Long Id;

       @Column(name = "nombre", length = 50)
       private String nombre;

       @Column(name = "procantidadduct_stock")
       private int cantidad;

       @Column(name = "disponible")
       private boolean disponible;

       @Column(name = "precio")
       private double precio;

       public producto() {

       }

       public producto(String nombre, int cantidad, double precio) {
           this.nombre = nombre;
           this.cantidad = cantidad;
           this.precio = precio;
           this.disponible = true;
       }

     
       public Long getId() {
           return Id;
       }

       public void setId(Long id) {
           Id = id;
       }

       public String getNombre() {
           return nombre;
       }

       public void setNombre(String nombre) {
           this.nombre = nombre;
       }

       public int getCantidad() {
           return cantidad;
       }

       public void setCantidad(int cantidad) {
           this.cantidad = cantidad;
       }

       public boolean isDisponible() {
           return disponible;
       }

       public void setDisponible(boolean disponible) {
           this.disponible = disponible;
       }

       public double getPrecio() {
           return precio;
       }

       public void setPrecio(double precio) {
           this.precio = precio;
       }

       @Override
       public int hashCode() {
           int hash = 5;
           hash = 71 * hash + Objects.hashCode(this.Id);
           return hash;
       }

       @Override
       public boolean equals(Object obj) {
           if (this == obj) {
               return true;
           }
           if (obj == null) {
               return false;
           }
           if (getClass() != obj.getClass()) {
               return false;
           }
           final producto other = (producto) obj;
           return Objects.equals(this.Id, other.Id);
       }

       @Override
       public String toString() {
           return "Product{" + "productId=" + disponible + ", nombre=" + nombre + ", cantidad=" + cantidad + ", disponible=" + disponible + ", precio=" + precio + '}';
       }

   }

