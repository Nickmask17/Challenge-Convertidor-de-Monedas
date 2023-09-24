package convirtiendoTemperatura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConversorDeMonedas.menuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class IngresandoValoresFahrToKel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	IngresandoValoresCelcToFahr temp = new IngresandoValoresCelcToFahr();
	
	double valorIngresado;
	double resultado;
	String conversion;
	String simboloTemperatura = "K";
	
	menuPrincipal moneda = new menuPrincipal();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresandoValoresFahrToKel frame = new IngresandoValoresFahrToKel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IngresandoValoresFahrToKel() {
		setTitle("Ingrese el valor a convertir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el valor en °F");
		lblNewLabel.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 414, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				
				boolean numero = key >= 48 && key <= 57;
				
				if(!numero) {
					e.consume();
				}
			}
		});
		textField.setBounds(20, 57, 404, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(textField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"Valor no válido.");
				}
				else {
					valorIngresado = Double.valueOf(textField.getText());
					//System.out.println(valorIngresado);					Supervisión de la correcta recepción de datos
					fahrenheitAKelvin();
					dispose();
					JOptionPane.showMessageDialog(null,moneda.construyendoMensajeFinal3(conversion, simboloTemperatura));
					int resp = JOptionPane.showConfirmDialog(null, "¿Desea Continuar?", "Elija una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(resp == 0) {
						dispose();
						menuPrincipal.main(null);
					}
					if(resp == 1 || resp == 2) {
						dispose();
						JOptionPane.showMessageDialog(null,"Programa Finalizado");
						System.exit(0);
					}
				}
			}
		});
		btnNewButton.setBounds(156, 202, 119, 35);
		contentPane.add(btnNewButton);
	}
	
	double conv1 = temp.celciusAFahrenheit(valorIngresado);
	
	public double fahrenheitAKelvin() { 									//Se convierte de fahrenheit a kelvin
		resultado = conv1 + 273.15;
		conversion = String.valueOf((double)Math.round(resultado * 100d) / 100d);
		System.out.println((double)Math.round(resultado * 100d) / 100d);
		return resultado;
	}
}
