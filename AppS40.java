package com.carballeira.jdbc;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AppS40 {
	static ArrayList<Alumno3> ListaAlumnos = new ArrayList<Alumno3>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws DniAlreadyExistsException, DniNotExistsException {
		loadData();
		boolean exit=false;
		exit = menu(sc, exit);
		while (exit == false) {
			exit = menu(sc, exit);
		}
	}
	private static void loadData() {
		try (FileInputStream fis = new FileInputStream("listaAlumnos.dat");
				 ObjectInputStream ois = new ObjectInputStream(fis)){
			ListaAlumnos=(ArrayList<Alumno3>) ois.readObject();
			
			System.out.println("Información encontrada y cargada");
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		
	}
	private static boolean menu(Scanner sc, boolean exit) throws DniAlreadyExistsException, DniNotExistsException {
		System.out.printf(""
				+ "===== GESTIÓN DE ALUMNOS =====\r\n"
				+ "\r\n"
				+ "1. Añadir alumno\r\n"
				+ "2. Mostrar alumnos\r\n"
				+ "3. Guardar alumnos en fichero\r\n"
				+ "4. Cargar alumnos desde fichero\r\n"
				+ "5. Exportar alumnos a TXT\r\n"
				+ "6. Modificar nota\r\n"
				+ "0. Salir\r\n"
				+ "\r\n"
				+ "Elige una opción: "
				+ "");
		int option=sc.nextInt();
		switch(option) {
		case 1:
			add(sc, ListaAlumnos);
			break;
		case 2:
			list(sc, ListaAlumnos);
			break;
		case 3:
			saveToFile(sc, ListaAlumnos);
			break;
		case 4:
			loadFromFile(sc, ListaAlumnos);
			break;
		case 5:
			export(sc, ListaAlumnos);
			break;
		case 6:
			modify(sc, ListaAlumnos);
			break;
		case 0:
			System.out.println("Saliendo...");
			exit = true;
			break;
		default:
			System.out.println("error!: Opción no valida");
			break;
		}
		return exit;
	}
	private static void modify(Scanner sc2, ArrayList<Alumno3> listaAlumnos2) throws DniNotExistsException{
		try{
			String dni, nombre, apellidos, nota;
			System.out.print("Cuantos alumnos quieres modificar?: ");
			int alumnos=sc.nextInt();
			sc.nextLine();

			System.out.println();
			for(int i=0; i<alumnos; i++) {
				System.out.println("=== ALUMNO " + (i+1) + " ===" );
				System.out.print("Introduce DNI: ");
				dni=sc.nextLine();
				for(Alumno3 buscar:ListaAlumnos) {
					if(buscar.getDni().equals(dni)) {
						System.out.print("Introduce Nota: ");
						nota=sc.nextLine();
						buscar.setNota(Integer.parseInt(nota));
						break;
					}else {
						throw new DniNotExistsException("DNI no existe!!!");
					}
				}
			}
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
	}
	private static void export(Scanner sc, ArrayList<Alumno3> listaAlumnos2) {
		try(BufferedWriter escritor = new BufferedWriter(new FileWriter("ListaAlumnosEXPORT.txt"))){
			escritor.write("=== LISTA ALUMNOS ===");
			escritor.newLine();
			escritor.write("-------------------------------------------------------------------------------------------------------");
			escritor.newLine();
			for(Alumno3 alumno:ListaAlumnos) {
				escritor.write(alumno.getDni()+" "+alumno.getNombre()+" "+alumno.getApellidos()+" "+alumno.getNota());
				escritor.newLine();
			}
			escritor.newLine();
			escritor.write("-------------------------------------------------------------------------------------------------------");
			System.out.println("Se guardó un resumen");
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		
	}
	private static void loadFromFile(Scanner sc, ArrayList<Alumno3> listaAlumnos2) {
		try (FileInputStream fis = new FileInputStream("listaAlumnos.dat");
				 ObjectInputStream ois = new ObjectInputStream(fis)){
			ListaAlumnos=(ArrayList<Alumno3>) ois.readObject();
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		
	}
	private static void saveToFile(Scanner sc, ArrayList<Alumno3> listaAlumnos2) {
		try(
				FileOutputStream fos = new FileOutputStream("listaAlumnos.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
			oos.writeObject(ListaAlumnos);
			System.out.println("Guardado con éxito!");
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		
	}
	private static void list(Scanner sc, ArrayList<Alumno3> listaAlumnos2) {
		try{
			int aprobado=0, suspenso=0;
			System.out.println();
			System.out.println("=== LISTA ALUMNOS ===");
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.printf("%-10s %-10s %-20s %-6s", "DNI","NOMBRE", "APELLIDOS", "NOTA");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.println(ListaAlumnos);
			System.out.println("-------------------------------------------------------------------------------------------------------");
			for(Alumno3 alumno:ListaAlumnos) {
				if(alumno.getNota()>=5) {
					aprobado++;
				}else {
					suspenso++;
				}
			}
			System.out.println("Aprobados: " + aprobado);
			System.out.println("Suspensos: " + suspenso);
			
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		System.out.println();
	}
	private static void add(Scanner sc, ArrayList<Alumno3> listaAlumnos2) throws DniAlreadyExistsException {
		try{
			String dni, nombre, apellidos, nota;
			System.out.print("Cuantos alumnos quieres añadir?: ");
			int alumnos=sc.nextInt();
			sc.nextLine();

			System.out.println();
			for(int i=0; i<alumnos; i++) {
				System.out.println("=== ALUMNO " + (i+1) + " ===" );
				System.out.print("Introduce DNI: ");
				dni=sc.nextLine();
				Alumno3 busqueda = new Alumno3(dni, null, null, 0);
				if(ListaAlumnos.contains(busqueda)) {
					throw new DniAlreadyExistsException("Ya existe este DNI!!!");
				}
				System.out.print("Introduce Nombre: ");
				nombre=sc.nextLine();
				System.out.print("Introduce Apellidos: ");
				apellidos=sc.nextLine();
				System.out.print("Introduce Nota: ");
				nota=sc.nextLine();
				
				ListaAlumnos.add(new Alumno3(dni, nombre, apellidos, Integer.parseInt(nota)));
			}
			System.out.println("Alumno registrado con éxito!");
		}catch(Exception e) {
			System.out.println("error!: " + e.getMessage());
		}
		
	}

}
