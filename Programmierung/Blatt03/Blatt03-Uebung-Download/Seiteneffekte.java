public class HSeiteneffekte {
	public static void main(String[] args) {
		Wrapper[] ws = new Wrapper[3];
		ws[0] = new Wrapper();
		ws[0].value = 42;
		ws[1] = new Wrapper();
		ws[1].value = 43;
		ws[2] = new Wrapper();
		ws[2].value = 44;
		Wrapper w = ws[1];

		int[] is = { 45, 46, 47 };
		int i = is[1];

		bar(is, i, ws, w);

		// Speicherzustand hier zeichnen
	}

	public static void bar(int[] is, int i, Wrapper[] ws, Wrapper w) {
		// Speicherzustand hier zeichnen

		i = 48;
		i = is[0];
		i = 49;
		is[1] = 50;
		is[1] = is[2];
		is[1] = 51;

		w.value = 52;
		w = ws[0];
		w.value = 53;
		ws[1].value = 54;
		ws[1] = ws[2];
		ws[1].value = 55;

		// Speicherzustand hier zeichnen

		is = new int[1];
		is[0] = 56;
		i = is[0];
		i = 57;

		ws = new Wrapper[1];
		ws[0] = new Wrapper();
		w = ws[0];
		w.value = 58;

		// Speicherzustand hier zeichnen
	}
}

