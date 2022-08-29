package aplicacion;

import java.util.*;

public class Menu {
	static Scanner lectura = new Scanner(System.in);
	static Figura figuras[];
	
	public Menu(int cantidadDeElementos) {
		figuras = new Figura[cantidadDeElementos];
	}
	
	public void main(String[] args) {
		/*
		  PROPÓSITO: Carga todo el atributo "figuras" de figuras, y luego da las opciones
		  			 a elegir.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* El atributo "figuras" debe ser llenado de figuras dadas por el usuario, y luego
		  	  deben ejecutarse las opciones correspondientes.
		*/
		cargarFiguras(figuras);
		opcionesElegir();
	}
	
	public static void cargarFiguras(Figura figuras[]) {
		/*
		  PROPÓSITO: Carga todas las figuras que ingrese el usuario en el array dado.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Todo el array dado debera llenarse con las figuras que ingrese el usuario.
		  PARÁMETROS:
		  	* figuras - Figura: El array a cargar.
		*/
		for(int i = 0; i < figuras.length; i++) {
			cargarFigura();
		}
		Print.imprimirConAsteriscos("Datos cargados.");
	}
	
	public static void cargarFigura() {
		/*
		  PROPÓSITO: Si hay valores vacios en el array carga la figura elegida, si no lo hay
		  			 redimensiona el array y luego la carga.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* El array debe set redimensionado si no hay espacios vacios.
		*/
		if (ArrayFigura.hayValoresVacios(figuras)) {
			cargarFiguraOpciones();
		}
		else {
			figuras = ArrayFigura.redimensionarArreglo(figuras);
			cargarFiguraOpciones();
		}
	}
	
	public static void cargarFiguraOpciones() {
		/*
		  PROPÓSITO: Imprime por pantalla las diferentes opciones de figuras que hay y luego
		   			 imprime que radio, altura o longitud elegiremos dependiendo de la figura.
		  PRECONDICION:
		  	* El usuario debe ingresar un String con la letra correspondiente.
		  	* El usurio debera ingresar datos de tipo double a la hora de instanciar la figura.
		  POSCONDICION:
		  	* La figura instanciada debera guardarse en el atributo "figuras" de la clase.
		*/
		int proximaPosVacia = ArrayFigura.posVacia(figuras);
		Print.opcionesDeFiguras();
		String letra = lectura.next().toUpperCase();
		switch(letra) {
			case "C": 
				Print.imprimirConAsteriscos("Ingreso un circulo, ingrese el radio.");
				figuras[proximaPosVacia] = new Circulo(lectura.nextDouble());
				break;
			case "R":
				Print.imprimirConAsteriscos("Ingreso un rectangulo, ingrese la altura y longitud.");
				figuras[proximaPosVacia] = new Rectangulo(lectura.nextDouble(), lectura.nextDouble());
				break;
			case "T":
				Print.imprimirConAsteriscos("Ingreso un triangulo, ingrese la altura y longitud.");
				figuras[proximaPosVacia] = new Triangulo(lectura.nextDouble(), lectura.nextDouble());
				break;
			default:
				Print.imprimirConAsteriscos("Igreso mal el dato.");
				break;
		}
	}
	
	public static void opcionesElegir() {
		/*
		  PROPÓSITO: Imprime por pantalla las opciones del menu, luego le da al usuario varias
		  			 opciones para elegir.
		  PRECONDICION:
		  	* Debe haber al menos una figura cargada para usar superficie maxima y minima.
		  	* El usuario debe ingresar números enteros.
		  POSCONDICION:
		  	* Deben ejecutarse los metodos correspondientes luego de ingresar un número entero,
		  	  al ingresar el número 6, el metodo debe dejar de ejecutarse. 
		*/
		int dato;
		Print.opcionesDeMenu();
		while((dato = lectura.nextInt()) != 6) {
			switch(dato) {
				case 1: 
					Print.imprimirConAsteriscos("Elija la posición.");
					figuraEnPos(lectura.nextInt(), figuras);
					Print.opcionesDeMenu();
					break;
				case 2:
					Print.imprimirConAsteriscos("Elija la posición.");
					removerEnPos(lectura.nextInt(), figuras);
					Print.opcionesDeMenu();
					break;
				case 3:
					cargarFigura();
					Print.opcionesDeMenu();
					break;
				case 4:
					ArrayFigura.figurasGuardadas(figuras);
					Print.opcionesDeMenu();
					break;
				case 5:
					Print.imprimirConAsteriscos("Superficie maxima." + "\n" + ArrayFigura.superficieMaxima(figuras).informacion());
					Print.imprimirConAsteriscos("Superficie minima." + "\n"  + ArrayFigura.superficieMinima(figuras).informacion());
					Print.opcionesDeMenu();
					break;
				default:
					Print.imprimirConAsteriscos("No existe esa opcion.");
			}
		}
		System.out.println("Ejecución finalizada.");
	}
	
	public static void removerEnPos(int pos, Figura[] figuras) {
		/*
		  PROPÓSITO: Remueve la figura en la posición dada del array dado si la
		  			 posición es correcta.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* La posición dada del array debe quedar en null, si la posición es la correcta.
		  PARÁMETROS:
		  	* pos - int: La posición del array a ver.
		  	* figuras - Figura: El array a ver.
		*/
		if(pos < 0 || pos > figuras.length - 1) {
			Print.imprimirConAsteriscos("No existe esa posicion.");
		}
		else {
			figuras[pos] = null;
			Print.imprimirConAsteriscos("Dato removido.");
		}
	}
	
	public static void figuraEnPos(int pos, Figura figuras[]) {
		/*
		  PROPÓSITO: Imprime la figura en la posicion dada del array dado si la posición
		  			 es correcta.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debe imprimir la información de la figura en la posicion dada, si la posición es 
		  	  incorrecta debera imprimir un mensaje de error.
		  PARÁMETROS:
		  	* pos - int: La posición del array a ver.
		  	* figuras - Figura: El array a ver.
		*/
		if((pos < 0 || pos > figuras.length - 1) || figuras[pos] == null) {
			Print.imprimirConAsteriscos("No hay ningun dato en esa posicion.");
		}
		else {
			Print.imprimirConAsteriscos(figuras[pos].informacion());
		}
	}
	

}
