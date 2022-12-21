public class Flammkuchen implements Lebensmittel {
	private final double preisPro100g = (Zufall.zahl(300) + 1) / 100.0;

	@Override
	public double getPreisPro100g() {
		return preisPro100g;
	}

	@Override
	public String getName() {
		return "Flammkuchen";
	}
}
