package personnages;

public class Humain {

	private String nom;
	private String boisson;
	private int argent;

	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void gagnerArgent(int gain) {
		argent += gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}

	public void direBonjour() {
		String phrase = "Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boisson + ".";
		parler(phrase);
	}

	public void boire() {
		String phrase = "Mmmm, un bon verre de " + boisson + " ! GLOUPS !";
		parler(phrase);
	}

	public void acheter(String bien, int prix) {
		String phrase;
		if (argent >= prix) {
			phrase = "J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.";
			perdreArgent(prix);
		} else {
			phrase = "Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à "
					+ prix + " sous.";
		}
		parler(phrase);
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

}