public class Suessware implements Lebensmittel {
	private final double preisPro100g = (Zufall.zahl(300) + 1) / 100.0;
	private final String suesswarenart = Zufall.suessware();

	@Override
	public double getPreisPro100g() {
		return preisPro100g;
	}

	@Override
	public String getName() {
		return "Suessware (" + suesswarenart + ")";
	}
}
