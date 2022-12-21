
public abstract sealed class Test
		implements Identifiable permits PerformanceTest, FunctionalTest {
	private final String identifier;
	public abstract TestResult runTest(Program p);
	
	protected Test(String identifier) {
		this.identifier=identifier;
	}
	
	public String getName() {
		return identifier;
	}
}
