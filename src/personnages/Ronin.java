package personnages;

public class Ronin extends Humain {

	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	public void donner(Commercant beneficiaire) {
		int partADonner = this.getArgent() / 10;
		parler(beneficiaire.getNom() + " prend ces " + partADonner + " sous.");
		beneficiaire.recevoir(partADonner);
		perdreArgent(partADonner);
	}

	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int force = honneur * 2;
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu petit Yakuza!");
			int gains = adversaire.perdre();
			gagnerArgent(gains);
			honneur++;
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			int argentAPerdre = this.getArgent();
			perdreArgent(argentAPerdre);
			adversaire.gagner(argentAPerdre);
			honneur--;
		}
	}

}
