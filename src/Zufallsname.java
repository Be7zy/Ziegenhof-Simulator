
public class Zufallsname {
	
	public String ZufallName(String Spieler){
		String Namen[] = {"dummer ","schöner ","blöder ","dreckiger ","kleiner ","fetter ","verplanter ","ungezogener ","der nackte ","Profibauer "};
		int ZZahl = (int)(Math.round(Math.random()* Namen.length));
		if (ZZahl > Namen.length -1){
			ZZahl = Namen.length;
		}
		Spieler = Namen[ZZahl] + Spieler;
		return Spieler;
	}

}
