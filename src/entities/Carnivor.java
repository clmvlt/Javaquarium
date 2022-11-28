package entities;

import java.util.*;

public class Carnivor extends Poisson {
	
	private String[] races = {"Mérou","Thon","Poisson-Clown"};
	private String race;

	public Carnivor(String nom, Boolean male, int noRace) {
		super(nom, male);
		this.race = races[noRace - 1];
	}
	
	public void manger(ArrayList<Poisson> tPoisson, ArrayList<Algue> tAlgue) {
		if (super.getVie() > 5) return;
		Random r = new Random();
		int n;
		Poisson p2;
		do {
			n = r.nextInt(tPoisson.size());
			p2 = tPoisson.get(n);
		} while (((Poisson)this).equals(p2));
		
		if (Carnivor.class.isInstance(p2)) {
			if (((Carnivor)p2).getRace() != this.race) {
				p2.perdrePv(4);
				this.gagnerVie(5);
			}
		} else {
			if (((Herbivor)p2).getRace() != this.race) {
				p2.perdrePv(4);
				this.gagnerVie(5);
			}
		}
		
		System.out.println(super.getNom() + " mange " + p2.getNom());
	}
	
	public String getRace() {
		return this.race;
	}
}
