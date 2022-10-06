package figuras;

public class Triangulo extends Figura {
	private double altura;
	private double base;
	
	public Triangulo(double alturaT, double baseT) {
		altura = alturaT;
		base = baseT;
	}
	
	public double superficie() {
		/*
		  PROPÓSITO: Describe la superficie del triangulo.
		  PRECONDICION:
		  	* ninguna.
		  POSCONDICION:
		  	* debe devolver la superficie del triangulo.
		*/
		return (altura * base) / 2;
	}

	public String mostrar() {
		/*
		  PROPÓSITO: Describe la información de la altura, la base y la superficie del Triangulo.
		  PRECONDICION:
		 	* Ninguna.
		  POSCONDICION:
		  	* Debe devolver la informacion del triangulo.
		*/
		return "Triangulo." + "\n" + "Altura: " + altura + "\n" + "Base: " + base + "\n" + "Superficie: " + superficie();
	}
	
}
