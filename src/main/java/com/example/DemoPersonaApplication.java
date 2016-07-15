package com.example;

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

		socialNetworkService.añadirPersona(ivan);
		socialNetworkService.añadirPersona(daniel);
		socialNetworkService.añadirPersona(novia);

		socialNetworkService.añadirPareja(ivan,novia);

		System.out.println("La pareja de Ivan es: ");
		System.out.println(socialNetworkService.getPareja(ivan));
	}
}
