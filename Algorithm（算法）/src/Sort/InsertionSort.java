package Sort;

import Utils.ArrayUtils;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Bd_Qmq
 * @create 2023-09-16 18:54
 */
public class InsertionSort {
	public static void sort(Comparable[] martix){
		int length = martix.length;
		Stream<Comparable> stream = Arrays.stream(martix);
		System.out.println("排序前顺序:");
		stream.forEach(System.out::println);
		System.out.println("插入排序开始");
		for (int i = 1; i < length; i++) {
			for (int j = i; j > 1; j--) {
				if(martix[j-1].compareTo(martix[j]) > 0){
					ArrayUtils.swap(martix,j-1,j);
				}
			}
		}
		System.out.println("插入排序结束");
		System.out.println("排序后顺序:");
		Arrays.stream(martix).forEach(System.out::println);
	}
	public static void main(String[] args) {
		Integer[] martix = {2,6,3,18,39,30,21,56,32,42};
		sort(martix);
	}
}
