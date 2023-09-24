package ConversorDeMonedas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import convirtiendoMonedas.Conversiones;
import convirtiendoMonedas.SeleccionMetodoMoneda;
import convirtiendoTemperatura.SeleccionMetodoTemperatura;

public class menuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	static Conversiones conversion = new Conversiones();
	
	public String monedaSeleccionada = "";
	static double factorConversion;
	public static String simboloMoneda;

	public String getMonedaSeleccionada() {
		return monedaSeleccionada;
	}

	public double getFactorConversion() {
		return factorConversion;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String conversiones = (JOptionPane.showInputDialog(null, "", "Conversores", JOptionPane.PLAIN_MESSAGE, null, new Object[] {
				"Selecciona...", "Conversor de Mondedas", "Conversor de Temperatura"}, "Selecciona")).toString();
		
			if(conversiones == "Conversor de Mondedas") {
				String monedas = (JOptionPane.showInputDialog(null, "", "Monedas", JOptionPane.PLAIN_MESSAGE, null, new Object[] {
						"Selecciona...", "Dolares", "Euros", "Libras Esterlinas", "Yen Japonés", "Won Surcoreano"}, "Selecciona")).toString();
				
				String monedaSeleccionada = monedas;
				//System.out.println(monedaSeleccionada);
				if(monedaSeleccionada == "Dolares") {
					factorConversion = conversion.getColonesADolares();
					//System.out.println(factorConversion);
					simboloMoneda = "$";
				}
				if(monedaSeleccionada == "Euros") {
					factorConversion = conversion.getColonesAEuros();
					simboloMoneda = "€";
				}
				if(monedaSeleccionada == "Libras Esterlinas") {
					factorConversion = conversion.getColonesALibrasEsterlinas();
					simboloMoneda = "£";
				}
				if(monedaSeleccionada == "Yen Japonés") {
					factorConversion = conversion.getColonesAYenes();
					simboloMoneda = "¥";
				}
				if(monedaSeleccionada == "Won Surcoreano") {
					factorConversion = conversion.getColonesAWones();
					simboloMoneda = "₩";
				}
				
				SeleccionMetodoMoneda frame1 = new SeleccionMetodoMoneda();
				frame1.setVisible(true);
			}
			if(conversiones == "Conversor de Temperatura") {
				SeleccionMetodoTemperatura frame2 = new SeleccionMetodoTemperatura();
				frame2.setVisible(true);
			}
	}

	/**
	 * Create the frame.
	 */
	public menuPrincipal() {
		setTitle("Selecciona un conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 325);

	}
	
	public String construyendoMensajeFinal1(String resultado) {
		String mensajeFinal = "Tienes " + simboloMoneda + resultado + monedaSeleccionada + ".";	
		return mensajeFinal;
	}
	public String construyendoMensajeFinal2(String resultado) {
		String mensajeFinal = "Tienes ₡" + resultado + "colones.";	
		return mensajeFinal;
	}
	public String construyendoMensajeFinal3(String resultado, String simboloTemperatura) {
		String mensajeFinal = "Tienes " + simboloTemperatura + resultado + ".";
		return mensajeFinal;
	}
	
}
