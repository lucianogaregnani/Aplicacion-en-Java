package utilidades;

import java.util.Arrays;

import figuras.Figura;

public class ArrayFigura {
	
	public static Figura[] redimensionarArreglo(Figura[]figuras) {
		/*
		  PROPÓSITO: Devuelve el arreglo pasado por parámetros con una posición más.
		  PRECONDICION:
		  	* Ninguna.
		  PARAMETROS:
		  	* figuras - Figura: El array a redimensionar.
		  POSCONDICION:
		  	* el array dado debe tener una posición más.
		*/
		Figura arreglo[] = new Figura[figuras.length + 1];
		System.arraycopy(figuras, 0, arreglo, 0, figuras.length);
		return arreglo;
	}
	
	public static boolean hayValoresVacios(Figura[] figuras) {
		/*
		  PROPÓSITO: Indica si hay valores vacios en el array dado.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debe devolver si hay una posición vacio o no.
		  PARÁMETROS:
		  	* figuras - Figura: El array a ver si hay valores vacios.
		*/
		return Arrays.asList(figuras).contains(null);
	}
	
	public static int posVacia(Figura[] figuras) {
		/*
		  PROPÓSITO: Describe la posición vacia más proxima del array dado.
		  PRECONDICION:
		  	* Debe haber al menos una posición vacia en el array.
		  POSCONDICION:
		 	* Debe devolver la posición vacia más proxima del array.
		  PARÁMETROS:
		  	* figuras - Figura: El array a devolver su posicion vacia.
		*/
		return Arrays.asList(figuras).indexOf(null);
	}	
	
	public static Figura superficieMinima(Figura[] figuras) {
		/*
		  PROPÓSITO: Describe la figura que tenga la supercie minima del array dado.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debe devolver la figura con la superficie minima del array dado.
		  PARÁMETROS:
		  	* figuras - Figura: El array a devolver su superficie minima.
		*/
		Figura minimo = figuras[proximaPosLlena(figuras)]; 
		for (int i=0; i < figuras.length; i++) {
			if ((figuras[i] != null) && minimo.superficie() > figuras[i].superficie()) {
				minimo = figuras[i];
			}
		}
		return minimo;
	}
	
	public static Figura superficieMaxima(Figura[] figuras) {
		/*
		  PROPÓSITO: Describe la figura que tenga la supercie maxima del array dado.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debe devolver la figura con la superficie maxima del array dado.
		  PARÁMETROS:
		  	* figuras - Figura: El array a devolver su superficie maxima.
		*/
		Figura maximo = figuras[proximaPosLlena(figuras)]; 
		for (int i=0; i < figuras.length; i++) {
			if ((figuras[i] != null) && maximo.superficie() < figuras[i].superficie()) {
				maximo = figuras[i];
			}
		}
		return maximo;
	}
	
	public static int proximaPosLlena(Figura[] figuras) {
		/*
		  PROPÓSITO: Describe la posicion más próxima que tenga alguna figura en el
		  			 array dado.
		  PRECONDICION:
		  	* Debe haber al menos una figura en el array dado.
		  POSCONDICION:
		  	* Debe devolver la posicion más proxima que tenga alguna figura en el array dado.
		  PARÁMETROS:
		  	* figuras - Figura: El array a devolver su superficie maxima.
		*/
		int pos = 0;
		for (int i=0; i < figuras.length; i++)  {
			if (figuras[i] != null) {
				pos = i;
				break;
			}
		}
		return pos;
	}
	
	public static void figurasGuardadas(Figura[] figuras) {
		/*
		  PROPÓSITO: Imprime todas la información de todas figuras del array dado.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debe imprimir la posición de todas las figuras del array dado.
		  PARÁMETROS:
		  	* figuras - Figura: El array a imprimir todas sus figuras.
		*/
		for (int i=0; i < figuras.length; i++) {
			if (figuras[i] != null) {
				Print.imprimirConAsteriscos(figuras[i].mostrar());
			}
		}
	}
	
}
