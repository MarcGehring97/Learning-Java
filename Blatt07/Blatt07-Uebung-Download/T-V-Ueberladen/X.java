public class X {
    public int a = 23;

    public X(int a) {                              // Signatur: X(I)
        this.a = a;
    }

    public X(float x) {                            // Signatur: X(F)
        this((int) (x + 1));
    }

    public void f(int  i, X o) { }                 // Signatur: X.f(IX)
    public void f(long lo, Y o) { }                // Signatur: X.f(LY)
    public void f(long lo, X o) { }                // Signatur: X.f(LX)
}
