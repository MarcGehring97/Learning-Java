//TODO a) Record-Klasse Pilz
public record Pilz (Pilzart art, boolean reif) {
  //TODO d) public static Pilz[] pilzlichtung()
  public static Pilz[] pilzlichtung() {
    Pilzart[] pilzarten = Pilzart.values();
    Pilz[] res = new Pilz[pilzarten.length];
    for (int i = 0; i < pilzarten.length; ++i) {
      res[i] = new Pilz(pilzarten[i], true);
    }
    return res;
  }

  //TODO e) public static int anzahlUnreif(Pilz[] pilze)
  public static int anzahlUnreif(Pilz[] pilze) {
    int anzahl_unreif = 0;
    for (Pilz pilz : pilze) {
        if (pilz == null || !pilz.reif())
            anzahl_unreif++;  
    }
    return anzahl_unreif;
  }
}