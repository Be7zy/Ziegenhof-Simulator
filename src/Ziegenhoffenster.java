import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.*;

public class Ziegenhoffenster implements ActionListener{
	
	//***
	//Variablen
	//***
	
	// Hauptfenster
	Ziegenhofkonto Konto = new Ziegenhofkonto();
	Timer Hirn = new Timer(1000, this);
	JFrame frame;
	JPanel panel;
	JSeparator sepaO;
	JSeparator sepaU;
	JSeparator sepaM;
	Font Schrift = new Font("Arial", Font.PLAIN, 12);
	Font Schrift2 = new Font("Arial", Font.PLAIN, 10);
	Font Schrift3 = new Font("Arial", Font.PLAIN, 20);
	Color bgGruen = Color.getHSBColor(0.25f, 0.6f, 0.7f);
	
	Toolkit tk = Toolkit.getDefaultToolkit();  
	int xSize = ((int) tk.getScreenSize().getWidth());  
	int ySize = ((int) tk.getScreenSize().getHeight()); 
	
	int Tag = 1;
	int Monat = 1;
	int Jahr = 0;
	
	int Runde = 0;
	boolean EinmalKeinFutter = false;
	boolean ErstesSilo = true;
	
	DecimalFormat LiterF = new DecimalFormat("#0.0 L");
	DecimalFormat GeldF = new DecimalFormat("#0.00 €");
	
	
	// Land
	JButton LandButt;
	JLabel LandLab;
	int LandBesitz = 0;
	int LandKosten = 150;
	
	// Stall
	JButton StallButt;
	JLabel StallLab;
	JButton StallLvlButt;
	int StallLvl = 0;
	int StallLvlKosten = 1000;
	int StallBesitz = 0;
	int StallKosten = 100;
	
	// Silo
	JButton SiloButt;
	JLabel SiloLab;
	JButton SiloLvlButt;
	int SiloLvl = 0;
	int SiloLvlKosten = 1000;
	int SiloBesitz = 0;
	int SiloKosten = 100;
	
	// Ziege
	JButton ZiegeButt;
	JLabel ZiegeLab;
	JLabel ZiegeStress;
	JButton ZiegeLvlButt;
	JButton ZiegeLvlButt2;
	int ZiegeLvl = 0;
	int ZiegeLvl2 = 0;
	int ZiegeLvlKosten = 2000;
	int ZiegeLvlKosten2 = 2000;
	int ZiegeBesitz = 0;
	int ZiegeKosten = 50;
	int ZiegenGesund = 100;
	
	// Futter
	JLabel FutterLbl;
	JButton Futter1;
	JButton Futter10;
	JButton Futter100;
	JButton Futter1000;
	
	//Geld
	JLabel GesamtGeld;
	JLabel GeldProRunde;
	
	//Info Bereich
	JLabel NameLab;
	JLabel Datum;
	JLabel BauPlatz;
	JButton Pause;
	JButton Weiter;
	JLabel PauseLbl;
	int BauPlatzFrei = 0;
	JLabel StallPlatz;
	int StallPlatzFrei = 0;
	JLabel FutterPlatz;
	int FutterPlatzFrei = 0;
	int Futter = 0;
	JProgressBar FutterBar;
	JProgressBar ZiegeZuSt;
	JLabel Milch;
	double MilchProdPZ = 5;
	double MilchProdGes = 0;
	double MilchWert = 0.5;
	double MilchGesVerk = 0;
	double GesGewinn = 0;
	double FutterKauf = 0;
	
	
	
	
	
