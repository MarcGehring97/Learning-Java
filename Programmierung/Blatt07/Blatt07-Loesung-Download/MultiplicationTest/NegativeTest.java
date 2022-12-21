
public class NegativeTest extends FunctionalTest {
	
	public NegativeTest() {
		super("Negative Test");
	}

	@Override
	public TestResult runTest(Program p) {
		int x=-1;
		int y=-5;
		int r=p.calculate(x, y);
		boolean error= (r!=5);
		return new TestResult(error,"Error when multiplying negative numbers");
	}

}
