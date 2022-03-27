package 栈和队列.最大值减去最小值小于或等于num的子数组数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Bd_Qmq
 * @create 2022-02-10 23:54
 */

//解法：维护两个双端队列 最大值队列 和 最小值队列 这样进行一次更新时其代价为O（1）
public class getNum {
	public static int solution(int[] arr, int num){
		if(arr == null || arr.length == 0 || num < 0 ){
			return 0;
		}
		LinkedList<Integer> qmax = new LinkedList<>();
		LinkedList<Integer> qmin = new LinkedList<>();
		//记 arr[i,j]表示从下标 i 到 j的子数组
		int i = 0;
		int j = 0;
		int res = 0;
		while (i < arr.length){
			while (j < arr.length){
				if(qmin.isEmpty() || qmin.peekLast() != j){
					while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
						qmin.pollLast();
					}
					qmin.addLast(j);
					while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
						qmax.pollLast();
					}
					qmax.addLast(j);
				}
				if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
					break;
				}
				j++;
			}
			res += j-i;
			if(qmax.peekFirst() == i){
				qmax.pollFirst();
			}
			if(qmin.peekFirst() == i){
				qmin.pollFirst();
			}
			i++;
		}
		return res;
	}
}
