public record Karte (Farbe farbe, Wert wert) {

  public static int kombinationen() {
    return Farbe.values().length * Wert.values().length;
  }

  public static Karte[] skatblatt() {
    Karte[] res = new Karte[kombinationen()];
    int i = 0;
    for (Farbe f : Farbe.values()) {
      for (Wert w : Wert.values()) {
        res[i] = neueKarte(f,w);
        ++i;
      }
    }
    return res;
  }

  public static Karte neueKarte(Farbe f, Wert w) {
    Karte k = new Karte(f,w);
    return k;
  }

  public static Karte neueKarte(String farbstring, String wertstring) {
    Farbe farbe = Farbe.valueOf(farbstring);
    Wert wert = Wert.valueOf(wertstring);
    return Karte.neueKarte(farbe,wert);
  }

  public static void druckeDoppelBedienungen() {
    for (Karte k1 : skatblatt()) {
      for (Karte k2 : skatblatt()) {
        if (k1.bedient(k2) && k2.bedient(k1) && !k1.equals(k2)) {
          System.out.println(k1 + " bedient " + k2 + " und " +
                             k2 + " bedient " + k1 + ".");
        }
      }
    }
  }

  public boolean bedient(Karte other) {
    return (this.farbe == other.farbe || this.wert == other.wert
                                      || this.wert == Wert.BUBE);
  }

  public boolean bedienbar(Karte... kartenhand) {
    for (Karte k : kartenhand) {
      if (k.bedient(this)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString() {
    return (farbe.toString() + wert.toString());
  }
}