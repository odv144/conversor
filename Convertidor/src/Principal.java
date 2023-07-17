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

public class Principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDivisa;
	private JButton btnTemp;

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		btnDivisa.setBounds(10, 11, 171, 50);
		btnDivisa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDivisa.setBackground(new Color(0, 102, 255));
		btnDivisa.setForeground(new Color(255, 255, 255));
		btnDivisa.addActionListener(this);
		contentPane.add(btnDivisa);
		
		
		//boton de Temperatura
		btnTemp = new JButton();
		btnTemp.setBackground(new Color(0, 102, 255));
		btnTemp.setForeground(new Color(255, 255, 255));
		btnTemp.setBounds(10, 60, 171, 50);
		ImageIcon temp = new ImageIcon(Principal.class.getResource("/Imagen/temp.png"));
		btnTemp.setText("Temperatura");
		btnTemp.setIcon(new ImageIcon(temp.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		contentPane.add(btnTemp);
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
