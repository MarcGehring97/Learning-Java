
public class PositiveNegativeTest extends FunctionalTest {
	
	public PositiveNegativeTest() {
		super("PositiveNegative Test");
	}

	@Override
	public TestResult runTest(Program p) {
		int x=-2;
		int y=5;
		int r=p.calculate(x, y);
		boolean error= (r!=-10);
		x=5;
		y=-2;
		r=p.calculate(x, y);
		error= error || (r!=-10);
		return new TestResult(error,"Error when multiplying a negative and positive number");
	}

}
