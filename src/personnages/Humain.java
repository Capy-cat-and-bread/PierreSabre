package personnages;

public class Humain {

	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissance = 0;
	private static int NB_CONNAISSANCE_MAX = 30;

	protected Humain[] memoire = new Humain[NB_CONNAISSANCE_MAX];

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
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
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}
	
	// parler directement

	private void repondre(Humain autreHumain) {
		direBonjour();
		memoriser(autreHumain);
	}

	protected void memoriser(Humain autreHumain) {
		if (nbConnaissance < NB_CONNAISSANCE_MAX) {
			memoire[nbConnaissance] = autreHumain;
			nbConnaissance++;
		} else {
			for (int i = 0; i < NB_CONNAISSANCE_MAX - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[NB_CONNAISSANCE_MAX - 1] = autreHumain;
		}
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		StringBuilder phrase = new StringBuilder();
		if (argent >= prix) {
			phrase.append("J'ai ");
			phrase.append(argent);
			phrase.append(" sous en poche. Je vais pouvoir m'offrir ");
			phrase.append(bien);
			phrase.append(" à ");
			phrase.append(prix);
			phrase.append(" sous.");
			perdreArgent(prix);
		} else {
			phrase.append("Je n'ai plus que ");
			phrase.append(argent);
			phrase.append(" sous en poche. Je ne peux même pas m'offrir ");
			phrase.append(bien);
			phrase.append(" à ");
			phrase.append(prix);
			phrase.append(" sous.");
		}
		parler(phrase.toString());
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}

	public void listerConnaissance() {
		StringBuilder texte = new StringBuilder("Je connais beaucoup de monde, dont : ");
		for (int i = 0; i < nbConnaissance; i++) {
			texte.append(memoire[i].getNom());
			if (i < nbConnaissance - 1) {
				texte.append(", ");
			}
		}
		parler(texte.toString());
	}

}