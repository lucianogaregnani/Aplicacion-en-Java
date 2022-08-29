package aplicacion;

import java.util.Scanner;

public class Inicio {
	static Scanner lectura = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		  PROPÓSITO: Instancia la clase menu con el dato provisto por el usuario 
		  			 y luego ejecuta el metodo main de la misma.
		  PRECONDICION:
		  	- El usuario debe ingresar un número entero positivo.
		  POSCONDICION:
		  	- Debe ejecutarse el metodo main del objeto menu.
		*/
		System.out.println("Ingrese la cantidad de elementos:");
		Menu menu = new Menu(lectura.nextInt());
		menu.main(args);
	}
	
}
