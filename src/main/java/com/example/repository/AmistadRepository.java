package com.example.repository;

import com.example.domain.Amistad;
import com.example.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AmistadRepository extends JpaRepository<Amistad,Long>
{
    @Query("SELECT amistad FROM Amistad amistad WHERE amistad.p1 = :persona OR amistad.p2 = :persona")
    List<Amistad> getAmistades(@Param("persona")Persona persona);
}
