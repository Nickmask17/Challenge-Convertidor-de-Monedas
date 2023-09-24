package convirtiendoTemperatura;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionMetodoTemperatura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionMetodoTemperatura frame = new SeleccionMetodoTemperatura();
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
	public SeleccionMetodoTemperatura() {
		setTitle("Seleccione el tipo de conversion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(97, 211, 166));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione el tipo de conversion que quiere realizar.");
		lblNewLabel.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 36, 508, 45);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxCelciusToFahrenheit = new JCheckBox("Celcius a Fahrenheit");
		chckbxCelciusToFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCelciusToFahrenheit.setBounds(87, 116, 152, 45);
		contentPane.add(chckbxCelciusToFahrenheit);
		
		JCheckBox chckbxFahrenheitToCelcius = new JCheckBox("Fahrenheit a Celcius");
		chckbxFahrenheitToCelcius.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxFahrenheitToCelcius.setBounds(87, 179, 152, 45);
		contentPane.add(chckbxFahrenheitToCelcius);
		
		JCheckBox chckbxCelciusToKelvin = new JCheckBox("Celcius a Kelvin");
		chckbxCelciusToKelvin.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCelciusToKelvin.setBounds(309, 116, 152, 45);
		contentPane.add(chckbxCelciusToKelvin);
		
		JCheckBox chckbxFahrenheitToKelvin = new JCheckBox("Fahrenheit a Kelvin");
		chckbxFahrenheitToKelvin.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxFahrenheitToKelvin.setBounds(309, 179, 152, 45);
		contentPane.add(chckbxFahrenheitToKelvin);
		
		JButton btnNewButton = new JButton("Siguiente...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(chckbxCelciusToFahrenheit.isSelected()) {
					IngresandoValoresCelcToFahr frame1 = new IngresandoValoresCelcToFahr();
					frame1.setVisible(true);
					dispose();
				}
				if(chckbxFahrenheitToCelcius.isSelected()) {
					IngresandoValoresFahrToCelc frame2 = new IngresandoValoresFahrToCelc();
					frame2.setVisible(true);
					dispose();
				}
				if(chckbxCelciusToKelvin.isSelected()) {
					IngresandoValoresCelcToKel frame3 = new IngresandoValoresCelcToKel();
					frame3.setVisible(true);
					dispose();
				}
				if(chckbxFahrenheitToKelvin.isSelected()) {
					IngresandoValoresFahrToKel frame4 = new IngresandoValoresFahrToKel();
					frame4.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(199, 253, 152, 51);
		contentPane.add(btnNewButton);
		
	}
}
