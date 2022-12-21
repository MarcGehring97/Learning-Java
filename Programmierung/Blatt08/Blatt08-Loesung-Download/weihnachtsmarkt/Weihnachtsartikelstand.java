public class Weihnachtsartikelstand extends Stand implements Verschiebbar {
	private Artikel[] artikel;

	public Weihnachtsartikelstand() {
		int anzahlArtikel = Zufall.zahl(20) + 1;
		this.artikel = new Artikel[anzahlArtikel];
		for (int i = 0; i < anzahlArtikel; i++) {
			this.artikel[i] = new Artikel();
		}
		this.berechneBesucherProStunde();
	}

	@Override
	public void berechneBesucherProStunde() {
		int result = 0;
		for (int i = 0; i < artikel.length; i++) {
			if (artikel[i] != null) {
				result += Zufall.zahl(6);
			}
		}
		this.setBesucherProStunde(result);
	}

	@Override
	public double einzelkauf() {
		praesentiereArtikel();
		return berechneArtikel(waehleArtikel());
	}

	private void praesentiereArtikel() {
		System.out.println("Unsere Artikel sind:");
		for (int i = 0; i < artikel.length; i++) {
			if (artikel[i] != null) {
				System.out.println(i + ": " + artikel[i].toString());
			} else {
				System.out.println(i + ": ausverkauft");
			}
		}
	}

	private int waehleArtikel() {
		int result = SimpleIO.getInt("Welchen Artikel moechten Sie kaufen?");
		System.out.println("Welchen Artikel moechten Sie kaufen?");
		System.out.println(result);
		return result;
	}

	private double berechneArtikel(int i) {
		if (i < artikel.length && artikel[i] != null) {
			System.out.println(artikel[i].getName()
					+ " wird eingepackt. Viel Spass damit!");
			double result = artikel[i].getPreis();
			artikel[i] = null;
			return result;
		} else {
			System.out.println("Diesen Artikel haben wir nicht!");
			return 0;
		}
	}

	@Override
	public void verschiebe(int standID) throws SchadensfallException {
		doVerschiebe(standID);
		schadensfall();
	}

	private void doVerschiebe(int standID) {
		this.berechneBesucherProStunde();
		System.out.println(
				"Stand " + standID + " wurde verschoben und wird jetzt von "
						+ getBesucherProStunde()
						+ " Passanten*innen pro Stunde besucht.");
	}

	private void schadensfall() throws SchadensfallException {
		int artikelIndex = Zufall.zahl(artikel.length);
		if (artikel[artikelIndex] != null) {
			String message = "Dabei ist Artikel " + artikelIndex + ": "
					+ artikel[artikelIndex].toString()
					+ " leider vom Stand gefallen und kaputt gegangen.";
			artikel[artikelIndex] = null;
			throw new SchadensfallException(message);
		}
	}

	@Override
	public String toString() {
		return "Weihnachtsartikelstand:" + System.lineSeparator()
				+ super.toString();
	}
}
