package entities;

import java.util.*;

public class Aquarium {
	
	private ArrayList<Poisson> lesPoissons;
	private ArrayList<Algue> lesAlgues;
	private String nom;
	
	public Aquarium(String nom) {
		this.nom = nom;
		lesPoissons = new ArrayList<Poisson>();
		lesAlgues = new ArrayList<Algue>();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void ajouterAlgue(Algue a) {
		lesAlgues.add(a);
	}
	
	public void ajouterPoisson(Poisson p) {
		lesPoissons.add(p);
	}
	
	public void passerTour() {
		for (int i = 0; i < lesAlgues.size(); i++) {
			Algue a = lesAlgues.get(i);
			if (!a.isDead()) {
				a.vieillir();
				if (a.seReproduit())
					lesAlgues.add(new Algue(a.getVie()));
			}
		}
		
		for (int i = 0; i < lesPoissons.size(); i++) {
			Poisson p = lesPoissons.get(i);
			p.vieillir();
			if (!p.isDead()) {
				if (Carnivor.class.isInstance(p)) {
					((Carnivor)p).manger(lesPoissons, lesAlgues);
				} else {
					p.manger(lesAlgues);
				}
				if (p.seReproduit()) {
					Random r = new Random();
					int n;
					Poisson p2;
					do {
						n = r.nextInt(lesPoissons.size());
						p2 = lesPoissons.get(n);
					} while (p.equals(p2));
					
					if (p.getClass() == p2.getClass() && p.isMale() != p2.isMale()) {
						Boolean male = r.nextBoolean();
						n = r.nextInt(2) + 1;
						String nvnom = "";
						int fin = r.nextInt(3);
						nvnom += p.getNom().substring(0, fin);
						nvnom += p2.getNom().substring(fin, p2.getNom().length());
						if (p.getClass() == Carnivor.class) {
							if (((Carnivor)p).getRace() == ((Carnivor)p2).getRace())
								ajouterPoisson(new Carnivor(nvnom, male, n));
						} else {
							if (((Herbivor)p).getRace() == ((Herbivor)p2).getRace())
								ajouterPoisson(new Herbivor(nvnom, male, n));
						}
						
					}
				}
			}
		}
		for (int i = 0; i < lesAlgues.size(); i++)
			if (lesAlgues.get(i).isDead()) {
				lesAlgues.remove(i);
				i--;
			}
		
		for (int i = 0; i < lesPoissons.size(); i++)
			if (lesPoissons.get(i).isDead()) {
				lesPoissons.remove(i);
				i--;
			}
		
		System.out.println("Algues : " + lesAlgues.size());
		System.out.println("Poissons : " + lesPoissons.size());
	}
	
	public void passerTour(int nbTour) {
		for (int i = 0; i < nbTour; i++)
			passerTour();
	}
}
