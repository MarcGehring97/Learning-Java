
public class NullTest extends FunctionalTest {
	
	public NullTest() {
		super("NullTest");
	}

	@Override
	public TestResult runTest(Program p) {
		int x=0;
		int y=5;
		int r=p.calculate(x, y);
		boolean error= (r!=0);
		x=5;
		y=0;
		r=p.calculate(x, y);
		error= error || (r!=0);
		return new TestResult(error, "Multiplying with 0 does not result in 0");
	}

}
