package 生成窗口最大值数组;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author QMQ_bd137
 * @create_time is 2022-01-12 14:15
 */
public class getKernelMaxValue {
    public int[] soulution(int[] nums,int kernelValue){
        if (kernelValue>nums.length || kernelValue < 1 || nums == null){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        int[] res = new int[nums.length-kernelValue+1];

        for (int i = 0; i < nums.length; i++) {
            while(!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
//            这种写法会报空指针异常，
//            if (qmax.isEmpty()) {
//                qmax.addLast(i);
//            }else {
//            这个while循环有可能会一直弹出 直到队列为空 因此qmax.peekLast（）就会报空指针异常
//                while (qmax.peekLast() < nums[i]) {
//                    qmax.pollLast();
//                }
//                qmax.addLast(i);
//            }
            if (i - qmax.peekFirst() >=kernelValue){
                qmax.pollFirst();
            }
//          第一个窗口的出现
            if(i>=kernelValue-1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}

