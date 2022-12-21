
public class Multiply3 extends Program {
	public static String name="M3";
	@Override
	public int calculate(int x, int y) {
		int result=0;
		for(int i=0;i<Math.abs(y);++i) {
			result=result+x;
		}
		return result;
	}
	@Override
	public String getName() {
		return name;
	}	
	
}
