public class Main {
  public static void main(String[] args) {
    Pilz steinpilz1 = new Pilz(Pilzart.STEINPILZ, false);

    Pilz steinpilz2 = new Pilz(Pilzart.STEINPILZ, false);

    Pilz champignon = new Pilz(Pilzart.CHAMPIGNON, true);

    Pilz pfifferling = new Pilz(Pilzart.PFIFFERLING, false);

    Pilzsammler pettersson = new Pilzsammler();
    pettersson.name = "Pettersson";
    pettersson.korb = new Pilz[8];

    Pilzsammler findus = new Pilzsammler();
    findus.name = "Findus";
    findus.korb = new Pilz[7];
    
    steinpilz1 = new Pilz(Pilzart.STEINPILZ, true); 

    // TODO g)
    Pilz[] uebrigePilze = findus.sammlePilze(steinpilz1,steinpilz2,champignon,pfifferling);
    pettersson.sammlePilze(uebrigePilze);
    findus.ausgabe();
    pettersson.ausgabe();
    System.out.println("---");

    while (findus.hatPlatz() || pettersson.hatPlatz()) {
      Pilz[] neueLichtung = Pilz.pilzlichtung();
      uebrigePilze = findus.sammlePilze(neueLichtung);
      pettersson.sammlePilze(uebrigePilze);
      findus.ausgabe();
      pettersson.ausgabe();
      System.out.println("---");
    }
  }
}