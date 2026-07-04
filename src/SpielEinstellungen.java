import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

public class SpielEinstellungen {
	
	JFrame frame = new JFrame("Spiel Einstellungen");
	JPanel panel = new JPanel();
	ButtonGroup RButtons1 = new ButtonGroup();
	ButtonGroup RButtons2 = new ButtonGroup();
	JRadioButton Rbutt1_Sch = new JRadioButton("Leicht");
	JRadioButton Rbutt2_Sch = new JRadioButton("Normal");
	JRadioButton Rbutt3_Sch = new JRadioButton("Schwer");
	JRadioButton Rbutt4_Sch = new JRadioButton("Ziegen Experte");
	JRadioButton Rbutt1_Ge = new JRadioButton("Langsam");
	JRadioButton Rbutt2_Ge = new JRadioButton("Normal");
	JRadioButton Rbutt3_Ge = new JRadioButton("Schnell");
	JRadioButton Rbutt4_Ge = new JRadioButton("Ziege auf Koks");
	JLabel Schwere = new JLabel();
	JLabel Schnell = new JLabel();
	JSeparator Sepa1 = new JSeparator();
	JSeparator Sepa2 = new JSeparator();
	JSeparator Sepa3 = new JSeparator();
	JSeparator Sepa4 = new JSeparator();
	Toolkit tk = Toolkit.getDefaultToolkit();  
	int xSize = ((int) tk.getScreenSize().getWidth());  
	int ySize = ((int) tk.getScreenSize().getHeight()); 
	
	public SpielEinstellungen(){
		frame.setBounds(xSize/2-200, ySize/2-150, 400, 300);
		panel.setLayout(null);
		frame.add(panel);
		panel.add(Rbutt1_Sch);
		panel.add(Schwere);
		panel.add(Schnell);
		panel.add(Sepa1);
		panel.add(Sepa2);
		Sepa1.setBounds(0, 60, 400, 1);
		Sepa1.setForeground(Color.BLACK);
		Schwere.setBounds(150, 5, 200, 20);
		Schwere.setText("Schwierigkeitsgrad");
		Schnell.setBounds(150, 65, 200, 20);
		Schnell.setText("Spielgeschwindigkeit");
		Rbutt1_Sch.setBounds(10, 30, 80, 20);
		panel.add(Rbutt2_Sch);
		Rbutt2_Sch.setBounds(90, 30, 80, 20);
		panel.add(Rbutt3_Sch);
		Rbutt3_Sch.setBounds(170, 30, 80, 20);
		panel.add(Rbutt4_Sch);
		Rbutt4_Sch.setBounds(250, 30, 110, 20);
		Rbutt1_Ge.setBounds(10, 90, 80, 20);
		panel.add(Rbutt1_Ge);
		Rbutt2_Ge.setBounds(90, 90, 80, 20);
		panel.add(Rbutt2_Ge);
		Rbutt3_Ge.setBounds(170, 90, 80, 20);
		panel.add(Rbutt3_Ge);
		Rbutt4_Ge.setBounds(250, 90, 110, 20);
		panel.add(Rbutt4_Ge);
		RButtons1.add(Rbutt1_Sch);
		RButtons1.add(Rbutt2_Sch);
		RButtons1.add(Rbutt3_Sch);
		RButtons1.add(Rbutt4_Sch);
		RButtons2.add(Rbutt1_Ge);
		RButtons2.add(Rbutt2_Ge);
		RButtons2.add(Rbutt3_Ge);
		RButtons2.add(Rbutt4_Ge);
		Rbutt2_Sch.setSelected(true);
		Rbutt2_Ge.setSelected(true);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	

}
