package com.carballeira.jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AppS33 {
	public static void main(String [] Args) throws Exception {
		String[] linea = new String[2];
		String text = "";
		double[] contador= new double [5];
		lectura(linea, text);
		contar(linea, text, contador);
		
	}
	private static void contar(String[] linea, String text, double[] contador) throws Exception {
		contador[4]=0;
		System.out.println();
		System.out.println("RESUMEN DEL GRUPO");
		//TOTAL ALUMNOS
		try(BufferedReader lector = new BufferedReader(new FileReader("alumnos_notas.txt"))){
			while((text = lector.readLine()) != null) {
				contador[0]++;
			}
			lector.close();
		}
		catch(Exception e){
			System.out.println("error!: " + e.getMessage());
		}
		
		//Aprobados
		try(BufferedReader lector = new BufferedReader(new FileReader("alumnos_notas.txt"))){
			while((text = lector.readLine()) != null) {
				linea = text.split(";");
				double nota = Double.parseDouble(linea[1]);
				if(nota>=5) {
					contador[1]++;
				}
			}
			lector.close();
		}
		catch(Exception e){
			System.out.println("error!: " + e.getMessage());
		}
		
		//Suspensos
		try(BufferedReader lector = new BufferedReader(new FileReader("alumnos_notas.txt"))){
			while((text = lector.readLine()) != null) {
				linea = text.split(";");
				double nota = Double.parseDouble(linea[1]);
				if(nota<5) {
					contador[2]++;
				}
			}
			lector.close();
		}
		catch(Exception e){
			System.out.println("error!: " + e.getMessage());
		}
		
		//Media
		try(BufferedReader lector = new BufferedReader(new FileReader("alumnos_notas.txt"))){
			while((text = lector.readLine()) != null) {
				contador[4]++;
				linea = text.split(";");
				double nota = Double.parseDouble(linea[1]);
				contador[3]+=nota;
			}
			lector.close();
		}
		catch(Exception e){
			System.out.println("error!: " + e.getMessage());
		}
		
		double media = (contador[3]/contador[4]);
		
		System.out.println("Total alumnos: " + contador[0]);
		System.out.println("Aprobados: " + contador[1]);
		System.out.println("Suspensos: " + contador[2]);
		System.out.println("Media: " + media);
		
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter("resumen.txt"))){
			escritor.write("RESUMEN DEL GRUPO");
			escritor.newLine();
			
			escritor.write("Total alumnos: " + contador[0]);
			escritor.newLine();
			
			escritor.write("Aprobados: " + contador[1]);
			escritor.newLine();
			
			escritor.write("Suspensos: " + contador[2]);
			escritor.newLine();
			
			escritor.write("Media: " + media);

			System.out.println("Se guardó un resumen");
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
	}
	private static void lectura(String[] linea, String text) throws Exception {
		BufferedReader lector = new BufferedReader(new FileReader("alumnos_notas.txt"));
		System.out.println("LISTADO DE ALUMNOS");
		
		try{
			while((text = lector.readLine()) != null) {
				linea = text.split(";");
				System.out.println(linea[0] + " - " + linea[1]);
			}
		}catch(Exception e){
			System.out.println("error!: " + e.getMessage());
		}
		lector.close();
	}
}
