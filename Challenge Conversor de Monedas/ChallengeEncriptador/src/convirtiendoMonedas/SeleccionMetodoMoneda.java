package convirtiendoMonedas;

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

public class SeleccionMetodoMoneda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionMetodoMoneda frame = new SeleccionMetodoMoneda();
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
	public SeleccionMetodoMoneda() {
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
		
		JCheckBox chckbxLocalToExtranjero = new JCheckBox("Local a Extranjero");
		chckbxLocalToExtranjero.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxLocalToExtranjero.setBounds(77, 133, 152, 45);
		contentPane.add(chckbxLocalToExtranjero);
		
		
		JCheckBox chckbxExtranjeroToLocal = new JCheckBox("Extranjero a Local");
		chckbxExtranjeroToLocal.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxExtranjeroToLocal.setBounds(323, 133, 152, 45);
		contentPane.add(chckbxExtranjeroToLocal);
		
		JButton btnNewButton = new JButton("Siguiente...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(chckbxLocalToExtranjero.isSelected()) {
					IngresandoValoresLocalToExtranjero frame1 = new IngresandoValoresLocalToExtranjero();
					frame1.setVisible(true);
					dispose();
				}
				if(chckbxExtranjeroToLocal.isSelected()) {
					IngresandoValoresExtranjeroToLocal frame2 = new IngresandoValoresExtranjeroToLocal();
					frame2.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(199, 253, 152, 51);
		contentPane.add(btnNewButton);
		
	}
}
