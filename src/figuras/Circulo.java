package figuras;

public class Circulo extends Figura {
	private double radio;

	public Circulo(double radioCirc) {
		radio = radioCirc;
	}
	
	public double superficie() {
		/*
		  PROPÓSITO: Describe la superficie del circulo.
		  PRECONDICION:
		  	* ninguna.
		  POSCONDICION:
		  	* debe devolver la superficie del circulo.
		*/
		return Math.PI * Math.pow(radio, 2);
	}

	public String mostrar() {
		/*
		  PROPÓSITO: Describe la información del radio y superficie del circulo.
		  PRECONDICION:
		 	* Ninguna.
		  POSCONDICION:
		  	* Debe devolver la informacion del circulo.
		*/
		return "Circulo." + "\n" + "Radio: " + radio + "\n" + "Superficie: " + superficie(); 
	}
	
}
