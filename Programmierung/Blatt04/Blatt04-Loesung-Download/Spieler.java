public class Spieler {
  String name;
  Karte[] kartenhand;
  Karte gespielteKarte;


  public void spieleKarte(Karte k) {
    int pos = 0;
    while(pos < kartenhand.length && !kartenhand[pos].bedient(k)) {
        pos++;
    }

    if(pos == kartenhand.length) {
        gespielteKarte = null;
        return;
    }

    gespielteKarte = kartenhand[pos];
    System.out.println(this + " bedient " + k + " mit " + gespielteKarte);

    Karte[] res = new Karte[kartenhand.length - 1];
    for(int i = 0; i < kartenhand.length; i++) {
        if(i < pos)
            res[i] = kartenhand[i];
        else if (i > pos)
            res[i - 1] = kartenhand[i];
    }
    kartenhand = res;
  }
  
  public void spiele(Karte k) {
      do {
        spieleKarte(k);
        k = gespielteKarte;
      } while(gespielteKarte != null && kartenhand.length != 0);
      if(kartenhand.length == 0)
          System.out.println(this + " hat gewonnen!");
      else 
          System.out.println(this + " hat verloren!");
  }

  public String toString() {
    return name;
  }

  public static void main(String[] args) {
    Spieler s1 = new Spieler();
    s1.name = "Elisabeth";
    
    Karte k0 = Karte.neueKarte("HERZ","NEUN");
    Karte k1 = Karte.neueKarte("HERZ","ZEHN");
    Karte k2 = Karte.neueKarte("PIK","BUBE");
    
    s1.kartenhand = new Karte[3];
    s1.kartenhand[0] = k0;
    s1.kartenhand[1] = k1;
    s1.kartenhand[2] = k2;

    Spieler s2 = new Spieler();
    s2.name = "Klaus";
    
    s2.kartenhand = new Karte[3];
    s2.kartenhand[0] = k1;
    s2.kartenhand[1] = k2;
    s2.kartenhand[2] = k0;
    
    Karte k3 = Karte.neueKarte("KARO","ZEHN");

    s1.spiele(k3);
    s2.spiele(k3);
    
  }
}