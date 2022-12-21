
public final class PerformanceTest extends Test {
    private final int x;
    private final int y;

    public int[] getInput() {
        return new int[] {x, y};
    }

    public PerformanceTest(String category, int inx, int iny) {
        super(category);
        x = inx;
        y = iny;
    }

    @Override
    public TestResult runTest(Program p) {
        long startTime = System.nanoTime();
        p.calculate(x, y);
        long estimatedTime = System.nanoTime() - startTime;
        String msg = "Time elapsed: " + estimatedTime;
        TestResult t = new TestResult(false, msg);
        return t;
    }

}
