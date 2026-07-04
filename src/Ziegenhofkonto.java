
public class Ziegenhofkonto {
	//***
	//Variablen
	//***
	private double GesamtGeld = 0;
	private double GeldProRunde = 0;
	
	
	
	
	
	
	//***
	//Constructoren
	//***
	public Ziegenhofkonto(){
		GesamtGeld = 500;
	}
	
	
	
	
	
	
	//***
	//Methoden
	//***
	public double getGesamtGeld(){
		return this.GesamtGeld;
	}
	public double getGeldProRunde(){
		return this.GeldProRunde;
	}
	public void setGesamtGeldPlus(double wert){
		this.GesamtGeld += wert;
		System.out.println("+"+wert);
	}
	public void setGesamtGeldMinus(double wert){
		this.GesamtGeld -= wert;
		System.out.println("-"+wert);
}
	public void setGeldProRunde(double wert){
		this.GeldProRunde = wert;
		}
	}