	//***
	//Constructor
	//***
	public Ziegenhoffenster(){
		this("Dummer Bauer ohne Name");
	}
	public Ziegenhoffenster(String name){
		URL url1 = getClass().getResource("/Icos/Silo.jpg");
		URL url2 = getClass().getResource("/Icos/Land.jpg");
		URL url3 = getClass().getResource("/Icos/Stall.jpg");
		URL url4 = getClass().getResource("/Icos/Ziege.jpg");
		URL url5 = getClass().getResource("/Icos/KaufBild.jpg");
		URL url6 = getClass().getResource("/Icos/Plus.jpg");
		URL url7 = getClass().getResource("/Icos/Futter1.jpg");
		URL url8 = getClass().getResource("/Icos/Futter10.jpg");
		URL url9 = getClass().getResource("/Icos/Futter100.jpg");
		URL url10 = getClass().getResource("/Icos/Futter1000.jpg");
		URL url11 = getClass().getResource("/Icos/Pause.jpg");
		URL url12 = getClass().getResource("/Icos/Weiter.jpg");
		ImageIcon SiloBild = new ImageIcon(url1);
		ImageIcon LandBild = new ImageIcon(url2);
		ImageIcon StallBild = new ImageIcon(url3);
		ImageIcon ZiegeBild = new ImageIcon(url4);
		ImageIcon KaufBild = new ImageIcon(url5);
		ImageIcon PlusBild = new ImageIcon(url6);
		ImageIcon Futter1Ico = new ImageIcon(url7);
		ImageIcon Futter10Ico = new ImageIcon(url8);
		ImageIcon Futter100Ico = new ImageIcon(url9);
		ImageIcon Futter1000Ico = new ImageIcon(url10);
		ImageIcon PauseIco = new ImageIcon(url11);
		ImageIcon WeiterIco = new ImageIcon(url12);
		frame = new JFrame("Dein Ziegenhof");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBackground(bgGruen);
		LandButt = new JButton(LandBild);
		StallButt = new JButton(StallBild);
		SiloButt = new JButton(SiloBild);
		ZiegeButt = new JButton(ZiegeBild);
		LandLab = new JLabel();
		SiloLab = new JLabel();
		StallLab = new JLabel();
		ZiegeLab = new JLabel();
		GesamtGeld = new JLabel("Vermögen:                                           " + GeldF.format(Konto.getGesamtGeld()));
		GesamtGeld.setBounds(60, 350, 380, 30);
		GesamtGeld.setFont(Schrift);
		GeldProRunde = new JLabel("Gewinn pro Runde:                                  " + GeldF.format(Konto.getGeldProRunde()));
		GeldProRunde.setBounds(60, 370, 380, 30);
		GeldProRunde.setFont(Schrift);
		sepaO = new JSeparator();
		sepaU = new JSeparator();
		sepaM = new JSeparator();
		SiloLvlButt = new JButton(PlusBild);
		StallLvlButt = new JButton(PlusBild);
		ZiegeLvlButt = new JButton(PlusBild);
		ZiegeLvlButt2 = new JButton(PlusBild);
		BauPlatz = new JLabel();
		StallPlatz = new JLabel();
		FutterPlatz = new JLabel();
		Milch = new JLabel();
		NameLab = new JLabel();
		Datum = new JLabel();
		BauPlatz = new JLabel();
		StallPlatz = new JLabel();
		FutterPlatz = new JLabel();
		FutterBar = new JProgressBar();
		ZiegeStress = new JLabel();
		ZiegeZuSt = new JProgressBar();
		FutterLbl = new JLabel();
		Futter1 = new JButton(Futter1Ico);
		Futter10 = new JButton(Futter10Ico);
		Futter100 = new JButton(Futter100Ico);
		Futter1000 = new JButton(Futter1000Ico);
		Pause = new JButton(PauseIco);
		Weiter = new JButton(WeiterIco);
		PauseLbl = new JLabel();
		
		
		frame.setBounds((xSize/2-200), (ySize/2-215), 450, 430);
		frame.setResizable(false);
		
		panel.setLayout(null);
		panel.add(sepaO);
		sepaO.setForeground(Color.BLACK);
		sepaO.setBounds(0, 20, 450, 1);
		panel.add(sepaU);
		sepaU.setForeground(Color.BLACK);
		sepaU.setBounds(0, 350, 450, 1);
		panel.add(sepaM);
		sepaM.setOrientation(SwingConstants.VERTICAL);
		sepaM.setForeground(Color.BLACK);
		sepaM.setBounds(250, 20, 1, 330);
		panel.add(GesamtGeld);
		panel.add(GeldProRunde);
		panel.add(NameLab);
		NameLab.setBounds(120, 3, 300, 15);
		NameLab.setText("Ziegenhirte:  " + name);
		panel.add(Datum);
		Datum.setBounds(285, 20, 150, 40);
		Datum.setFont(Schrift2);
		Datum.setText("<html>      Spielzeit: <br>"
					+ "Jahre " + Jahr + "|  Monat " + Monat + "| Tag " + Tag + "<html>");
		panel.add(BauPlatz);
		BauPlatz.setBounds(255, 60, 185, 20);
		panel.add(StallPlatz);
		StallPlatz.setBounds(255, 80, 185, 20);
		panel.add(FutterPlatz);
		FutterPlatz.setBounds(255, 100, 185, 40);
		panel.add(FutterBar);
		FutterBar.setBounds(255, 140, 185, 20);
		panel.add(ZiegeStress);
		ZiegeStress.setBounds(255, 180, 150, 20);
		ZiegeStress.setText("<html> <p align=center> Ziegen Zustand:");
		panel.add(ZiegeZuSt);
		ZiegeZuSt.setBounds(255, 200, 185, 20);
		ZiegeZuSt.setValue(ZiegenGesund);
		ZiegeZuSt.setMinimum(0);
		ZiegeZuSt.setMaximum(100);
		ZiegeZuSt.setStringPainted(true);
		ZiegeZuSt.setForeground(Color.green);
		ZiegeZuSt.setToolTipText("<html> Der Gesundheitszustand deiner Ziegen <br>"
							   + "nimmt ab wenn sie kein Futter bekommen. <br>"
							   + "!!! Die Ziegen geben dann weniger Milch !!!");
		panel.add(Milch);
		Milch.setBounds(255, 220, 235, 100);
		Milch.setFont(Schrift2);
		panel.add(Pause);
		Pause.setBounds(255, 320, 20, 20);
		Pause.addActionListener(this);
		Pause.setToolTipText("Pause");
		panel.add(Weiter);
		Weiter.addActionListener(this);
		Weiter.setToolTipText("Weiter");
		Weiter.setBounds(280, 320, 20, 20);
		panel.add(PauseLbl);
		PauseLbl.setBounds(310, 300, 120, 60);
		PauseLbl.setText("Spiel pausiert");
		PauseLbl.setFont(Schrift3);
		PauseLbl.setForeground(Color.red);
		PauseLbl.setVisible(false);
//---------------------------------------------------------------------------------------
		panel.add(LandButt);
		LandButt.setBounds(20, 40, 50, 50);
		LandButt.setBorder(null);
		LandButt.setFont(Schrift);
		LandButt.addActionListener(this);
		LandButt.setRolloverIcon(KaufBild);
		LandButt.setToolTipText("<html>Land Kaufen:<br>"
							  + "Jedes Land hat Platz für 3 Gebäude<html>");
		panel.add(LandLab);
		LandLab.setBounds(75, 40, 150, 25);
		LandLab.setText("<html>Kosten: " + LandKosten + " €<br>" +
						"Besitz: " + LandBesitz + "<html>");
//---------------------------------------------------------------------------------------
		panel.add(SiloButt);
		SiloButt.setBounds(20, 100, 50, 50);
		SiloButt.setBorder(null);
		SiloButt.setFont(Schrift);
		SiloButt.addActionListener(this);
		SiloButt.setRolloverIcon(KaufBild);
		panel.add(SiloLab);
		SiloLab.setBounds(75, 100, 150, 25);
		SiloLab.setText("<html>Kosten: " + SiloKosten + " €<br>" +
						"Besitz: " + SiloBesitz + "<html>");
		panel.add(SiloLvlButt);
		SiloLvlButt.addActionListener(this);
		SiloLvlButt.setBounds(75, 130, 20, 20);
//---------------------------------------------------------------------------------------
		panel.add(StallButt);
		StallButt.setBounds(20, 160, 50, 50);
		StallButt.setBorder(null);
		StallButt.setFont(Schrift);
		StallButt.addActionListener(this);
		StallButt.setRolloverIcon(KaufBild);
		panel.add(StallLab);
		StallLab.setBounds(75, 160, 150, 25);
		StallLab.setText("<html>Kosten: " + StallKosten + " €<br>"
						+ "Besitz: " + StallBesitz + "<html>");
		panel.add(StallLvlButt);
		StallLvlButt.addActionListener(this);
		StallLvlButt.setBounds(75, 190, 20, 20);
//---------------------------------------------------------------------------------------
		panel.add(ZiegeButt);
		ZiegeButt.setBounds(20, 220, 50, 50);
		ZiegeButt.setBorder(null);
		ZiegeButt.setFont(Schrift);
		ZiegeButt.addActionListener(this);
		ZiegeButt.setRolloverIcon(KaufBild);
		panel.add(ZiegeLab);
		ZiegeLab.setBounds(75, 220, 150, 25);
		ZiegeLab.setText("<html>Kosten: " + ZiegeKosten + " €<br>" +
						"Besitz: " + ZiegeBesitz + "<html>");
		panel.add(ZiegeLvlButt);
		ZiegeLvlButt.addActionListener(this);
		ZiegeLvlButt.setBounds(75, 250, 20, 20);
		panel.add(ZiegeLvlButt2);
		ZiegeLvlButt2.addActionListener(this);
		ZiegeLvlButt2.setBounds(97, 250, 20, 20);
//---------------------------------------------------------------------------------------
		panel.add(FutterLbl);
		panel.add(Futter1);
		panel.add(Futter10);
		panel.add(Futter100);
		panel.add(Futter1000);
		FutterLbl.setBounds(20, 290, 90, 20);
		FutterLbl.setText("Futter Verkauf:");
		Futter1.setBounds(115, 290, 60, 25);
		Futter10.setBounds(180, 290, 60, 25);
		Futter100.setBounds(115, 320, 60, 25);
		Futter1000.setBounds(180, 320, 60, 25);
		Futter1.addActionListener(this);
		Futter10.addActionListener(this);
		Futter100.addActionListener(this);
		Futter1000.addActionListener(this);
		Futter1.setToolTipText("Kostet 0,20 €");
		Futter10.setToolTipText("Kostet 1,90 €");
		Futter100.setToolTipText("Kostet 17,50 €");
		Futter1000.setToolTipText("Kostet 149,99 €");

//---------------------------------------------------------------------------------------
		ToolTipAkt();
		frame.add(panel);
		frame.setVisible(true);
		Hirn.start();
	}
	
