package Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Bd_Qmq
 * @create 2022-01-23 16:15
 */
public class ArrayUtils {
	public static void shuffle(Comparable[] martix){
		int n = martix.length;
		for (int i = 0; i < n; i++) {
			int changeIndex = n-i-1;
			int random = (int)(Math.random()*changeIndex);
			swap(martix,changeIndex,random);
		}
	}
	public static void swap(Comparable[] martix,int i ,int j){
		Comparable temp = martix[i];
		martix[i] = martix[j];
		martix[j] = temp;
	}

	private static boolean isSorted(Comparable[] martix, int lIndex, int rIndex, boolean orderType) {
		boolean isSorted = true;
		if (orderType) {
			for (int i = 0; i < martix.length - 1; i++) {
				if (martix[i].compareTo(martix[i + 1]) < 0) {
					isSorted = false;
				}
			}
		} else {
			for (int i = 0; i < martix.length - 1; i++) {
				if (martix[i].compareTo(martix[i + 1]) > 0) {
					isSorted = false;
				}
			}
		}
		return isSorted;
	}
	//数组工具类方法校验主函数
/*	public static void main(String[] args) {
		Integer[] martix = {1,3,4,6,7,8,9,4,3,2,1};
		shuffle(martix);
		Arrays.stream(martix).forEach(System.out::println);
	}*/
}
