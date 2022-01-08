package org.factoriaf5.libritos.repositories;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre ;
    private int edad;
    private String apellidos;
    private String pais;
    private String localidad;
    private String estudios;
    private String promo;


    private String image;

    public Book() {

    }

    public Book(String nombre,int edad, String apellidos, String pais,String localidad,String estudios,String promo, String image) {
        this.nombre= nombre;
        this.edad = edad;
        this.apellidos = apellidos;
        this.pais = pais;
        this.localidad = localidad;
        this.estudios = estudios;
        this.promo = promo;
        this.image = image;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {return edad;}

    public void setEdad(int edad) {this.edad = edad;}

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalidad() {return localidad;}

    public void setLocalidad(String localidad) {this.localidad = localidad;}

    public String getEstudios() {return estudios;}

    public void setEstudios(String estudios) {this.estudios = estudios;}

    public String getPromo() {return promo;}

    public void setPromo(String promo) {this.promo = promo;}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(nombre, book.nombre)&& Objects.equals(edad, book.edad) && Objects.equals(apellidos, book.apellidos)  && Objects.equals(pais, book.pais)&& Objects.equals(localidad, book.localidad)&& Objects.equals(estudios, book.estudios)&& Objects.equals(promo, book.promo) && Objects.equals(image, book.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre,edad, apellidos,pais,localidad,estudios,promo, image);
    }
}