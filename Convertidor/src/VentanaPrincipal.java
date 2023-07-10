import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private JButton btn1;
	private JLabel etiqueta;
	private JComboBox origen, destino;
	private JCheckBox check;
	private JTextField txtDato;
	
	public VentanaPrincipal() {
		setSize(500,400);
		setTitle("Ventana Princiapal");
		setLocationRelativeTo(null);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		setLayout(null);
		destino = new JComboBox();
		origen = new JComboBox();
		origen.addItem("Dolar Americano");
		origen.addItem("Pesos Uruguayo");
		origen.addItem("Pesos Argentino");
		origen.addItem("Real");
		
		destino.addItem("Dolar Americano");
		destino.addItem("Pesos Uruguayo");
		destino.addItem("Pesos Argentino");
		destino.addItem("Real");
		
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
		check.setBounds(440, 10, 100, 100);
		
		txtDato = new JTextField();
		txtDato.setText("Ingrese el monto a convertir");
		txtDato.setBounds(10, 60,220, 30);
		
		origen.setBounds(10, 100, 80, 30);
		destino.setBounds(100, 100, 100, 30);
		
		//metodos requerido para agregarlo al JFrame para que se agregue sino no se ve
		add(check);
		add(etiqueta);
		add(btn1);
		add(txtDato);
		add(origen);
		add(destino);
	}
	//metodo sobreescrito para poder asignar metodos a los objetos
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			//JOptionPane.showMessageDialog(null, "Boton presioando");
			etiqueta.setText("El boton se preciono");
			
			if(check.isSelected()) {
				etiqueta.setBackground(Color.GREEN);
				etiqueta.setText(txtDato.getText());
			}
		}
		
		
	}
}
