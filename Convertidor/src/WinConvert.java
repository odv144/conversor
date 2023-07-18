import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Point;
import javax.swing.ImageIcon;

public class WinConvert extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox cbOrigen;
	private JComboBox cbDestino;
	private JButton btnConvertir;
	private JLabel lblResultado;
	private JTextField txtDatos;
	
	String datos[]= new String[] {"Moneda","USD","UYU","EUR","ARG","GBP","CLP","COP","BOB","BRL"};

	/**
	 * Create the frame.
	 */
	public WinConvert() {
		//dimensiones para la pantalla
		contentPane = new JPanel();
		contentPane.setLocation(new Point(500, 200));
		contentPane.setSize(new Dimension(300, 400));
		setSize(587,171);
		setTitle("Calcular Divisas");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Conversor de Divisas");
		lblTitulo.setBounds(10, 11, 166, 30);
		lblTitulo.setForeground(new Color(0, 0, 255));
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 18));
		contentPane.add(lblTitulo);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(166, 21, 46, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(320, 21, 46, 14);
		contentPane.add(lblDestino);
		
		cbOrigen = new JComboBox();
		cbOrigen.setModel(new DefaultComboBoxModel(datos));
		cbOrigen.setBounds(166, 41, 141, 22);
		contentPane.add(cbOrigen);
		
		cbDestino = new JComboBox();
		cbDestino.setModel(new DefaultComboBoxModel(datos));
		cbDestino.setBounds(317, 41, 141, 22);
		contentPane.add(cbDestino);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(468, 41, 89, 23);
		btnConvertir.addActionListener(this);
		contentPane.add(btnConvertir);
		
		lblResultado = new JLabel("Conversion");
		lblResultado.setBackground(new Color(255, 255, 128));
		lblResultado.setForeground(new Color(0, 100, 0));
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblResultado.setBounds(10, 74, 547, 30);
		contentPane.add(lblResultado);
		
		txtDatos = new JTextField();
		txtDatos.setText("0");
		txtDatos.setBounds(10, 41, 141, 22);
		contentPane.add(txtDatos);
		txtDatos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\2023\\Programacion\\alura2023\\challeng\\conversor\\imagenes\\divisas.jpg"));
		lblNewLabel.setBounds(0, 0, 571, 132);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent even) {
		if(even.getSource()==btnConvertir) {
			
			//verificar que exista un valor valida para convertir
			double valor = VerificarValorConvertir(txtDatos.getText());
			if(valor>0) {
				//obtener datos de los combos
				double origen = ObtenerValorDolar(cbOrigen.getSelectedIndex());
				double destino = ObtenerValorDolar(cbDestino.getSelectedIndex());
				//presentar los datos en el label
				if(origen!=destino) {
					double conver = (valor * destino)/origen;
					DecimalFormat df = new DecimalFormat("0.000");

					lblResultado.setText(String.valueOf(valor)+ "-"+cbOrigen.getSelectedItem() +" =  "+ String.valueOf(df.format(conver))+"-"+cbDestino.getSelectedItem() );
			
					}else {
						lblResultado.setText("Es la misma moneda no es necesario Convertir");
						}
			}
			
			
			
		}
	}
	//metodo para verificar si es un numero valido
	public double VerificarValorConvertir(String cantidad) {
		if(cantidad.matches("[0-9]*")) {
			return Double.parseDouble(cantidad);
		}else {
			JOptionPane.showMessageDialog(null,"Ingrese solo numeros para la cantidad","Error",JOptionPane.ERROR_MESSAGE);
			return 0;
		}
				
	}
	//metodo para obtener los datos
	public double ObtenerValorDolar(int indice) {
		double valor = 0;
		switch (indice) {
		case 1:
			valor = 1;
			break;
		case 2:
			valor = 38.19;
			break;
		case 3:
			valor = 0.91;
			break;
		case 4:
			valor = 261.62;
			break;
		case 5:
			valor = 0.78;
			break;
		case 6:
			valor = 809.02;
			break;
		case 7:
			valor = 4174.76;
			break;
		case 8:
			valor = 6.89;
			break;
		case 9:
			valor = 4.88;
			break;
		default:
			valor=1;
		}
		return valor;
	}
}
