import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Temperatura extends JFrame {

	private JPanel contentPane;
	private double temp=0;
	private JLabel lblCelsius;
	private JLabel lblFaren;

	/**
	 * Create the frame.
	 */
	public Temperatura() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Farenghit");
		lblNewLabel_2.setBounds(40, 62, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Celsius");
		lblNewLabel.setBounds(40, 10, 46, 14);
		contentPane.add(lblNewLabel);
		
		JSlider SliCelcius = new JSlider();
	
		SliCelcius.setPaintTicks(true);
		SliCelcius.setValue(0);
		SliCelcius.setMinimum(-100);
		SliCelcius.setBounds(83, 10, 259, 26);
		contentPane.add(SliCelcius);
		
		lblCelsius = new JLabel("1");
		lblCelsius.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblCelsius.setBounds(347, 16, 77, 20);
		contentPane.add(lblCelsius);
		
		JSlider SliFare = new JSlider();
		SliFare.setPaintTicks(true);
		SliFare.setValue(0);
		SliFare.setMinimum(-100);
		SliFare.setBounds(93, 50, 249, 26);
		contentPane.add(SliFare);
		
		lblFaren = new JLabel("1");
		lblFaren.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblFaren.setBounds(347, 47, 77, 29);
		contentPane.add(lblFaren);
		
		SliCelcius.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				temp = (double) SliCelcius.getValue();
				lblCelsius.setText(String.valueOf(temp));
				double tempF = ConverTemp(temp);
				SliFare.setValue((int)tempF);
				lblFaren.setText(String.valueOf(tempF));
			}
		});
		
		
	}
	public double ConverTemp(double temp) {
		return temp*0.5;
	}
}
