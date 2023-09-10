package Sort;

import Utils.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Bd_Qmq
 * @create 2022-01-23 15:52
 */
public class QuickSort {

	private static final boolean DESC = false;

	private static final boolean ASC = true;

	public static void sort(Comparable[] martix) {
		ArrayUtils.shuffle(martix);
		sort(martix, 0, martix.length - 1);
	}

	private static void sort(Comparable[] martix, int lIndex, int rIndex) {
		if(lIndex>=rIndex){
			return;
		}
		int keyIndex = partition(martix, lIndex, rIndex);
		sort(martix,lIndex,keyIndex-1);
		sort(martix,keyIndex+1,rIndex);
	}

//	分治的思想 目的是使得数组左边都是小于 关键值 的数；数组右边都是大于 关键值 的数；
	private static int partition(Comparable[] martix, int lIndex, int rIndex) {
		Comparable keyWord = martix[lIndex];
		int lswapIndex = lIndex;
//      Q: 防止数组越界设立该条件,但为什么这么做呢,可以是右坐标从rIndex开始,并且下方循环条件变为 rIndex--的模式?
		/*
		* A: 若从rIndex开始 循环条件为rIndex-- 则无法满足算法运行基本条件，martix[rIdex--] 这种表达式将会造成 循环判定条件中使用的是martix[rIndex]
		* 而下方循环结束判断条件中 将使用rIndex -1 进行判断 提前结束循环,导致分割结果不正确
		*/
		int rswapIndex = rIndex+1;

		while (true) {
//			先对lswaoIndex进行加操作 跳过了key值
			while (martix[++lswapIndex].compareTo(keyWord) <= 0 ) {
				if(lswapIndex == rIndex){
					break;
				}
			}
//			可以有效防止数组越界
			while (martix[--rswapIndex].compareTo(keyWord) > 0 ) {

				if(rswapIndex == lIndex){
					break;
				}
			}
			if ( lswapIndex >= rswapIndex ) break;
			ArrayUtils.swap(martix, lswapIndex, rswapIndex);
		}
		ArrayUtils.swap(martix, lIndex, rswapIndex);
		return rswapIndex;
	}



	public static void main(String[] args) {
		Integer[] martix = {3,4,5,1,2,6,8,9,0,3,5,7,89,0,1,4,6};
		ArrayUtils.shuffle(martix);
		System.out.println("开始数组");
		Arrays.stream(martix).forEach(System.out::println);
		int res = QuickSort.partition(martix,0,0);
		System.out.println(res);
		System.out.println("结束数组");
		Arrays.stream(martix).forEach(System.out::println);
		sort(martix);
		System.out.println("---------------");
		Arrays.stream(martix).forEach(System.out::println);
	}
}
