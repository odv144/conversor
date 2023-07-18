import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.plaf.basic.BasicLabelUI;

public class Principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDivisa;
	private JButton btnTemp;

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagen/cambio-de-divisas.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 292);
		setTitle("Alura Challeng - Conversor");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnDivisa = new JButton("Divisas");
		ImageIcon clicAqui = new ImageIcon("D:\\2023\\Programacion\\alura2023\\challeng\\conversor\\imagenes\\cambio-de-divisas.png");
		//btnDivisa.setIcon(new ImageIcon("D:\\2023\\Programacion\\alura2023\\challeng\\conversor\\imagenes\\cambio-de-divisas.png"));
		btnDivisa.setIcon(new ImageIcon(clicAqui.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		btnDivisa.setBounds(137, 126, 171, 50);
		btnDivisa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDivisa.setBackground(new Color(0, 102, 255));
		btnDivisa.setForeground(new Color(255, 255, 255));
		btnDivisa.addActionListener(this);
		contentPane.add(btnDivisa);
		
		
		//boton de Temperatura
		btnTemp = new JButton();
		btnTemp.setBackground(new Color(0, 102, 255));
		btnTemp.setForeground(new Color(255, 255, 255));
		btnTemp.setBounds(137, 187, 171, 50);
		ImageIcon temp = new ImageIcon(Principal.class.getResource("/Imagen/temp.png"));
		btnTemp.setText("Temperatura");
		btnTemp.setIcon(new ImageIcon(temp.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		contentPane.add(btnTemp);
			
		
		// Crear un componente JLabel con texto
    	JLabel lblNewLabel = new JLabel("Desafio Conversor <br/>para el curso de Alura Latam <br/> One Oracle");
    	lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 22, 403, 105);
		// Aplicar un efecto de sombra personalizado utilizando la clase ShadowLabelUI
		lblNewLabel.setUI(new ShadowLabelUI(Color.BLACK,2,2));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 236, 27, -49);
		contentPane.add(lblNewLabel_1);
		
		
		   // Crear un componente JLabel para mostrar la imagen
        //ImageIcon imageIcon = new ImageIcon("ruta_de_la_imagen.jpg"); // Ruta de la imagen a mostrar
        //Image image = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        //JLabel imageLabel = new JLabel(new ImageIcon(image));

		
		ImageIcon fondo = new ImageIcon(Principal.class.getResource("/Imagen/conversor-divisas-1200x550-cc.jpg"));
		Image img = fondo.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(img));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_2);
		btnTemp.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnDivisa) {
			WinConvert divisa= new WinConvert();
			divisa.setVisible(true);
		}
		if(e.getSource()==btnTemp) {
			Temperatura frame = new Temperatura();
			frame.setVisible(true);
		}
		
	}
	
	
}
