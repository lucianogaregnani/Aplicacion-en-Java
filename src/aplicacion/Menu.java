package aplicacion;

import java.io.*;
import java.util.Scanner;
import figuras.*;
import utilidades.*;

class Menu {
	private Figura figuras[];
	private Scanner lectura = new Scanner(System.in); 
	private BufferedReader bf = getBufferedConDireccion("./src/aplicacion/texto.txt");

	
	public void iniciar() {
		/*
		  PROPÓSITO: Da inicio a la aplicación.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Debera ejecutarse el método cargarFiguras y opciones de menu, si no
		  	  encuentra el archivo, se ejecutara un error.
		*/
		try {
			figuras = new Figura[Integer.parseInt(bf.readLine())];
			cargarFiguras(figuras);
			opcionesDeMenu();
		}
		catch(IOException e) {
			throw new RuntimeException("Ocurrio un problema.");
		}
	}
	
	public void cargarFiguras(Figura figuras[]) {
		/*
		  PROPÓSITO: Carga todas las figuras que ingrese el usuario en el array dado.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* Todo el array dado debera llenarse con las figuras que ingrese el usuario.
		  	  si el formato del archivo esta mal, ejecuta opcionesDeMenu, si no se encuentra
		  	  el archivo, lanza una excepcion.
		  PARÁMETROS:
		  	* figuras - Figura: El array a cargar.
		*/
		Print.imprimirConAsteriscos("Cargando figuras...");
		try {
			for(int i=0;i < figuras.length;i++) { 
				String[] dato = bf.readLine().split(" ");
				switch(dato[0]) {
  					case "C": 
  						figuras[i] = new Circulo(Double.parseDouble(dato[1]));
  						break;
  					case "R":
  						figuras[i] = new Rectangulo(Double.parseDouble(dato[1]), Double.parseDouble(dato[2])); 					
  						break;
  					case "T":
  						figuras[i] = new Triangulo(Double.parseDouble(dato[1]), Double.parseDouble(dato[2]));
  						break;
  					default:
  						throw new RuntimeException("Datos incorrectos.");
				}	
				System.out.println((i + 1) + "/" + figuras.length); 
			}
			Print.imprimirConAsteriscos("Figuras cargadas correctamente!");
		}
		catch(NullPointerException e) {
			Print.imprimirConAsteriscos("Faltaron datos para que se agreguen las figuras.");
			opcionesDeMenu();
		}
		catch(IOException e) { 
			Print.imprimirConAsteriscos("No se encontro el archivo.");
		}
	}
	
	public void cargarFigura() {
		/*
		  PROPÓSITO: Si hay valores vacios en el array carga la figura elegida, si no lo hay
		  			 redimensiona el array y luego la carga.
		  PRECONDICION:
		  	* Ninguna.
		  POSCONDICION:
		  	* El array debe set redimensionado si no hay espacios vacios.
		*/		
	    if(!ArrayFigura.hayValoresVacios(figuras)) 
	        figuras = ArrayFigura.redimensionarArreglo(figuras);
		int proximaPosVacia = ArrayFigura.posVacia(figuras);
		cargarFiguraOpciones(proximaPosVacia);
	}
	
	public void cargarFiguraOpciones(int posicion) {
	   /*
        PROPÓSITO: Imprime por pantalla las diferentes opciones de figuras a 
        agregar y luego dependiendo de que haya seleccionado el usuario crea
        una instancia de la figura, y la agrega en el atributo figuras, en la 
        posición dada.
        PRECONDICION:
          * El parámetro posición, debe ser una posición correcta.
        PARÁMETROS:
          * posición : int - La posición donde agregar la figura.
        POSCONDICION:
          * Debe de instanciarse la figura elegida con sus dimensiones elegidas
            en el atributo figuras.
      */  
	    Print.opcionesDeFiguras();
	    switch(lectura.next().toUpperCase()) {
	        case "C": 
	            Print.imprimirConGuiones("Ingrese el radio.");
                figuras[posicion] = new Circulo(lectura.nextDouble());
                break;
            case "R":
                Print.imprimirConGuiones("Ingrese la altura y la base.");
                figuras[posicion] = new Rectangulo(lectura.nextDouble(), lectura.nextDouble());
                break;
            case "T":
                Print.imprimirConGuiones("Ingrese la altura y la base.");
                figuras[posicion] = new Triangulo(lectura.nextDouble(), lectura.nextDouble());
                break;
            default:
                System.out.println("Ingreso mal el dato.");     
                cargarFigura();
       }
	   Print.imprimirConGuiones("Figura cargada correctamente!");
	}
	
	public void opcionesDeMenu() {
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
					Print.imprimirConGuiones("Elija la posición.");
					figuraEnPos(lectura.nextInt(), figuras);
					Print.opcionesDeMenu();
					break;
				case 2:
					Print.imprimirConGuiones("Elija la posición.");
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
					Print.imprimirConGuiones("Superficie maxima." + "\n" + ArrayFigura.superficieMaxima(figuras).mostrar());
					Print.imprimirConGuiones("Superficie minima." + "\n"  + ArrayFigura.superficieMinima(figuras).mostrar());
					Print.opcionesDeMenu();
					break;
				default:
					Print.imprimirConAsteriscos("No existe esa opcion.");
					opcionesDeMenu();
			}
		}		
		System.out.println("Ejecución finalizada.");
	}
	
	public void removerEnPos(int pos, Figura[] figuras) {
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
	
	public void figuraEnPos(int pos, Figura figuras[]) {
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
			Print.imprimirConAsteriscos(figuras[pos].mostrar());
		}
	}
	
    public BufferedReader getBufferedConDireccion(String direccion) {
        /*
          PROPÓSITO: Instancia el atributo BufferedReader con la direccion dada.
          PRECONDICION:
            * La direccion debe ser una direccion correcta.
          POSCONDICION:
            * Debe instanciar el atributo BufferedReader con la direccion dada.
          PARÁMETROS:
            * direccion - String: La dirección del archivo txt.
        */
        try {
            return new BufferedReader(new FileReader(direccion));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No se encontro el archivo.");
        }
    }
    
    public void setDireccion(String direccion) {
        /*
          PROPÓSITO: Instancia el atributo BufferedReader con la direccion dada.
          PRECONDICION:
            * La direccion debe ser una direccion correcta.
          POSCONDICION:
            * Debe instanciar el atributo BufferedReader con la direccion dada.
          PARÁMETROS:
            * direccion - String: La dirección del archivo txt.
        */
        try {
            bf = new BufferedReader(new FileReader(direccion));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	
}
