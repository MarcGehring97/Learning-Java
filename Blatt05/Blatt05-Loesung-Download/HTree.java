public class HTree {
	private Canvas c;
	
	public static void main(String[] args) {
		HTree t=new HTree();
		t.drawHTree(600,5);
	}
	
	public HTree(){
		c=new Canvas(); //Ausrichtung ist bei Neuerstellung nach unten
	}
	
	/*Diese Methode zeichnet einen H-Tree der Tiefe n. Vor dem Aufruf der Methode 
	muss sichergestellt sein,
	dass die Canvas Zeichenrichtung nach unten gerichtet ist. */ 
	public void drawHTree(int size, int n) {
		if(n<=0) {
			return;
		}
		
		int hs=size/2;
		
		c.push();
		//Zur oberen linken Ecke des Hs bewegen
		c.rotate(90); 
		c.moveForward(hs);
		c.rotate(90);
		c.moveForward(hs);
		
		//Zeichne einen H-Tree der Tiefe n-1 an der oberen linken Ecke. 
		//Beachtet, dass vorher rotiert werden muss, 
		//damit die Ausrichtung nach unten zeigt
		c.rotate(180);
		drawHTree(hs,n-1);

		//Linker Strich des momentan gezeichneten Hs
		c.drawForward(size);
		
		//Zeichne einen H-Tree der Tiefe n-1 an der unteren linken Ecke
		drawHTree(hs,n-1);
		
		//Zur Mitte des linken Striches bewegen
		c.rotate(180);
		c.moveForward(hs);
		
		//Mittelstrich des Hs zeichnen
		c.rotate(90);
		c.drawForward(size);
		
		//Zur oberen rechten Ecke des Hs bewegen
		c.rotate(270);
		c.moveForward(hs);
		
		//Zeichne einen H-Tree der Tiefe n-1 an der oberen rechten Ecke.
		c.rotate(180);
		drawHTree(hs,n-1);
		
		//Rechten Strich des Hs zeichnen
		c.drawForward(size);
		
		//Zeichne einen H-Tree der Tiefe n-1 an der unteren rechten Ecke.
	
		drawHTree(hs,n-1);
		c.pop();
	}
	
	
}

