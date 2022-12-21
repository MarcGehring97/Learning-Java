
public class Multiply5 extends Program {
	public static String name="M5";
	@Override
	public int calculate(int x, int y) {
		int result=0;
		for(int i=0;i<Math.abs(x);++i) {
			result=result+y;
		}
		if(x<0) {
			result=-result;
		}
		return result;
	}

	@Override
	public String getName() {
		return name;
	}

}
