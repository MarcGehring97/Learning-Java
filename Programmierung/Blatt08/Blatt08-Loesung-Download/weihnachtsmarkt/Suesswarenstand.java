public class Suesswarenstand extends Lebensmittelstand<Suessware>
		implements Verschiebbar {
	public Suesswarenstand() {
		super(new Suessware());
	}

	@Override
	public void verschiebe(int standID) {
		this.berechneBesucherProStunde();
		System.out.println(
				"Stand " + standID + " wurde verschoben und wird jetzt von "
						+ getBesucherProStunde()
						+ " Passanten*innen pro Stunde besucht.");
	}
}
