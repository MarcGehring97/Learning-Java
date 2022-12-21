public class Lebensmittelstand<T extends Lebensmittel> extends Stand {
	private final T lebensmittel;

	public Lebensmittelstand(T lebensmittel) {
		this.lebensmittel = lebensmittel;
		this.berechneBesucherProStunde();
	}

	@Override
	public double einzelkauf() {
		int menge = SimpleIO.getInt("Wie viel Gramm moechten Sie?");
		System.out.println("Wie viel Gramm moechten Sie?");
		System.out.println(menge);
		System.out.println(
				menge + " Gramm fuer Sie. Lassen Sie es sich schmecken!");
		return menge / 100.0 * lebensmittel.getPreisPro100g();
	}

	@Override
	public String toString() {
		return "Lebensmittelstand fuer " + lebensmittel.getName() + ":"
				+ System.lineSeparator()
				+ "Preis pro 100g: " + lebensmittel.getPreisPro100g()
				+ " Euro"
				+ System.lineSeparator() + super.toString();
	}
}
