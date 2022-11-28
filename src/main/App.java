package main;

import entities.*;

public class App {

	public static void main(String[] args) {
		System.out.println("Bienvenue sur Javaquarium !");
		
		Aquarium javaquarium = new Aquarium("Javaquarium");
		
		for (int i = 0; i < 100; i++) 
			javaquarium.ajouterAlgue(new Algue(10));
		
		javaquarium.ajouterPoisson(new Carnivor("Pierre", true, 1));
		javaquarium.ajouterPoisson(new Carnivor("Paul", true, 2));
		javaquarium.ajouterPoisson(new Carnivor("Jacques", true, 3));
		javaquarium.ajouterPoisson(new Carnivor("Anthony", false, 1));
		javaquarium.ajouterPoisson(new Carnivor("Cl�ment", false, 2));
		javaquarium.ajouterPoisson(new Carnivor("Hugo", false, 3));
		javaquarium.ajouterPoisson(new Carnivor("Lomig", true, 1));
		javaquarium.ajouterPoisson(new Carnivor("Lucas", true, 2));
		javaquarium.ajouterPoisson(new Carnivor("David", true, 3));
		javaquarium.ajouterPoisson(new Carnivor("Nicolas", false, 1));
		javaquarium.ajouterPoisson(new Carnivor("Benjamin", false, 2));
		javaquarium.ajouterPoisson(new Carnivor("Fabrice", false, 3));
		
		javaquarium.ajouterPoisson(new Herbivor("Lea", true, 1));
		javaquarium.ajouterPoisson(new Herbivor("Manon", true, 2));
		javaquarium.ajouterPoisson(new Herbivor("Juliette", true, 3));
		javaquarium.ajouterPoisson(new Herbivor("Melanie", false, 1));
		javaquarium.ajouterPoisson(new Herbivor("Sol�ne", false, 2));
		javaquarium.ajouterPoisson(new Herbivor("Androphine", false, 3));
		javaquarium.ajouterPoisson(new Herbivor("Andrea", true, 1));
		javaquarium.ajouterPoisson(new Herbivor("Louna", true, 2));
		javaquarium.ajouterPoisson(new Herbivor("Anette", true, 3));
		javaquarium.ajouterPoisson(new Herbivor("Rose", false, 1));
		javaquarium.ajouterPoisson(new Herbivor("Chloe", false, 2));
		javaquarium.ajouterPoisson(new Herbivor("Clara", false, 3));
		
		javaquarium.passerTour(100);
		
		
	}

}
