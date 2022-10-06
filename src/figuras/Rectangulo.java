package figuras;

public class Rectangulo extends Figura {
	private double altura;
	private double base;

	public Rectangulo(double alturaR, double baseR) {
		altura = alturaR;
		base = baseR;
	}
	
	public double superficie() {
		/*
		  PROPÓSITO: Describe la superficie del Rectangulo.
		  PRECONDICION:
		  	* ninguna.
		  POSCONDICION:
		  	* debe devolver la superficie del Rectangulo.
		*/
		return altura * base;
	}

	public String mostrar() {
		/*
		  PROPÓSITO: Describe la información de la altura, la base y la superficie del rectangulo.
		  PRECONDICION:
		 	* Ninguna.
		  POSCONDICION:
		  	* Debe devolver la informacion del rectangulo.
		*/
		return "Rectangulo." + "\n" + "Altura: " + altura + "\n" + "Base: " + base + "\n" + "Superficie: " + superficie();
	}
}
