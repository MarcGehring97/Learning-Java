public class Y extends X {
    public float a = 42;

    public Y(double a) {                           // Signatur: Y(D)
        this((float) (a - 1));
    }

    public Y(float a) {                            // Signatur: Y(F)
        super(a);
        this.a = a;
    }

    public void f(int i, X o) { }                  // Signatur: Y.f(IX)
    public void f(int i, Y o) { }                  // Signatur: Y.f(IY)
    public void f(long lo, X o) { }                // Signatur: Y.f(LX)
}
