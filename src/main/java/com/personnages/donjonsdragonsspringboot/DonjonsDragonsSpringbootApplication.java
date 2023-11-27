package com.personnages.donjonsdragonsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication est une simple encapsulation de trois annotations :
 * Configuration (remplace les traditionnels fichiers XML / config qui se font via des Beans)
 * EnableAutoConfiguration (Génère automatiquement les configurations nécessaires en fonction des dépendances situées dans notre classpath)
 * ComponentScan (Scanner les classes de ce package pour trouver les Beans de configuration)
 */

@SpringBootApplication
public class DonjonsDragonsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonjonsDragonsSpringbootApplication.class, args);
	}
}
