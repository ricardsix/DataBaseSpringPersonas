package com.example.service;

import com.example.domain.Amistad;
import com.example.domain.Pareja;
import com.example.domain.Persona;
import com.example.repository.AmistadRepository;
import com.example.repository.ParejaRepository;
import com.example.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SocialNetworkService
{
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ParejaRepository parejaRepository;
    @Autowired
    private AmistadRepository amistadRepository;

    public void añadirPersona(Persona persona)
    {
        personaRepository.save(persona);
    }
    public void añadirPareja (Persona p1, Persona p2)
    {
        Pareja pareja = new Pareja(p1,p2);
        parejaRepository.save(pareja);
    }
    public Amistad añadirAmistades(Persona persona1, Persona persona2)
    {
        return amistadRepository.save(new Amistad(persona1,persona2));
    }
    public Persona getPersona(Long id)
    {
        return personaRepository.findOne(id);
    }
    public Persona getPersona(String nombre)
    {
        return personaRepository.findByNombre(nombre);
    }
    public Persona getPareja(Persona persona)
    {
        Pareja pareja = parejaRepository.getPareja(persona);
        Persona resultado = null;
        if (pareja == null)
        {
            return resultado;
        }
        else
        {
            if(pareja.getP1().equals(persona))
            {
                resultado = pareja.getP2();
            }
            else if(pareja.getP2().equals(persona))
            {
                resultado = pareja.getP1();
            }
        }
        return resultado;
    }
    public List<Persona> getAmistad (Persona persona)
    {
        List<Amistad> amistades = amistadRepository.getAmistades(persona);
        List<Persona> resultado = new ArrayList<>();
        for(Amistad amistad:amistades)
        {
            if(amistad.getP1().equals(persona))
            {
                resultado.add(amistad.getP2());
            }
            else if(amistad.getP2().equals(persona))
            {
                resultado.add(amistad.getP1());
            }
        }
        return resultado;
    }
}
