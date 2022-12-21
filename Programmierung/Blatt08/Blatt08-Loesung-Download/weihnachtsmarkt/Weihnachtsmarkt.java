public class Weihnachtsmarkt {
	private final Stand[] staende;

	public static void main(String[] args) {
		new Weihnachtsmarkt(5).run();
	}

	public Weihnachtsmarkt(int anzahlStaende) {
		this.staende = new Stand[anzahlStaende];
		for (int i = 0; i < this.staende.length; i++) {
			staende[i] = switch (Zufall.zahl(3)) {
			case 0 -> new Weihnachtsartikelstand();
			case 1 -> new Suesswarenstand();
			default -> new Lebensmittelstand<>(new Flammkuchen());
			};
		}
	}

	public void run() {
		do {
			praesentiereStaende();
			besucheStand(staende[waehleStand()]);
			verschiebeSchlechtBesuchteStaende();
		} while (!entscheideWeihnachtsmarktVerlassen());
	}

	private void praesentiereStaende() {
		System.out.println(
				"Der Weihnachtsmarkt besteht aus folgenden Staenden:");
		System.out.println();
		for (int i = 0; i < staende.length; i++) {
			System.out.println(i + ": " + staende[i].toString());
		}
	}

	private int waehleStand() {
		int besuchsstand = SimpleIO
				.getInt("Welchen Stand moechten Sie besuchen?");
		System.out.println("Welchen Stand moechten Sie besuchen?");
		System.out.println(besuchsstand);
		return besuchsstand;
	}

	private void besucheStand(Stand stand) {
		System.out.println("Guten Tag!");
		double preis = 0;
		do {
			preis += stand.einzelkauf();
		} while (!entscheideStandVerlassen());
		System.out.println(preis + " Euro, bitte.");
	}

	private boolean entscheideStandVerlassen() {
		boolean result = SimpleIO.getBoolean("Darf es sonst noch etwas sein?");
		System.out.println("Darf es sonst noch etwas sein?");
		System.out.println(result);
		return !result;
	}

	private void verschiebeSchlechtBesuchteStaende() {
		for (int i = 0; i < staende.length; i++) {
			if (staende[i] instanceof Verschiebbar) {
				if (staende[i].getBesucherProStunde() < 30) {
					try {
						((Verschiebbar) staende[i]).verschiebe(i);
					} catch (SchadensfallException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}

	private boolean entscheideWeihnachtsmarktVerlassen() {
		boolean result = SimpleIO
				.getBoolean("Moechten Sie den Weihnachtsmarkt verlassen?");
		System.out.println("Moechten Sie den Weihnachtsmarkt verlassen?");
		System.out.println(result);
		return result;
	}
}
