public abstract class Stand {
	private final String verkaeufer;
	private int besucherProStunde;

	public Stand() {
		this.verkaeufer = Zufall.name();
		this.besucherProStunde = 0;
	}

	public int getBesucherProStunde() {
		return besucherProStunde;
	}

	public void berechneBesucherProStunde() {
		this.besucherProStunde = Zufall.zahl(101);
	}

	public void setBesucherProStunde(int besucherProStunde) {
		this.besucherProStunde = besucherProStunde;
	}

	public abstract double einzelkauf();

	public String toString() {
		return "Verkaeufer*in: " + this.verkaeufer + System.lineSeparator()
				+ "Besucher*innen pro Stunde: " + this.besucherProStunde
				+ System.lineSeparator();
	}
}
