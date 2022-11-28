package entities;

import java.util.*;

abstract public class Poisson {
	private String nom;
	private Boolean male;
	private int pv;
	private Boolean dead;
	private int age;
	
	public Poisson(String nom, Boolean male) {
		this.nom = nom;
		this.male = male;
		dead = false;
		pv = 10;
		age = 0;
	}
	
	public void affich() {
		System.out.println("Nom : " + nom + " | Sexe : " + (male ? "Mâle" : "Femelle") + " | Mort : " + dead + " | PV : " + pv);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Boolean isDead() {
		return dead;
	}
	
	public int getVie() {
		return pv;
	}
	public void die() {
		System.out.println(this.nom + " est mort...");
		dead = true;
	}
	
	public void perdrePv(int degats) {
		pv -= degats;
		if (pv <= 0) die();
	}
	
	public void gagnerVie(int vie) {
		pv += vie;
	}
	
	public void manger(ArrayList<Algue> tAlgue) {
		if (tAlgue.size() <= 0) return;
		Random r = new Random();
		int n = -1;
		Algue a;
		n = r.nextInt(tAlgue.size());
		a = tAlgue.get(n);
		System.out.println(this.nom + " manger une algue.");
		a.perdrePv(2);
		this.gagnerVie(3);
	}
	
	public void vieillir() {
		if (isDead()) return;
		age++;
		perdrePv(1);
		if (age >= 20) die();
	}
	
	public Boolean isMale() {
		return male;
	}
	
	public Boolean seReproduit() {
		return getVie() > 5;
		
	}
}
