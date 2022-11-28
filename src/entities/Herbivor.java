package entities;

public class Herbivor extends Poisson {
	String[] races = {"Sol","Bar","Carpe"};
	String race;

	public Herbivor(String nom, Boolean male, int noRace) {
		super(nom, male);
		this.race = races[noRace - 1];
	}
	
	public String getRace() {
		return this.race;
	}
}
