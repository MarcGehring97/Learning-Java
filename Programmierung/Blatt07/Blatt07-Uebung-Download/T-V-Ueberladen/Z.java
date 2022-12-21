public class Z {
    public static void main(String [] args) {
                                                   // a)
        X xx1 = new X(42);                         // (1)
        System.out.println("X.a: " + xx1.a);
        X xx2 = new X(22.99f);                     // (2)
        System.out.println("X.a: " + xx2.a);
        X xy = new Y(7.5);                         // (3)
        System.out.println("X.a: " + ((X) xy).a);
        System.out.println("Y.a: " + ((Y) xy).a);
        Y yy = new Y(7);                           // (4)
        System.out.println("X.a: " + ((X) yy).a);
        System.out.println("Y.a: " + ((Y) yy).a);
                                                   // b)
        int i = 1;
        long lo = 2;
        xx1.f(i, xy);                              // (1)
        xx1.f(lo, xx1);                            // (2)
        xx1.f(lo, yy);                             // (3)
        yy.f(i, yy);                               // (4)
        yy.f(i, xy);                               // (5)
        yy.f(lo, yy);                              // (6)
        xy.f(i, xx1);                              // (7)
        xy.f(lo, yy);                              // (8)
        //xy.f(i, yy);                             // (9)
    }
}
