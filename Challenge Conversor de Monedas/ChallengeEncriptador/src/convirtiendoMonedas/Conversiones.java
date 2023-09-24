package convirtiendoMonedas;

public class Conversiones {
	
	double colonesADolares = 8.71;								//Se tomaron datos provenientes de la calculadora de Google
	double colonesAEuros = 8.71;
	double colonesALibrasEsterlinas = 10.66;
	double colonesAYenes = 0.059;
	double colonesAWones = 0.0065;
	
	public double getColonesADolares() {		//Getters para no colocar variables directamente en la JFrame
		return colonesADolares;
	}

	public double getColonesAEuros() {
		return colonesAEuros;
	}

	public double getColonesALibrasEsterlinas() {
		return colonesALibrasEsterlinas;
	}

	public double getColonesAYenes() {
		return colonesAYenes;
	}

	public double getColonesAWones() {
		return colonesAWones;
	}

}
