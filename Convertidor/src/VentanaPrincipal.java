import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private JButton btn1;
	private JLabel etiqueta;
	private JCheckBox check;
	
	public VentanaPrincipal() {
		setSize(500,400);
		setTitle("Ventana Princiapal");
		setLocationRelativeTo(null);
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		setLayout(null);
		btn1= new JButton();
		btn1.setText("Precioname");
		btn1.setBounds(10,20,120,30);
		btn1.addActionListener(this);
		
		etiqueta = new JLabel();
		etiqueta.setText("Dato");
		etiqueta.setBounds(150,20,150,40);
		etiqueta.setOpaque(true);
		
		check = new JCheckBox();
		check.setText("Valor 1");
		check.setBounds(50, 60, 100, 100);
		
		add(check);
		add(etiqueta);
			
		add(btn1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			//JOptionPane.showMessageDialog(null, "Boton presioando");
			etiqueta.setText("El boton se preciono");
			
			if(check.isSelected()) {
				etiqueta.setBackground(Color.GREEN);
			}
		}
		
		
	}
}
