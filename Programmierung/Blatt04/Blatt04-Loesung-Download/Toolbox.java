/**
 * Objekte dieser Klasse repraesentieren eine beschriftete Werkzeugkiste.
 *
 * In den Faechern koennen je ein einfaches Werkzeug, eine grosse Menge Materialien
 * oder, in drei nebeneinander liegenden Faechern, ein Elektrowerkzeug untergebracht werden.
 */
public class Toolbox {
  /**
   * Anzahl Faecher, die ein Elektrowerkzeug belegt.
   */
  public static final int PowerToolSize = 3;

  /**
   * Array, das die Faecher der Werkzeugkiste repraesentiert.
   */
  private Tool [] tools;
  /**
   * Anzahl freier Faecher in der Werkzeugkiste.
   */
  private int capacity;
  /**
   * Beschriftung der Werkzeugkiste.
   */
  private String name;

  /**
   * Erstelle eine neue, leere Werkzeugkiste mit einer bestimmten Anzahl Faecher
   * @param name Beschriftung der Kiste
   * @param capacity Anzahl Faecher fuer die Kiste
   */
  public Toolbox (String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
    this.tools = new Tool[capacity];
  }
  /**
   * Erstelle eine neue Werkzeugkiste mit festgelegtem Inhalt.
   * @param name Beschriftung der Kiste
   * @param tools Werkzeuge, die in der Kiste enthalten sein sollen.
   */
  public Toolbox (String name, Tool... tools) {
    this.name = name;
    this.capacity = 0;
    this.tools = tools;
    for(Tool tool : tools) {
      if(tool == null) {
        this.capacity += 1;
      }
    }
  }

  /**
   * Lese das Werkzeug im i-ten Fach.
   * @param i Nummer des Fachs
   * @return Das Werkzeug im i-ten Fach
   */
  public Tool getTool(int i) {
    if(0 <= i && i < this.tools.length) {
      return this.tools[i];
    } else {
      return null;
    }
  }

  /**
   * Lese Anzahl freier Faecher
   * @return Anzahl freier Faecher
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Lese Beschriftung
   * @return Beschriftung der Werkzeugkiste
   */
  public String getName() {
    return this.name;
  }
  /**
   * Setze Beschriftung
   * @param name Neue Beschriftung
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Finde den ersten moeglichen Platz fuer ein Elektrowerkzeug.
   * @param index Ausgabeparameter fuer den freien Platz. Falls Rueckgabewert
   *   false ist, dann ist dieser Wert ungueltig.
   * @return ob ein gueltiger Index gefunden wurde.
   */
  private boolean checkRoomForPowerTool(Wrapper index) {
    index.set(0);
    boolean room = true;
    while(index.get() <= this.tools.length - Toolbox.PowerToolSize) {
      for(int j = index.get(); j < index.get() + Toolbox.PowerToolSize; ++j) {
        if(this.tools[j] != null) {
          room = false;
          break;
        }
        room = true;
      }
      if(room) {
        return true;
      }
      index.set(index.get()+1);
    }
    return false;
  }
  
  /**
   * Fuege ein Werkzeug an erster passender Stelle zur Kiste hinzu, falls Platz ist.
   * @param t Das Werkzeug, das hinzugefuegt werden soll.
   */
  public void addTool(Tool t) {
    switch(t) {
      case PowerTool -> {
        Wrapper i = new Wrapper(0);
        if(this.checkRoomForPowerTool(i)) {
          for(int k = 0; k < Toolbox.PowerToolSize; ++k) {
            this.tools[i.get() + k] = t;
          }
          this.capacity -= Toolbox.PowerToolSize;
        }
      }
      case Materials -> {
        for(int k = 0; k < this.tools.length; ++k) {
          if(this.tools[k] == null) {
            this.tools[k] = t;
            this.capacity -= 1;
            break;
          }
          if(this.tools[k] == Tool.Materials) {
            break;
          }
        }
      }
      case SimpleTool -> {
        for(int k = 0; k < this.tools.length; ++k) {
          if(this.tools[k] == null) {
            this.tools[k] = t;
            this.capacity -= 1;
            break;
          }
        }
      }
    }
  }
}