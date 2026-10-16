package com.carballeira.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AppS30 {

	public static void main(String[] args) {
		try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"))){
			String linea;
			while((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter("resultados.txt"))){
			escritor.write("Primera linea de BufferedWriter");
			escritor.newLine();
			
			escritor.write("Segunda linea de BufferedWriter");
			escritor.newLine();
			
			escritor.write("Tercera linea de BufferedWriter");
			escritor.newLine();
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		
		try(FileWriter escritorFile = new FileWriter("resultadosSinBuffered.txt", true)){
			escritorFile.write("Primera linea sin BufferedWriter\n");
			escritorFile.write("Segunda linea sin BufferedWriter\n");
			escritorFile.write("Tercera linea sin BufferedWriter");
			escritorFile.write("\nCuarta linea añadida");
			escritorFile.write("\nQuinta linea añadida");
			
			System.out.println("Cuarta linea añadida");
			System.out.println("Quinta linea añadida");
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
	}

}
