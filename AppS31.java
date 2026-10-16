package com.carballeira.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AppS31 {

	public static void main(String[] args) {
		try(FileInputStream entrada = new FileInputStream("datos.txt"); FileOutputStream salida = new FileOutputStream("copiaS31.txt")){
			byte[] buffer = new byte[10];
			int cantidad;
			while((cantidad = entrada.read(buffer)) != -1) {
				salida.write(buffer, 0, cantidad);
				System.out.println("Bytes leidos: " + cantidad);
			}
			System.out.println("Archivo copiado con  éxito!");
		}catch(IOException e) {
			System.out.println("error!: " + e.getMessage());
		}
		
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter("flush_s31.txt"))){
			escritor.write("Primera linea de BufferedWriter");
			escritor.newLine();
//			escritor.flush();
//			System.out.println("Se ejecutó flush");
			escritor.write("Segunda linea de BufferedWriter");
//			escritor.close();
//			System.out.println("Intentamos escribir");
//			escritor.write("Segunda linea de BufferedWriter");
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}

	}

}
