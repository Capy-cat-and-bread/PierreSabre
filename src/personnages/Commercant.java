package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	public int seFaireExtorquer() {
		int argentVole = argent;
		argent = 0;
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return argentVole;
	}

	public void recevoir(int argent) {
		this.argent += argent;
		String texte = argent + " sous! Je te remercie généreux donateur!";
		parler(texte);
	}
}
