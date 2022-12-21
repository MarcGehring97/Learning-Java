public class Artikel {
	private final String name = Zufall.artikel();
	private final double preis = (Zufall.zahl(1000) + 1) / 100.0;

	public String getName() {
		return this.name;
	}

	public double getPreis() {
		return this.preis;
	}

	@Override
	public String toString() {
		return this.name + " (" + this.preis + " Euro)";
	}
}
