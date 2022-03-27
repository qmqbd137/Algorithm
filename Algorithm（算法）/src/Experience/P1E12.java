package Experience;

import java.util.Arrays;

/**
 * @author Bd_Qmq
 * @create 2022-03-27 18:37
 */
public class P1E12 {
	public static void main(String[] args) {
//		数组的重新赋值将注意对原数组的影响
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 9 -i;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[arr[i]];
		}
		Arrays.stream(arr).forEach(System.out::println);
	}
}
