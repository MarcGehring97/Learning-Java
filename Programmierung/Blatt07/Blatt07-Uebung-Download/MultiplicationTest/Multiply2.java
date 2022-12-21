
public class Multiply2 extends Program {
	public static String name="M2";
	@Override
	public int calculate(int x, int y) {
		int result=y;
		for(int i=1;i<Math.abs(x);++i) {
			result=result+y;
		}
		if(x<0) return -result;
		return result;
	}
	@Override
	public String getName() {
		return name;
	}

}