	//***
	//Methoden
	//***
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == LandButt){
			System.out.println("Land");
			RechLand();
		}
		if (e.getSource() == SiloButt){
			System.out.println("Silo");
			RechSilo();
		}
		if (e.getSource() == StallButt){
			System.out.println("Stall");
			RechStall();
		}
		if (e.getSource() == ZiegeButt){
			System.out.println("Ziege");
			RechZiege();
		}
		if (e.getSource() == Hirn){
			Berechne();
		}
		if (e.getSource() == SiloLvlButt){
			RechSiloLvl();
		}
		if (e.getSource() == StallLvlButt){
			RechStallLvl();
		}
		if (e.getSource() == ZiegeLvlButt){
			RechZiegeLvl();
		}
		if (e.getSource() == ZiegeLvlButt2){
			RechZiegeLvl2();
		}
		if (e.getSource() == Futter1){
			RechFutter(1,0.2);
		}
		if (e.getSource() == Futter10){
			RechFutter(10,1.9);
		}
		if (e.getSource() == Futter100){
			RechFutter(100,17.5);
		}
		if (e.getSource() == Futter1000){
			RechFutter(1000,149.99);
		}
		if (e.getSource() == Pause & PauseLbl.isVisible() == false){
			ButtDeakt();
			Hirn.stop();
			PauseLbl.setVisible(true);
		}
		if (e.getSource() == Weiter & PauseLbl.isVisible() == true){
			ButtAkt();
			Hirn.start();
			panel.setEnabled(true);
			PauseLbl.setVisible(false);
		}
	}
	
	public void RechLand(){
		if (Konto.getGesamtGeld() >= LandKosten){
			Konto.setGesamtGeldMinus(LandKosten);
			LandBesitz++;
			LandKosten += (75 +  LandBesitz * 3 * Jahr);
			BauPlatzFrei += 3;
			ToolTipAkt();
			KontoAkt();
		}
		else {
			KeinZeug();
		}
		
	}
	public void RechSilo(){
		if (Konto.getGesamtGeld() >= SiloKosten && BauPlatzFrei > 0){
			Konto.setGesamtGeldMinus(SiloKosten);
			BauPlatzFrei--;
			SiloBesitz++;
			SiloKosten += (50 + SiloBesitz * 2 * Jahr);
			FutterPlatzFrei = (SiloBesitz * (50 + SiloLvl * 20));
			if (ErstesSilo == true){
				Futter = 50;
				ErstesSilo = false;
			}
			ToolTipAkt();
			KontoAkt();
		}
		else {
			KeinZeug();
		}
	}	
	public void RechStall(){
		if (Konto.getGesamtGeld() >= StallKosten && BauPlatzFrei > 0){
			Konto.setGesamtGeldMinus(StallKosten);
			BauPlatzFrei--;
			StallBesitz++;
			StallKosten += (50 + StallBesitz * 2 * Jahr);
			StallPlatzFrei = ((StallBesitz * (4 + StallLvl)) - ZiegeBesitz);
			ToolTipAkt();
			KontoAkt();
		}
		else {
			KeinZeug();
		}
	}	
	public void RechZiege(){
		if (Konto.getGesamtGeld() >= ZiegeKosten && StallPlatzFrei > 0){
			Konto.setGesamtGeldMinus(ZiegeKosten);
			StallPlatzFrei--;
			ZiegeBesitz++;
			ZiegeKosten += (15 + ZiegeBesitz * Jahr) ;
			MilchPruefung();
			ToolTipAkt();
			KontoAkt();
		}
		else {
			KeinZeug();
		}
	}
	public void RechSiloLvl(){
		if (Konto.getGesamtGeld() >= SiloLvlKosten){
			Konto.setGesamtGeldMinus(SiloLvlKosten);
			SiloLvl++;
			SiloLvlKosten += 200*SiloLvl;
			FutterPlatzFrei = (SiloBesitz * (50 + SiloLvl * 20));
			ToolTipAkt();
			KontoAkt();
		}
		else {
			KeinZeug();
		}
		
	}
	public void RechStallLvl(){
		if (Konto.getGesamtGeld() >= StallLvlKosten){
			Konto.setGesamtGeldMinus(StallLvlKosten);
			StallLvl++;
			StallLvlKosten += 500*StallLvl;
			StallPlatzFrei = ((StallBesitz * (4 + StallLvl)) - ZiegeBesitz);
			ToolTipAkt();
			KontoAkt();
		}
		else {
			KeinZeug();
		}
	}
	public void RechZiegeLvl(){
		if (Konto.getGesamtGeld() >= ZiegeLvlKosten){
			Konto.setGesamtGeldMinus(ZiegeLvlKosten);
			ZiegeLvl++;
			ZiegeLvlKosten += 1150*ZiegeLvl;
			MilchPruefung();
			ToolTipAkt();
			KontoAkt();
		}
		else {
			KeinZeug();
		}
	}
	public void RechZiegeLvl2(){
		if (Konto.getGesamtGeld() >= ZiegeLvlKosten2){
			Konto.setGesamtGeldMinus(ZiegeLvlKosten2);
			ZiegeLvl2++;
			ZiegeLvlKosten2 += 1150*ZiegeLvl2;
			MilchPruefung();
			ToolTipAkt();
			KontoAkt();
		}
		else {
			KeinZeug();
		}
	}
	public void RechFutter(int Futt,double Preis){
		if (Konto.getGesamtGeld() >= Preis && SiloBesitz > 0){
			FutterKauf += Preis;
			System.out.println(Preis);
			Konto.setGesamtGeldMinus(Preis);
			Futter += Futt;
			if (Futter > FutterPlatzFrei){
				Futter = FutterPlatzFrei;
			}
			ToolTipAkt();
			KontoAkt();
		}
		else if (Konto.getGesamtGeld() >= Preis && SiloBesitz == 0){
			JOptionPane.showMessageDialog(null, "Kauf dir erst mal ein Silo!");
		}
		else{
			KeinZeug();
		}
	}
	
	public void KeinZeug(){
		Hirn.stop();
		JOptionPane.showMessageDialog(null,"Nicht Genug Geld, Land oder Platz im Stall! \nDenk nochmal nach! ;("
									,"Nicht genug Geld!",JOptionPane.WARNING_MESSAGE);
		Hirn.start();
	}
	public void KontoAkt(){
		GesamtGeld.setText("Vermögen:                                           " + GeldF.format(Konto.getGesamtGeld()));
		GeldProRunde.setText("Gewinn pro Runde:                                 " + GeldF.format(Konto.getGeldProRunde()));
	}
	public void ToolTipAkt(){
		SiloButt.setToolTipText("<html>Ein Silo Kaufen<br>"
				  + "Jedes Silo hat Platz für " + (SiloLvl*20+50) + " Futter<html>");
		
		SiloLvlButt.setToolTipText("<html>Silo's aufwerten:<br>"
				 + "Aktueller Level: " + SiloLvl + "<br>"
				 + "Preis: " + SiloLvlKosten + " €<br>"
				 + "Jedes deiner Silos bekommt +20 auf Platz für Futter<html>");
		
		StallButt.setToolTipText("<html>Einen Stall Kaufen:<br>"
				   + "Jeder Stall hat Platz für " + (StallLvl + 4) + " Ziegen<html>");
		
		StallLvlButt.setToolTipText("<html>Ställe aufwerten:<br>"
				  + "Aktueller Level: " + StallLvl + "<br>"
				  + "Preis: " + StallLvlKosten + " €<br>"
				  + "Jeder Stall bekommt +1 auf Platz für Ziegen<html>");
		
		ZiegeButt.setToolTipText("<html>Eine Ziege Kaufen mähähähä<br>"
				   + "Für Milch usw.<br>"
				   + "Eine Ziege gibt " + (ZiegeLvl + 5)+" Liter Milch pro Tag<html>");
		
		ZiegeLvlButt.setToolTipText("<html>Ziegen aufwerten(Quantität):<br>"
				  + "Aktueller Level: " + ZiegeLvl + "<br>"
				  + "Preis: " + ZiegeLvlKosten + " €<br>"
				  + "Jede Ziege gibt +1 Liter Milch mehr am Tag<html>");
		
		ZiegeLvlButt2.setToolTipText("<html>Ziegen aufwerten(Qualität):<br>"
				  + "Aktueller Level: " + ZiegeLvl2 + "<br>"
				  + "Preis: " + ZiegeLvlKosten2 + " €<br>"
				  + "Die Milch der Ziegen kann 20 Cent teurer verkauft werden<html>");
		
		LandLab.setText("<html>Kosten: " + LandKosten + " €<br>" +
				"Besitz: " + LandBesitz + "<html>");
		
		SiloLab.setText("<html>Kosten: " + SiloKosten + " €<br>" +
				"Besitz: " + SiloBesitz + "<html>");
		
		ZiegeLab.setText("<html>Kosten: " + ZiegeKosten + " €<br>" +
				"Besitz: " + ZiegeBesitz + "<html>");
		
		StallLab.setText("<html>Kosten: " + StallKosten + " €<br>" +
				"Besitz: " + StallBesitz + "<html>");
		
		BauPlatz.setText("Bau Plätze Frei:   " + BauPlatzFrei);
		
		StallPlatz.setText("Stallplätze Frei:   " + StallPlatzFrei);
		
		FutterPlatz.setText("<html>Silo Füllstand: <br>"
						  + "<p align=center>" +  Futter + "          /          " + FutterPlatzFrei + "<html>");
		
		FutterBar.setMaximum(FutterPlatzFrei);
		FutterBar.setValue(Futter);
		
		Milch.setText("<html>Milch Verkaufsdaten: <br>"
					+ "Milch/Ziege: " + LiterF.format(MilchProdPZ) + "<br>"
					+ "Milch Gesamt: " + LiterF.format(MilchProdGes) + "<br>"
					+ "Milch Wert/Liter: " + GeldF.format(MilchWert));
		GeldGeld();

	}
	public void Datum(){
		boolean neuesJahr = false;
		Tag++;
		Runde++;
		if (Tag > 30){
			Monat++;
			Tag = 1;
		}
		if (Monat > 12){
			Jahr++;
			Monat = 1;
			neuesJahr = true;
		}
		Datum.setText("<html>      Spielzeit: <br>"
				+ "Jahre " + Jahr + "|  Monat " + Monat + "| Tag " + Tag + "<html>");
		if (neuesJahr){
			JahresAbrechnung();
		}
	}
	public void FutterPruefung(){
		Futter = Futter - ZiegeBesitz;
		if (Futter <= 0){
			Futter = 0;
			if (ZiegeBesitz > 0 && EinmalKeinFutter == true){
			ZiegenGesund -= 10;
			}
			EinmalKeinFutter = true;
		}
		else{
			if (ZiegenGesund < 100){
				ZiegenGesund++;
			}
			EinmalKeinFutter = false;
		}
		
		if (ZiegenGesund < 0){
			ZiegenGesund = 0;
		}
		if (ZiegenGesund > 100){
			ZiegenGesund = 100;
		}
		if (ZiegenGesund >= 80){
					ZiegeZuSt.setForeground(Color.green);
		}
		if (ZiegenGesund < 80 && ZiegenGesund >= 35){
			ZiegeZuSt.setForeground(Color.yellow);
		}
		if (ZiegenGesund < 35){
			ZiegeZuSt.setForeground(Color.red);
		}
		ZiegeZuSt.setValue(ZiegenGesund);
	}
	
	public void MilchPruefung(){
		double MWert1 = 5 + ZiegeLvl;
		MWert1 /= 100;
		double MWert2 = 100 - ZiegenGesund;
		double MilchStrafe = MWert1 * MWert2;
		MilchProdPZ = ((double)(5 + ZiegeLvl) - MilchStrafe);
		MilchProdGes = MilchProdPZ * ZiegeBesitz;
		MilchWert = (0.5 + (double)ZiegeLvl2 * 0.2);
	}
	
	public void GeldGeld(){
		double Zaster = MilchProdGes * MilchWert;
		Konto.setGeldProRunde(Zaster);
	}
	public void JahresAbrechnung(){
		Hirn.stop();
		JOptionPane.showMessageDialog(null, "<html>Jahr: " + Jahr + " beendet!<br><br>"
										  + "Übersicht:<br>"
										  + " - Du hast dieses Jahr insgesamt " + LiterF.format(MilchGesVerk) + " Milch verkauft<br>"
										  + " - damit hast du " + GeldF.format(GesGewinn) + " verdient<br>"
										  + " - und hast insgesamt " + GeldF.format(FutterKauf) + " für Futter ausgegeben<br><br>"
										  + " daraus ergibt sich ein Gesamtgewinn von + " + GeldF.format(GesGewinn - FutterKauf) + "<html>");
		MilchGesVerk = 0;
		GesGewinn = 0;
		FutterKauf = 0;
		Hirn.start();
	}
	
	public void ButtDeakt(){
		LandButt.setEnabled(false);
		StallButt.setEnabled(false);
		SiloButt.setEnabled(false);
		ZiegeButt.setEnabled(false);
		ZiegeLvlButt.setEnabled(false);
		ZiegeLvlButt2.setEnabled(false);
		StallLvlButt.setEnabled(false);
		SiloLvlButt.setEnabled(false);
		Futter1.setEnabled(false);
		Futter10.setEnabled(false);
		Futter100.setEnabled(false);
		Futter1000.setEnabled(false);
	}
	
	public void ButtAkt(){
		LandButt.setEnabled(true);
		StallButt.setEnabled(true);
		SiloButt.setEnabled(true);
		ZiegeButt.setEnabled(true);
		ZiegeLvlButt.setEnabled(true);
		ZiegeLvlButt2.setEnabled(true);
		StallLvlButt.setEnabled(true);
		SiloLvlButt.setEnabled(true);
		Futter1.setEnabled(true);
		Futter10.setEnabled(true);
		Futter100.setEnabled(true);
		Futter1000.setEnabled(true);
	}
	
	public void Berechne(){
		System.out.println("Timer");
		Datum();
		FutterPruefung();
		MilchPruefung();
		GeldGeld();
		Konto.setGesamtGeldPlus(Konto.getGeldProRunde());
		ToolTipAkt();
		KontoAkt();
		MilchGesVerk += MilchProdGes;
		GesGewinn += Konto.getGeldProRunde();
		if (Konto.getGesamtGeld() >= 1000000){
			JOptionPane.showMessageDialog(null, "<html>GLÜCKWUNSCH du hast das Spiel in " + Runde + " Runden geschafft!!!");
			System.exit(0);
		}
		Runde++;
	}
	
}







