package com.ferreteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Oracle.Conexion;

@SpringBootApplication
public class FerreteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FerreteriaApplication.class, args);
                
                Conexion conexion = new Conexion();
	}

}
