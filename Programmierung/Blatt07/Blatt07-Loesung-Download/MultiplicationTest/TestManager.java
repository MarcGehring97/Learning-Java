public class TestManager {

    public static void main(String[] args) {
        Program[] programs = {new Multiply1(), new Multiply2(), new Multiply3(),
                new Multiply4(), new Multiply5()};
        Test t1 = new NullTest();
        Test t2 = new PositiveNegativeTest();
        Test t3 = new PositiveTest();
        Test t4 = new NegativeTest();
        Test t5 = new PerformanceTest("Small numbers", 10, 9);
        Test t6 = new PerformanceTest("Big numbers", 4324324, 3132);
        Test[] tests = {t1, t2, t3, t4, t5, t6};
        runTests(programs, tests);
    }

    public static void runTests(Program[] ps, Test[] tests) {
        for (Program p : ps) {
            System.out.println("Run tests on program: " + p.getName());
            for (Test t : tests) {
                System.out.print("\t");
                TestResult res = t.runTest(p);
                if (t instanceof PerformanceTest pt) {
                    int[] input = pt.getInput();
                    System.out.println("Executed performance test: " + pt.getName()
                            + " with inputs " + input[0]
                            + " " + input[1] + " and " + res.message());
                } else { //Tests is sealed, so this will be a (Subclass of) FunctionalTest
                    if (res.error()) {
                        System.out.println(t.getName()
                                + " failed with message: " + res.message());
                    } else {
                        System.out.println(t.getName() + ": OK");
                    }

                }

            }
        }

    }

}


