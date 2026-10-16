package com.carballeira.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;


public class AppS29 {
	public static void main (String [] Args) {
		try {
			FileWriter escritor = new FileWriter("texto_s29.txt", StandardCharsets.UTF_8);
			escritor.write("Primera línea del archivo.\n");
			escritor.write("Texto con tildes: á é í ó ú.\n");
			escritor.write("Otros caracteres: ñ ü €.");
			escritor.close();
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		try {
			FileReader lector = new FileReader("texto_s29.txt", StandardCharsets.UTF_8);
			int caracter;
			int contadorCaracteres = 0;
			int contadorVocales=0;
			while ((caracter = lector.read()) != -1) {
				char c = (char) caracter;
				if ("aeiouáéíóúüAEIOUÁÉÍÓÚÜ".indexOf(c) >= 0) {
					 contadorVocales++;
					}
				 System.out.print(c);
				 contadorCaracteres++;
				}

			lector.close();
			File fichero = new File("texto_s29.txt");
			System.out.println("Número de caracteres: " + contadorCaracteres);
			System.out.println("Número de vocales: " + contadorVocales);
			System.out.println("Tamaño del fichero: " + fichero.length() + " bytes");

		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
	}
}
