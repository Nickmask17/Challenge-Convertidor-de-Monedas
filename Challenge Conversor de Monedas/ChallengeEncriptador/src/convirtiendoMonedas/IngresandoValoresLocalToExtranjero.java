package convirtiendoMonedas;

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
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

public class IngresandoValoresLocalToExtranjero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	menuPrincipal moneda = new menuPrincipal();		//Inicializando los objetos para poder obtener sus getters
	Conversiones conversion = new Conversiones();
	
	double factorConversion = moneda.getFactorConversion();
	double valorIngresado;
	double resultado;
	String valorConvertido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresandoValoresLocalToExtranjero frame = new IngresandoValoresLocalToExtranjero();
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
	public IngresandoValoresLocalToExtranjero() {
		setTitle("Ingrese el valor a convertir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el valor Colones");
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
		
		/*
		 * Intento de pasar el factor de conversion sin éxito.
		 * 
		 * switch (moneda.getMonedaSeleccionada()) { case "Dólares": factorConversion =
		 * conversion.getColonesADolares(); break;
		 * 
		 * case "Euros": factorConversion = conversion.getColonesAEuros(); break;
		 * 
		 * case "Libras Esterlinas": factorConversion =
		 * conversion.getColonesALibrasEsterlinas(); break;
		 * 
		 * case "Yen Japonés": factorConversion = conversion.getColonesAYenes(); break;
		 * 
		 * case "Won Surcoreano": factorConversion = conversion.getColonesAWones();
		 * break;
		 * 
		 * default: break; }
		 */
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				if(textField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,"Valor no válido.");
				}
				else {
					valorIngresado = Double.valueOf(textField.getText());
					//System.out.println(valorIngresado);					Supervisión de la correcta recepción de datos
					//System.out.println(factorConversion);
					ColonesAExtranjero();
					dispose();
					JOptionPane.showMessageDialog(null,moneda.construyendoMensajeFinal1(valorConvertido));
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
	
	public double ColonesAExtranjero() { 									//Se convierte de la moneda local a monedas extranjeras
		resultado = valorIngresado * (1/factorConversion);
		valorConvertido = String.valueOf((double)Math.round(resultado * 100d) / 100d);
		System.out.println((double)Math.round(resultado * 100d) / 100d);
		return resultado;
	}
}
