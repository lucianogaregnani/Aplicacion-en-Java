package utilidades;

public class Print {

	public static void imprimirConAsteriscos(String frase) {
		/*
		  PROPÓSITO: Imprime la frase dada con astericos arriba y abajo.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debe imprimir la frase dada con astericos arriba y abajo.
		  PARÁMETROS:
		  	* frase - String: La frase a imprimir.
		*/
		System.out.println("***************");
		System.out.println(frase);
		System.out.println("***************");
	}
	
	public static void imprimirConGuiones(String frase) {
		/*
		  PROPÓSITO: Imprime la frase dada con astericos arriba y abajo.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debe imprimir la frase dada con astericos arriba y abajo.
		  PARÁMETROS:
		  	* frase - String: La frase a imprimir.
		*/
		System.out.println("---------------");
		System.out.println(frase);
		System.out.println("---------------");
	}
	
	public static void opcionesDeMenu() {
		/*
		  PROPÓSITO: Imprime las opciones del menu de la aplicación.
		  PRECONDICION:
		 	* Ninguna.
		  POSCONDICION:
		  	* Debe imprimir las opciones del menu de la aplicación.
		*/
		System.out.println("***************");
		System.out.println("Elija una opción.");
		System.out.println("1) Figura en la posicion: ");
		System.out.println("2) Remover figura en la posicion: ");
		System.out.println("3) Agregar figura:");
		System.out.println("4) Figuras guardadas.");
		System.out.println("5) Superficie maxima y minima.");
		System.out.println("6) Finalizar app.");
		System.out.println("***************");
	}
	
	public static void opcionesDeFiguras() {
		/*
		  PROPÓSITO: Imprime las opciones de las figuras disponibles.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debe imprimir las opciones de las figuras disponibles.
		*/
		System.out.println("---------------");
		System.out.println("Ingrese la figura que quiere guardar: ");
		System.out.println("'C' Si quiere un circulo.");
		System.out.println("'R' Si quiere un rectangulo.");
		System.out.println("'T' Si quiere un triangulo.");
		System.out.println("---------------");
	}
	
}
