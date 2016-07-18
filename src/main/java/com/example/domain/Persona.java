package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer age;

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

    public void setAge(Integer age){this.age = age;}

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (id != null ? !id.equals(persona.id) : persona.id != null) return false;
        if (!nombre.equals(persona.nombre)) return false;
        if (!apellido.equals(persona.apellido)) return false;
        return age.equals(persona.age);
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + nombre.hashCode();
        result = 31 * result + apellido.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre +
                ", apellido='" + apellido +
                ", age='" + age + '\'' +
                '}';
    }


}
