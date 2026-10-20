package com.carballeira.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppS33 {
	public static void main(String [] Args) throws Exception {
		BufferedReader lector = new BufferedReader(new FileReader("alumnos_notas.txt"));
		String[] linea = new String[2];
		lectura(lector, linea);
		contar(lector, linea);
	}
	private static void contar(BufferedReader lector, String[] linea) {
		System.out.println("RESUMEN DEL GRUPO");
		
		int[] contador= new int [3];
		linea[0]="a"; linea[1]="a";
		try{
			
			while((linea = lector.readLine().split(";")) != null) {
				linea[0]="a"; linea[1]="a";
				contador[0]++;
				
			}
			
			while((linea = lector.readLine().split(";"))!= null) {
				int numero = Integer.parseInt(linea[1]);
				if(numero>=5) {
					contador[1]++;
				}
				if(numero<5) {
					contador[2]++;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Total alumnos: " + contador[0]);
		System.out.println("Aprobados: " + contador[1]);
		System.out.println("Suspensos: " + contador[2]);
		
	}
	private static void lectura(BufferedReader lector, String[] linea2) throws Exception {
		System.out.println("LISTADO DE ALUMNOS");
		String[] linea = new String[2];
		try{
			while((linea = lector.readLine().split(";")) != null) {
				System.out.println(linea[0] + " - " + linea[1]);
			}
		}catch(NullPointerException e) {
			System.out.println("error!: " + e.getMessage());
		}
		linea[0]="a"; linea[1]="a";
	}
}
