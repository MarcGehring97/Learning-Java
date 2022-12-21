
public class Multiply4 extends Program {
	public static String name="M4";	
	@Override
	public int calculate(int x, int y) {
		int result=0;
		for(int i=0;i<Math.abs(x);++i) {
			result=result+Math.abs(y);
		}
		if(x<0 || y<0) {
			result=-result;
		}
		return result;
	}

	@Override
	public String getName() {
		return name;
	}

}
