import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Temperatura extends JFrame {

	private JPanel contentPane;
	private double temp=0;
	private double tempK=0;
	private double tempF=0;
	private JLabel lblCelsius;
	private JLabel lblFaren;
	private JLabel lblKelvin;
	private JSlider SliFare;
	private JSlider SliKelvin;
	private JLabel lblNewLabel_3;

	/**
	 * Create the frame.
	 */
	public Temperatura() {
		setResizable(false);
		setTitle("Conversion de Temperatura");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 452, 390);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Fahrenheit(F)");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(0, 100, 0));
		lblNewLabel_2.setBounds(32, 212, 157, 29);
		
		JLabel lblNewLabel = new JLabel("Celsius(C)");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setBounds(32, 149, 106, 15);
		
		JSlider SliCelcius = new JSlider();
		SliCelcius.setOpaque(false);
		SliCelcius.setPaintLabels(true);
	
		SliCelcius.setPaintTicks(true);
		SliCelcius.setValue(0);
		SliCelcius.setMinimum(-100);
		SliCelcius.setBounds(32, 175, 249, 26);
		
		lblCelsius = new JLabel("0");
		lblCelsius.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCelsius.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblCelsius.setBounds(289, 170, 113, 20);
		
		SliFare = new JSlider();
		SliFare.setOpaque(false);
		SliFare.setEnabled(false);
		SliFare.setToolTipText("Valor en Fahrenheit obtenido desde los celcius");
		SliFare.setMaximum(215);
		tempF=this.CelciusAFahre(temp);
		SliFare.setValue((int)tempF);
		SliFare.setPaintTicks(true);
		SliFare.setMinimum(-148);
		SliFare.setBounds(32, 252, 249, 26);
		
		lblFaren = new JLabel(String.valueOf(tempF));
		lblFaren.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFaren.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblFaren.setBounds(289, 241, 113, 29);
		
		JLabel lblNewLabel_1 = new JLabel("Kelvin(K)");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setBounds(32, 277, 134, 26);
		
		SliKelvin = new JSlider();
		SliKelvin.setOpaque(false);
		SliKelvin.setEnabled(false);
		SliKelvin.setSnapToTicks(true);
		SliKelvin.setPaintLabels(true);
		SliKelvin.setPaintTicks(true);
		tempK=this.CelciusAKelvin(temp);
		SliKelvin.setValue((int)tempK);
		SliKelvin.setMinimum(170);
		SliKelvin.setMaximum(375);
		SliKelvin.setBounds(32, 314, 247, 26);
		
		lblKelvin = new JLabel(String.valueOf(tempK));
		lblKelvin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKelvin.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblKelvin.setBounds(289, 303, 113, 26);
		
		
		
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(SliCelcius);
		contentPane.add(lblCelsius);
		contentPane.add(SliFare);
		contentPane.add(lblFaren);
		contentPane.add(SliKelvin);
		contentPane.add(lblKelvin);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imgTemp = new ImageIcon(Temperatura.class.getResource("/Imagen/images.jpeg"));
		lblNewLabel_3.setIcon(new ImageIcon(imgTemp.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		lblNewLabel_3.setBounds(32, 11, 100, 106);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("<html><center>Conversor de Temperatura Ajustable segun el Slider de Grados Celsius<center/><html/>");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(166, 23, 206, 94);
		contentPane.add(lblNewLabel_4);
		
		SliCelcius.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				DecimalFormat df = new DecimalFormat("0.00");
				temp = (double) SliCelcius.getValue();
				lblCelsius.setText(String.valueOf(temp));
				double tempF = CelciusAFahre(temp);
				SliFare.setValue((int)tempF);
				lblFaren.setText(String.valueOf(df.format(tempF)));
				double tempK = CelciusAKelvin(temp);
				SliKelvin.setValue((int)tempK);
				lblKelvin.setText(String.valueOf(df.format(tempK)));
			}
		});
		
		
	}

	public double CelciusAFahre(double temp) {
		return (temp*1.8)+32;
	}
	public double CelciusAKelvin(double temp) {
		return (temp+273.15);
	}
}
