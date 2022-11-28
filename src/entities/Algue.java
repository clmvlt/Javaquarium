package entities;

public class Algue {
	
	private int pv;
	private Boolean dead;
	private int age;
	
	public Algue(int pv) {
		this.pv = pv;
		dead = false;
		age = 0;
	}
	
	public void grandir(int vie) {
		pv += vie;
	}
	
	public void perdrePv(int degats) {
		pv -= degats;
		if (pv <= 0) die();
	}
	
	public int getVie() {
		return pv;
	}
	
	public Boolean isDead() {
		return dead;
	}
	
	public void die() {
		dead = true;
	}
	
	public Boolean seReproduit() {
		if (age >= 10) {
			perdrePv(pv/2);
			return true;
		}
		return false;
	}
	
	public void vieillir() {
		age++;
		grandir(1);
		if (age >= 20) die();
	}
}
