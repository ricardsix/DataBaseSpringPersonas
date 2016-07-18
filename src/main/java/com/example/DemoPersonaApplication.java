package com.example;

import com.example.domain.Persona;
import com.example.service.SocialNetworkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoPersonaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(DemoPersonaApplication.class, args);
/*
		PersonaService personaService=context.getBean(PersonaService.class);

		personaService.testPersonas();
*/
		SocialNetworkService socialNetworkService =
				context.getBean(SocialNetworkService.class);

		Persona ivan = new Persona();
		ivan.setNombre("Ivan");
		ivan.setApellido ("Hernandez");
		ivan.setAge(23);

		Persona daniel = new Persona();
		daniel.setNombre("Daniel");
		daniel.setApellido ("");
		daniel.setAge(23);

		Persona novia = new Persona();
		novia.setNombre("novia");
		novia.setApellido ("");
		novia.setAge(23);

		Persona ismael = new Persona();
		ismael.setNombre("Ismael");
		ismael.setApellido("");
		ismael.setAge(20);

		Persona judith = new Persona();
		judith.setNombre("Judith");
		judith.setApellido("");
		judith.setAge(22);

		socialNetworkService.añadirPersona(ivan);
		socialNetworkService.añadirPersona(daniel);
		socialNetworkService.añadirPersona(novia);
		socialNetworkService.añadirPersona(ismael);
		socialNetworkService.añadirPersona(judith);

		socialNetworkService.añadirPareja(ivan,novia);

		socialNetworkService.añadirAmistades(ivan,daniel);
		socialNetworkService.añadirAmistades(ivan,ismael);
		socialNetworkService.añadirAmistades(ivan,judith);

		System.out.println("La pareja de Ivan es: ");
		System.out.println(socialNetworkService.getPareja(ivan));
		System.out.println("-----------------------------------------------------------------------------------------");

		System.out.println("Los amigos de Ivan son: ");
		System.out.println(socialNetworkService.getAmistad(ivan));
		System.out.println("-----------------------------------------------------------------------------------------");
	}
}
