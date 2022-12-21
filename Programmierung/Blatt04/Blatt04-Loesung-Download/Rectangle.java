/**
 * Ein Objekt der Klasse Rectangle repraesentiert ein Rechteck.
 */
public class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Konstruktor fuer ein neues Rechteck.
     * @param xInput der x-Anteil der oberen linken Ecke
     * @param yInput der y-Anteil der oberen linken Ecke
     * @param widthInput die nicht negative Breite
     * @param heightInput die nicht negative Hoehe
     */
    public Rectangle(int xInput, int yInput, int widthInput, int heightInput) {
        if (widthInput < 0 || heightInput < 0) {
            Utils.error("Trying to create rectangle with invalid dimensions: height " +
                        heightInput + ", width " + widthInput);
            return;
        }
        x = xInput;
        y = yInput;
        width = widthInput;
        height = heightInput;     
    }

    /**
     * Konstruktor fuer ein neues Rechteck, das ein Quadrat ist.
     * @param xInput der x-Anteil der oberen linken Ecke
     * @param yInput der y-Anteil der oberen linken Ecke
     * @param sidelengthInput die nicht negative Breite
     */
    public Rectangle(int xInput, int yInput, int sidelengthInput) {
        if (sidelengthInput < 0) {
            Utils.error("Trying to create rectangle with invalid dimension: sidelength " +
                        sidelengthInput);
            return;
        }
        x = xInput;
        y = yInput;
        width = sidelengthInput;
        height = sidelengthInput;  
    }

    /**
     * Erzeugt eine Kopie des uebergebenen Rechtecks.
     * @param toCopy das zu kopierende Rechteck
     * @return eine Kopie des uebergebenen Rechtecks
     */
    public static Rectangle copy(Rectangle toCopy) {
        return new Rectangle(toCopy.getX(), toCopy.getY(), toCopy.getWidth(), toCopy.getHeight());
    }

    /**
     * Liefert die Hoehe dieses Rechtecks.
     * @return die Hoehe dieses Rechtecks
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setzt die Hoehe dieses Rechtecks.
     * @param height die neue, nicht negative Hoehe dieses Rechtecks
     */
    public void setHeight(int height) {
        if (height < 0) {
            Utils.error("Trying to set height to negative value " + height + "!");
        } else {
            this.height = height;
        }
    }

    /**
     * Liefert die Breite dieses Rechtecks.
     * @return die Breite dieses Rechtecks
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setzt die Breite dieses Rechtecks.
     * @param width die neue, nicht negative Breite dieses Rechtecks
     */
    public void setWidth(int width) {
        if (width < 0) {
            Utils.error("Trying to set width to negative value " + width + "!");
        } else {
            this.width = width;
        }
    }

    /**
     * Liefert den x-Anteil der linken oberen Ecke des Rechtecks.
     * @return den x-Anteil der linken oberen Ecke des Rechtecks
     */
    public int getX() {
        return x;
    }

    /**
     * Setzt den x-Anteil der linken oberen Ecke des Rechtecks.
     * @param x der neue x-Anteil der linken oberen Ecke des Rechtecks
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Liefert den y-Anteil der linken oberen Ecke des Rechtecks.
     * @return den y-Anteil der linken oberen Ecke des Rechtecks
     */
    public int getY() {
        return y;
    }

    /**
     * Setzt den y-Anteil der linken oberen Ecke des Rechtecks.
     * @param y der neue y-Anteil der linken oberen Ecke des Rechtecks
     */
    public void setY(int y) {
        this.y = y;
    }

    /* Alle Rechtecke spielen die gleiche Rolle, ohne static
     * suggeriert die Signatur eine "Sonderrolle" von this.
     * Das Rechteck "this" spielt fuer die Methode ausserdem keine Rolle.
    */
    /**
     * Berechnet, ob alle Rechtecke Quadrate sind.
     * @param rectangles alle Rechtecke die betrachtet werden
     * @return true, iff. alle Rechtecke sind Quadrate.
     */
    public static boolean areSquares(Rectangle... rectangles) {
        for (Rectangle r : rectangles) {
            if (r.width != r.height) 
                return false;
        }
        return true;
    }    

     /* Nicht-static. Methode bezieht sich auf dieses konkrete Objekt.
    /**
     * Berechnet die Flaeche dieses Rechteckes
     * @return die Flaeche des Rechteckes
     */
    public int area() {
        return this.width * this.height;
    }   

    /*
     * Liefert den Schnitt zweier Rechtecke zurueck.
     * Wenn der Schnitt leer ist, wird null zurueckgegeben.
     */
    private static Rectangle singleIntersection(Rectangle aRect, Rectangle anotherRect) {
        int nx = Utils.max(aRect.x, anotherRect.x);
        int ny = Utils.min(aRect.y, anotherRect.y);
        int nw = Utils.min(aRect.x + aRect.width, anotherRect.x + anotherRect.width) - nx;
        int nh = ny - Utils.max(aRect.y - aRect.height, anotherRect.y - anotherRect.height);
        if (nw < 0 || nh < 0) {
            return null;
        }
        return new Rectangle(nx, ny, nw, nh);
    }    
    
    /* Alle Rechtecke spielen die gleiche Rolle, ohne static
     * suggeriert die Signatur eine "Sonderrolle" von this.
     * Das Rechteck "this" spielt fuer die Methode ausserdem keine Rolle.
    */
    /**
     * Liefert den Schnitt aller uebergebenen Rechtecke zurueck.
     * @param rectangles jene Rechtecke, deren Schnitt berechnet werden soll
     * @return den Schnitt der uebergebenen Rechtecke oder null, wenn der Schnitt leer ist
     */
    public static Rectangle intersection(Rectangle... rectangles) {
        if (rectangles.length == 0) {
            return null;
        }
        Rectangle res = rectangles[0];
        for (int i = 1; i < rectangles.length; i++) {
            res = singleIntersection(res, rectangles[i]);
            if (res == null) {
                return null;
            }
        }
        return res;
    }

    /**
     * Gibt eine String-Repraesentation dieses Rechtecks zurueck.
     * @return die String-Repraesentation dieses Rechtecks
     */
    public String toString() {
        String res = "";
       
        //Eckpunkt links oben
        res += "(" + x + "|" + y + "),";

        //Eckpunkt links unten
        res += "(" + x + "|" + (y - height) + "),";

        //Eckpunkt rechts unten
        res += "(" + (x + width) + "|" + (y - height) + "),";
        
        //Eckpunkt rechts oben
        res += "(" + (x + width) + "|" + y + ")";

        return res;
    }
}
