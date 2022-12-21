public class aufgabe3 {
  
  public static void main (String [] arguments) {
    
    int tag = SimpleIO.getInt("Bitte geben Sie die Tageskomponente des Startdatums ein.");
    int monat = SimpleIO.getInt("Bitte geben Sie die Monatskomponente des Startdatums ein.");
    int jahr = SimpleIO.getInt("Bitte geben Sie die Jahreskomponente des Startdatums ein.");
    // Kann man auch einfach int überall nehmen?
    int t = SimpleIO.getInt("Bitte geben Sie die Anzahl an Tagen ein:");
    
    int[] monate = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int zähler = 0;
    
    while (zähler < t) {
        
        tag += 1;
        
        if (tag > monate[monat - 1]) {
            tag = 1;
            monat += 1;
        }
            
        if (monat > 12) {
            monat = 1;
            jahr += 1;
        }
        
        zähler += 1;
    }
    
    System.out.print("Das Datum " + tag + "." + monat + "." + jahr + " befindet sich " + t + " Tage nach dem Startdatum.");
  }

}
