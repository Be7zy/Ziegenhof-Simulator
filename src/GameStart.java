import javax.swing.JOptionPane;

public class GameStart {

	public static void main(String[] args) {
		
		
		Zufallsname ZName = new Zufallsname();
		//SpielEinstellungen SEinst = new SpielEinstellungen();
		String Spieler = JOptionPane.showInputDialog(null, "Naaa, verräts du mir auch deinen Namen du kleiner Frechdachs?");
		JOptionPane.showMessageDialog(null, "<html> Info: <br>"
										  + "-   Beachte die Tool Tips<br>"
										  + "-   Beim ersten Silo gibts Gratis Futter<br>"
										  + "-   du brauchst Land für Gebäude<br>"
										  + "-   du brauchst Silos für Futter<br>"
										  + "-   du brauchst Ställe für deine Zie ie ie ie ie gen<br>"
										  + "-   wenn deine Ziegen kein Futter haben, geben sie nach und nach weniger Milch<br>"
										  + "-   Versuche in möglichst wenigen Runden Millionär zu werden<br><br>"
										  + "Viel Spaß!<html>");
		
		if (Spieler == null || Spieler.length() <= 2){
			@SuppressWarnings("unused")
			Ziegenhoffenster Spiel = new Ziegenhoffenster();
		}
		else{
			Spieler = ZName.ZufallName(Spieler);
			@SuppressWarnings("unused")
			Ziegenhoffenster Spiel = new Ziegenhoffenster(Spieler);
		}
		
	}
	
	

}
