package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pareja
{
    @Id
    @GeneratedValue
    private Long id;
    private Persona p1;
    private Persona p2;

    public Pareja()
    {

    }
    public Pareja(Persona p1, Persona p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public Persona getP1()
    {
        return p1;
    }
    public void setP1(Persona p1)
    {
        this.p1 = p1;
    }
    public Persona getP2()
    {
        return p2;
    }
    public void setP2(Persona p2)
    {
        this.p2 = p2;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pareja pareja = (Pareja) o;

        if (!p1.equals(pareja.p1)) return false;
        return p2.equals(pareja.p2);

    }
    @Override
    public int hashCode()
    {
        int result = p1.hashCode();
        result = 31 * result + p2.hashCode();
        return result;
    }


    @Override
    public String toString()
    {
        return "Pareja{" +
                "id=" + id +
                ", p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                '}';
    }
}
