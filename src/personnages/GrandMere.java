package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	Random random = new Random();

	private enum TypeHumain {
		COMMERCANT("un commerçant"), RONIN("un ronin"), YAKUZA("un yakuza"), SAMOURAI("un samouraï"),
		GRANDMERE("une grand-mère"), HABITANT("Habitant");

		private final String nom;

		private TypeHumain(String nom) {
			this.nom = nom;
		}

		@Override
		public String toString() {
			return nom;
		}
	}

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}

	@Override
	public void memoriser(Humain autreHumain) {
		if (this.nbConnaissance < 5) {
			super.memoriser(autreHumain);
		} else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}

	}

	private String humainHasard() {
		TypeHumain[] types = TypeHumain.values();
		return types[random.nextInt(types.length)].toString();
	}

	public void ragoter() {
		for (int i = 0; i < nbConnaissance; i++) {
			String nom = memoire[i].getNom();
			if (memoire[i] instanceof Traitre) {
				parler("Je sais que " + nom + " est un traître. Petit chenapan!");
			} else {
				parler("Je crois que " + nom + " est " + humainHasard());
			}
		}
	}

}
