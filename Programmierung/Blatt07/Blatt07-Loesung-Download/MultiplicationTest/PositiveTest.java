
public class PositiveTest extends FunctionalTest {
	
	public PositiveTest() {
		super("Positive Test");
	}

	@Override
	public TestResult runTest(Program p) {
		int x=4;
		int y=5;
		int r=p.calculate(x, y);
		boolean error= (r!=20);
		return new TestResult(error,"Error when multiplying positive numbers");
	}

}
