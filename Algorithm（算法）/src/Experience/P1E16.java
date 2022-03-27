package Experience;

/**
 * @author Bd_Qmq
 * @create 2022-03-27 20:43
 */
public class P1E16 {
	public static String exR1(int n){
		if (n <= 0){
			return "";
		}
		return exR1(n-3) + n + exR1(n-2) +n;
	}
	public static String exR2(int n){
		String s = exR2(n-3) + n + exR2(n-2) + n;
		//s 的递归参数是逐步递减的，判断条件后于递归的话会让递归无法结束
		if (n <= 0){
			return "";
		}
		return s;
	}
	public static void main(String[] args) {
		System.out.println(exR1(6));
		exR2(6);
	}
}
